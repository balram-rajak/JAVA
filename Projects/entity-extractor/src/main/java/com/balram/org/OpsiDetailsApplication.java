package com.balram.org;

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
import org.springframework.beans.factory.annotation.Value;
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

@SpringBootApplication
public class OpsiDetailsApplication {

	private String OpsiId = null;

	@Value("${api.url}")
	String url;

	@Autowired
	private Environment environment;

	static final Logger log = LoggerFactory.getLogger(OpsiDetailsApplication.class);

	// getting credentials from spring environment
	private static final Function<Environment, String> getCredentials = t -> t.getProperty("reltio.uname") + ":"
			+ t.getProperty("reltio.pass");

	// to encode credentials with Base64
	private static UnaryOperator<String> getEncodedCredentials = t -> new String(
			Base64.encodeBase64String(t.getBytes()));

	// method to get the http header for token request
	private static Function<String, HttpHeaders> getTokenAuthorisationHeaders = t -> {
		HttpHeaders header = new HttpHeaders();

		header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		header.setAccept(Arrays.asList(MediaType.ALL));
		header.add("Authorization", "Basic " + t);
		header.add("Host", "auth.reltio.com");

		return header;
	};

	// method to get the token http entity
	private static Function<HttpHeaders, HttpEntity<?>> getTokenRequest = t -> {

		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("grant_type", "client_credentials");

		HttpEntity<?> httpEntity = new HttpEntity<Object>(body, t);
		return httpEntity;
	};

	// method to get response token
	static private BiFunction<HttpEntity<?>, RestTemplate, ResponseEntity<Token>> getToken = (t, restTemplate) -> {

		return restTemplate.exchange("https://auth.reltio.com/oauth/token",
				HttpMethod.POST, t, Token.class);

	};

	// Method to get set authorization token into opsi request header
	private static Function<String, HttpHeaders> getOpsiAuthorisationHeader = t -> {

		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "Bearer " + t);
		header.add("Host", "test.reltio.com");
		return header;

	};

	// method to get get http entity for Opsi request
	static private Function<HttpHeaders, HttpEntity<?>> getOpsiRequest = t -> {

		HttpEntity<?> httpEntity = new HttpEntity<Object>(t);
		return httpEntity;
	};

	// method to get Opsi details as response
	private BiFunction<HttpEntity<?>, RestTemplate, ResponseEntity<String>> getOpsiDetails = (t,
			OpsiTemplate) -> {

		return OpsiTemplate.exchange(
				String.format(url, OpsiId), HttpMethod.GET, t, String.class);

	};

	// getting code from Authentication token response body
	static private Function<ResponseEntity<Token>, String> getTokenCode = t -> t.getBody().getAccess_token();

	static private Predicate<String> checkIdExists = t -> t != null;

	BiPredicate<Environment, ResponseEntity<String>> saveOpsiToFile = (t, opsiResponseEntity) -> {

		String opsiFileName = String.format("./",
				OpsiId);
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
