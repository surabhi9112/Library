package com.cnb.library.controller;


import com.cnb.library.dto.BookDTO;
import com.cnb.library.model.Location;
import com.cnb.library.repo.Bookrepo;
import com.cnb.library.service.BookService;
import com.cnb.library.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
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
        public Location getBookLocation (@PathVariable Long id){
        return bookService.findBookLocation(id);

    }

        @PutMapping(value = "/{id}", consumes = "application/json")
        public Book updateBook(@PathVariable long id, @RequestBody Book book){
        logger.info("update book" + book);
       return bookService.updateBook(id, book);
        }

        @PutMapping(value = "/{id}/location" )
        public Location updateLocation (@PathVariable long id ,@RequestBody Location location){
               return bookService.updateLocation(id, location);
    }

        @DeleteMapping(value = "/{id}")
        public void deleteBook ( long id){
            bookService.removeBook(id);
        }


}
