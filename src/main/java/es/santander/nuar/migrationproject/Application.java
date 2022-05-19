package es.santander.nuar.migrationproject;

import es.santander.nuar.cache.CachingConfigurerNoFatalErrors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Application extends CachingConfigurerNoFatalErrors {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public static void printLine(final String line) {
		System.out.println(line);
	}

}
