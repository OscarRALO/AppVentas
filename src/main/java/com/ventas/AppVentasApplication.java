package com.ventas;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AppVentasApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
						.ignoreIfMissing()
						.load();

		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey() ,entry.getValue())
		);
		SpringApplication.run(AppVentasApplication.class, args);
	}


	// Configurar CORS globalmente para la comunicación con el frontend Angular
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurer() {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**")
	.allowedOrigins("http://localhost:4200") // Permitir solicitudesdesde localhost:4200
	.allowedMethods("*")// Permitir todos los métodos HTTP
	.allowedHeaders("*");// Permitir todos los encabezados HTTP
	}
	};
	}

}
