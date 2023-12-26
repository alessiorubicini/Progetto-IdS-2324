package it.unicam.cs.opencity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class OpencityApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpencityApplication.class, args);
	}

}
