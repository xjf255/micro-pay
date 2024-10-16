package com.project.micro_pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MicroPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroPayApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer conrsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// /** => permite CORS en todas las rutas de la aplicacion
				registry.addMapping("/**").allowedOrigins("*")
				.allowedMethods("GET", "POST", "PUT", "DELETE")
				.allowedHeaders("*");
			}
		};
	}
}
