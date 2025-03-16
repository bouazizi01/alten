package com.ecom.alten;

import com.ecom.alten.auth.AuthenticationService;
import com.ecom.alten.auth.RegisterRequest;
import com.ecom.alten.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
        System.out.println("Start .........");
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .username("Admin")
                    .firstname("Admin")
                    .email("admin@alten.com")
                    .password("password")
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var manager = RegisterRequest.builder()
                    .firstname("Admin")
                    .username("Admin")
                    .email("manager@alten.com")
                    .password("password")
                    .build();
            System.out.println("Manager token: " + service.register(manager).getAccessToken());

        };
    }

}
