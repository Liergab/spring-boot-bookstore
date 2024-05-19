package com.bookStore.bookStore.controller;
import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.entity.MyBookList;
import com.bookStore.bookStore.service.BookService;
import com.bookStore.bookStore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller //put annotation to know that this class belong to controller
public class BookController {
    @Autowired
    private BookService service;

    @Autowired
    private MyBookListService myBookService;

    @GetMapping("/")
    public String Home(){
        return "home";
    }

    @GetMapping("/book_register")
    public  String Register(){
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBooks(){
       List<Book> list = service.getAllBooks();
       return new ModelAndView("bookList","book", list);
    }

    @GetMapping("/my_books")
    public ModelAndView getMyBooks(){
        List<MyBookList> list = myBookService.getAllMyBooks();
        return new ModelAndView("myBooks","book", list);
    }

    @PostMapping("/save")
    public  String addBook(@ModelAttribute Book b){
        service.save(b);
        return "redirect:/available_books";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b = service.getBookById(id);
        MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
        myBookService.saveMyBook(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/deleteBook/{id}")

    public String deleteBookById(@PathVariable("id") int id){
        service.deleteBookById(id);
        return "redirect:/available_books";
    }

    @RequestMapping("/editBook/{id}")

    public ModelAndView editBooks(@PathVariable("id") int id ){
        Book b = service.getBookById(id);
       return new ModelAndView("bookEdit", "book", b);
    }

}
