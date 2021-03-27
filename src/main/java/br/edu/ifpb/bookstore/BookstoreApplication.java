package br.edu.ifpb.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import br.edu.ifpb.bookstore.repositorio.AutorRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
	}

}
