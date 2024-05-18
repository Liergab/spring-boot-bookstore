package com.bookStore.bookStore.controller;
import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //put annotation to know that this class belong to controller
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/")
    public String Home(){
        return "home";
    }

    @GetMapping("/book_register")
    public  String Register(){
        return "bookRegister";
    }


    @GetMapping("/available_books")
    public  String getAllBooks(){
        return "bookList";
    }

    @PostMapping("/save")
    public  String addBook(@ModelAttribute Book b){
        service.save(b);
        return "redirect:/available_books";
    }
}
