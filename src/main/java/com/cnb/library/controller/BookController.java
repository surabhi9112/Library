package com.cnb.library.controller;


import com.cnb.library.repo.Bookrepo;
import com.cnb.library.service.BookService;
import com.cnb.library.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")

public class BookController  {
    public final Logger logger = LoggerFactory.getLogger(BookController.class);

    private BookService bookService;

    private Bookrepo bookrepo;





    @Autowired
    public BookController(BookService bookService, Bookrepo bookrepo) {
            this.bookService = bookService;
            this.bookrepo = bookrepo;

        }
        @GetMapping(value = "/")
        public Iterable<Book> list () {
            return bookService.list();
        }

        @GetMapping(value = "{id}/location")
        public Long getBookLocation (@PathVariable Long id){
        return bookService.findBookLocation(id);

        }


        @PutMapping(value = "/{id}")
        public Book update (@PathVariable Long id){
             return  bookService.update(id);


        }

        @DeleteMapping(value = "/{id}")
        public void deleteBook ( long id){
            bookService.removeBook(id);
        }


}
