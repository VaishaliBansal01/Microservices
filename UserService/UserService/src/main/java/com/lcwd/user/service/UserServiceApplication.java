package com.lcwd.user.service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(
        info = @Info(
                title ="For Swagger Project",
                version = "1.0.0",
                description = "poject implementation done only for learning swagger",
                termsOfService = "only till practice",
                contact = @Contact(
                   name = "Miss Vaishali Bansal",
                    email = "vaishali.bansal@gmail.com"
                ),
                license = @License(
                   name = "license",
                   url = "swaggerurl"
                )
        )

)
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
