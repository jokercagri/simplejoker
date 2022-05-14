package com.cagri.joker.api.configuration;

import java.util.Arrays;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	@Bean
	@Primary
	public RestTemplate restTemplate(
		RestTemplateBuilder restTemplateBuilder,
		RequestResponseLoggingInterceptor requestResponseLoggingInterceptor){
		RestTemplate restTemplate = restTemplateBuilder.build();
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory = new BufferingClientHttpRequestFactory(
				requestFactory);
		requestFactory.setOutputStreaming(false);
		restTemplate.setRequestFactory(bufferingClientHttpRequestFactory);
		restTemplate.setInterceptors(Arrays.asList(requestResponseLoggingInterceptor));
		return restTemplate;
	}

}
