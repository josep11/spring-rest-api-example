package com.freseniuskabi.main;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.freseniuskabi.bgtask.BgTask;
import com.freseniuskabi.models.Paciente;
import com.freseniuskabi.service.IPacienteService;

@SpringBootApplication
// super important, tell spring where to auto-config components
@ComponentScan("com.freseniuskabi.*")
@EntityScan(basePackages = { "com.freseniuskabi.models" })
public class Application {

	@Autowired
	private IPacienteService pacienteService;

	@Autowired
	private BgTask bgtask;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init() {
		this.bgtask.sayHi();
		return (evt) -> Arrays.asList("Darwin,Lange".split(",")).forEach(a -> {
			this.pacienteService.save(new Paciente(a, "password"));
		});
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				if (beanName.toLowerCase().contains("bgtask")) {
					System.out.println(beanName);
				}
			}
		};
	}

}