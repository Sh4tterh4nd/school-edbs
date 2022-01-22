package edbs;

import edbs.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class Starter {
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(Starter.class);
    }
}
