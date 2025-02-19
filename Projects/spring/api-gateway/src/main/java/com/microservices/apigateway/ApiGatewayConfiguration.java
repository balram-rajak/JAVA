package com.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(t -> t.path("/get")
						.filters(f -> f.addRequestHeader("grant_type", "client_credentials")
								.addRequestParameter("client_id", "0001"))
						.uri("http://httpbin.org:80")
						)
				.route(t -> t.path("/currency-exchange/**")
						.filters(f -> f.addResponseHeader("token", "@o8293j729n"))
						.uri("lb://currency-exchange"))
				.route(t -> t.path("/currency-conversion/**")
						.uri("lb://currency-conversion"))
				.route(t -> t.path("/currency-conversion-feign/**")
						.uri("lb://currency-conversion"))
				.route(t -> t.path("/currency-conversion-local/**")
						.filters(p -> p.rewritePath("/currency-conversion-local/(?<segment>.*)"
								, "/currency-conversion-feign/${segment}"))
						
						.uri("lb://currency-conversion"))

				.build();
		
	}
}
