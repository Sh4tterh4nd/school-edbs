package edbs.controller;

import edbs.entity.Book;
import edbs.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private BookRepository bookRepository;


    public MainController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public String main (Model model){
        model.addAttribute("books",bookRepository.findAll());
        return "main";
    }


    @PostMapping("/book/")
    public String insert(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long bookId){
        bookRepository.deleteById(bookId);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit (@PathVariable("id") Long bookId, Model model){
        model.addAttribute("book",bookRepository.findById(bookId).orElse(new Book()));
        return "edit";
    }
}
