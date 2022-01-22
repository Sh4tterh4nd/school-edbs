package edbs.controller;

import edbs.entity.Book;
import edbs.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EdbsRestController {

    public EdbsRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private BookRepository bookRepository;



    @GetMapping("/find/{author}")
    public List<Book> getAuthors(@PathVariable("author") String author){
        return bookRepository.findBooksByAuthor(author);
    }
}
