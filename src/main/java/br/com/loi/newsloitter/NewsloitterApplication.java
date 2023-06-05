package br.com.loi.newsloitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NewsloitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsloitterApplication.class, args);
	}

}
