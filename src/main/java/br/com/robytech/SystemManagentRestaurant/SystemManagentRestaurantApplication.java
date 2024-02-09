package br.com.robytech.SystemManagentRestaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport 
public class SystemManagentRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemManagentRestaurantApplication.class, args);
	}

}
