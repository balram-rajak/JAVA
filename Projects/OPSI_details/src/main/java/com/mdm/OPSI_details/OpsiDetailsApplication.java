package com.mdm.OPSI_details;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

/**
 * Spring Boot application to fetch OPSI (Organization, Party, Site, Individual)
 * entity details from Reltio MDM.
 * Uses functional programming approach with Java 8 functional interfaces.
 * 
 * Workflow:
 * 1. Authenticates with Reltio OAuth API to get access token
 * 2. Reads multiple OPSI IDs from application.properties
 * 3. Fetches OPSI details for each ID from Reltio MDM API
 * 4. Saves each OPSI response as a formatted JSON file
 * 
 * @author Balram Rajak
 */
@SpringBootApplication
public class OpsiDetailsApplication {

	/** Current OPSI ID being processed */
	private static String OpsiId = null;

	/** Spring environment for accessing configuration properties */
	@Autowired
	private Environment environment;

	/** SLF4J logger instance */
	static final Logger log = LoggerFactory.getLogger(OpsiDetailsApplication.class);

	/**
	 * Functional interface to extract credentials from Spring environment.
	 * Formats: "username:password"
	 */
	private static final Function<Environment, String> getCredentials = t -> t.getProperty("reltio.uname") + ":"
			+ t.getProperty("reltio.pass");

	/**
	 * Functional interface to encode credentials using Base64.
	 * Required for Basic Authentication header.
	 */
	private static UnaryOperator<String> getEncodedCredentials = t -> new String(
			Base64.encodeBase64String(t.getBytes()));

	/**
	 * Creates HTTP headers for OAuth token request.
	 * Sets Basic Authentication with encoded credentials.
	 * 
	 * @param encoded Base64 encoded credentials
	 * @return HttpHeaders configured for token request
	 */
	private static Function<String, HttpHeaders> getTokenAuthorisationHeaders = t -> {
		HttpHeaders header = new HttpHeaders();

		header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		header.setAccept(Arrays.asList(MediaType.ALL));
		header.add("Authorization", "Basic " + t);
		header.add("Host", "auth.reltio.com");

		return header;
	};

	/**
	 * Creates HTTP entity for token request with form-encoded body.
	 * Body contains grant_type=client_credentials for OAuth 2.0.
	 * 
	 * @param headers HTTP headers with authentication
	 * @return HttpEntity ready for token request
	 */
	private static Function<HttpHeaders, HttpEntity<?>> getTokenRequest = t -> {

		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("grant_type", "client_credentials");

		HttpEntity<?> httpEntity = new HttpEntity<Object>(body, t);
		return httpEntity;
	};

	/**
	 * Calls Reltio OAuth API to retrieve authentication token.
	 * 
	 * @param httpEntity   Request entity with credentials
	 * @param restTemplate Spring RestTemplate instance
	 * @return ResponseEntity containing Token object
	 */
	static private BiFunction<HttpEntity<?>, RestTemplate, ResponseEntity<Token>> getToken = (t, restTemplate) -> {

		return restTemplate.exchange("https://auth.reltio.com/oauth/token",
				HttpMethod.POST, t, Token.class);

	};

	/**
	 * Creates HTTP headers for OPSI details request.
	 * Sets Bearer token for API authorization.
	 * 
	 * @param token OAuth access token
	 * @return HttpHeaders configured with Bearer token
	 */
	private static Function<String, HttpHeaders> getOpsiAuthorisationHeader = t -> {

		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "Bearer " + t);
		header.add("Host", "test.reltio.com");
		return header;

	};

	/**
	 * Creates HTTP entity for OPSI details request.
	 * 
	 * @param headers HTTP headers with Bearer token
	 * @return HttpEntity for OPSI request
	 */
	static private Function<HttpHeaders, HttpEntity<?>> getOpsiRequest = t -> {

		HttpEntity<?> httpEntity = new HttpEntity<Object>(t);
		return httpEntity;
	};

	/**
	 * Fetches OPSI entity details from Reltio MDM API.
	 * Filters entities by type and ID.
	 * 
	 * @param httpEntity   Request entity with authorization
	 * @param restTemplate Spring RestTemplate instance
	 * @return ResponseEntity containing OPSI details as JSON string
	 */
	static private BiFunction<HttpEntity<?>, RestTemplate, ResponseEntity<String>> getOpsiDetails = (t,
			OpsiTemplate) -> {

		return OpsiTemplate.exchange(
				"https://test.reltio.com/reltio/api/287t46vb8oiudXlt/entities?filter=" +
						"(equals(type,'configuration/entityTypes/OPSI') and " +
						"equals(attributes.ID," + OpsiId + ")),preserveURIs",
				HttpMethod.GET, t, String.class);

	};

	/**
	 * Extracts access token string from token response.
	 */
	static private Function<ResponseEntity<Token>, String> getTokenCode = t -> t.getBody().getAccess_token();

	/**
	 * Predicate to check if OPSI ID exists in configuration.
	 */
	static private Predicate<String> checkIdExists = t -> t != null;

	/**
	 * Saves OPSI response to a JSON file with pretty printing.
	 * File is named using pattern: ID-{opsiId}.json
	 * 
	 * @param environment        Spring environment (unused but kept for signature)
	 * @param opsiResponseEntity Response containing OPSI data
	 * @return true if save successful, false otherwise
	 */
	static BiPredicate<Environment, ResponseEntity<String>> saveOpsiToFile = (t, opsiResponseEntity) -> {

		String opsiFileName = String
				.format("/Users/rakesh/eclipse-workspace/OPSI_details/src/main/resources/ID-%s.json", OpsiId);
		JsonMapper Obj = new JsonMapper();

		Object json;
		try {
			json = Obj.readValue(opsiResponseEntity.getBody(), Object.class);
		} catch (JsonProcessingException e1) {
			json = null;
			e1.printStackTrace();
		}

		try {
			FileOutputStream fin = new FileOutputStream(new File(opsiFileName));

			Obj
					.writerWithDefaultPrettyPrinter()
					// .writeValue(fin,opsiResponseEntity.getBody());
					.writeValue(fin, json);

			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	};

	@Bean
	RestTemplate getOpsiTemplate() {
		return new RestTemplate();

	}

	@Bean
	CommandLineRunner saveOpsiData(RestTemplate OpsiTemplate) throws Exception {
		return args -> {

			String token = getToken.andThen(getTokenCode)
					.apply(getCredentials.andThen(getEncodedCredentials).andThen(getTokenAuthorisationHeaders)
							.andThen(getTokenRequest)
							.apply(environment), OpsiTemplate);

			for (int i = 1;; i++) {
				OpsiId = environment.getProperty("id." + i + "");
				if (checkIdExists.test(OpsiId)) {

					ResponseEntity<String> opsiResponseEntity = getOpsiDetails
							.apply(getOpsiAuthorisationHeader.andThen(getOpsiRequest).apply(token), OpsiTemplate);

					if (saveOpsiToFile.test(environment, opsiResponseEntity))
						log.info("Opsi_done: " + OpsiId);

				} else
					break;
			}

		};

	}

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(OpsiDetailsApplication.class, args);
		context.close();

	}
}
