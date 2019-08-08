package com.cnb.library.controller;


import com.cnb.library.service.BookService;
import com.cnb.library.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")

public class BookController {
    public final Logger logger = LoggerFactory.getLogger(BookController.class);

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService ){
        this.bookService = bookService;

    }
    @GetMapping(value = "/")
    public Iterable<Book> list(){
        return bookService.list();
    }

    @GetMapping(value = "/{id}/location")
    public String findBookLocation(String id){
        return bookService.findBookLocation(id);
    }

    @PostMapping(value = "/")
    public Book addBook(Book books){
        return bookService.addBook(books);
   }

    @PutMapping(value = "/{id}")
    public Book update(@PathVariable Long id){
        return bookService.update(id);
   }


   @DeleteMapping(value = "/{id}")
    public void deleteBook(long id){
        bookService.removeBook(id);
   }
}
