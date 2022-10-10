package com.example.introJOOQ;

;
import org.jooq.codegen.GenerationTool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class IntroJooqApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroJooqApplication.class, args);
	}

}
