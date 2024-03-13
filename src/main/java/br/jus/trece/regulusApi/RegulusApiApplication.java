package br.jus.trece.regulusApi;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/*@EntityScan({"br.jus.trece.regulusApi.db.juris.domain", "br.jus.trece.regulusApi.db.regulus.domain"})
@EnableJpaRepositories*/
//({"br.jus.trece.regulusApi.db.regulus.repo", "br.jus.trece.regulusApi.db.juris.repo"})
public class RegulusApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegulusApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}
