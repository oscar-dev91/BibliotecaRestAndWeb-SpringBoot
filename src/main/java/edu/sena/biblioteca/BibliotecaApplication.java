package edu.sena.biblioteca;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaApplication {

    public static void main(String[] args) {

        // 👇 Cargar variables .env ANTES de que Spring lea application.properties
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing() // por si no está el archivo
                .load();

        // 👇 Cargar manualmente en el sistema
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

        SpringApplication.run(BibliotecaApplication.class, args);
    }
}
