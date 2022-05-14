package com.cagri.joker.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.cagri.joker.api.configuration.ApplicationProperties;

/**
 * Customer Api For Exam
 *
 */
@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
@ComponentScan
public class App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
}
