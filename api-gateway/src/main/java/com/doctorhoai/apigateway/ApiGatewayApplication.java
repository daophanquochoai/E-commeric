package com.doctorhoai.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder routeLocatorBuilder
	){
		return routeLocatorBuilder.routes()
				.route(
						p -> p
								.path("/doctorhoai/product/**")
								.filters(
										f -> f
												.rewritePath("/doctorhoai/product/(?<segment>.*)", "/${segment}")
												.addRequestHeader("X-Response-Time", LocalDateTime.now().toString())
												.circuitBreaker(
														config ->config.setName("productCircuitBreaker")
																.setFallbackUri("forward:/contactSupport")
												)
								)
								.uri("lb://PRODUCTSERVICE")
				)
				.route(
						p -> p
								.path("/doctorhoai/favourite/**")
								.filters(
										f -> f
												.rewritePath("/doctorhoai/favourite/(?<segment>.*)", "/${segment}")
												.addRequestHeader("X-Response-Time", LocalDateTime.now().toString())
												.circuitBreaker(
														config ->config.setName("favouriteCircuitBreaker")
																.setFallbackUri("forward:/contactSupport")
												)
								)
								.uri("lb://FAVOURITESERVICE")
				)
				.route(
						p -> p
								.path("/doctorhoai/order/**")
								.filters(
										f -> f
												.rewritePath("/doctorhoai/order/(?<segment>.*)", "/${segment}")
												.addRequestHeader("X-Response-Time", LocalDateTime.now().toString())
												.circuitBreaker(
														config ->config.setName("orderCircuitBreaker")
																.setFallbackUri("forward:/contactSupport")
												)
								)
								.uri("lb://ORDERSERVICE")
				)
				.route(
						p -> p
								.path("/doctorhoai/shipping/**")
								.filters(
										f -> f
												.rewritePath("/doctorhoai/shipping/(?<segment>.*)", "/${segment}")
												.addRequestHeader("X-Response-Time", LocalDateTime.now().toString())
												.circuitBreaker(
														config ->config.setName("shippingCircuitBreaker")
																.setFallbackUri("forward:/contactSupport")
												)
								)
								.uri("lb://SHIPPINGSERVICE")
				)
				.route(
						p -> p
								.path("/doctorhoai/user/**")
								.filters(
										f -> f
												.rewritePath("/doctorhoai/user/(?<segment>.*)", "/${segment}")
												.addRequestHeader("X-Response-Time", LocalDateTime.now().toString())
												.circuitBreaker(
														config ->config.setName("userCircuitBreaker")
																.setFallbackUri("forward:/contactSupport")
												)
								)
								.uri("lb://USERSERVICE")
				)
				.build();
	}

	@Bean
	public GlobalFilter customGlobalFilter() {
		return (exchange, chain) -> {
			System.out.println("Request Path: " + exchange.getRequest().getPath());
			return chain.filter(exchange)
					.then(Mono.fromRunnable(() -> {
						System.out.println("Response Status Code: " + exchange.getResponse().getStatusCode());
					}));
		};
	}


}
