package com.pacto;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PactoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PactoApplication.class, args);
	}

}
