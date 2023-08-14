package com.Alfaro.CrudCars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CrudCarsApplication {
	public CrudCarsApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudCarsApplication.class, args);
	}
}

