package com.springBoot.dto;


import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Rest API Document",
				description = "User Management System APIs using Spring Boot",
				version = "v1.0",
				contact = @Contact(
						name = "Amit Kumar Pandey",
						email = "amitkumar.pandey052001@gmail.com",
						url = "https://www.auser.managementAPI.net"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.auser.managementAPI.net/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "User Management System API Document",
				url = "https://www.auser.managementAPI.net/user_management.html"
		)
)
public class SpringBootDtoProjectApplication {
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDtoProjectApplication.class, args);
	}

}
