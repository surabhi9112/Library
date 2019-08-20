package com.cnb.library.controller;


import com.cnb.library.dto.BookDTO;
import com.cnb.library.model.BookIssue;
import com.cnb.library.model.Location;
import com.cnb.library.repo.Bookrepo;
import com.cnb.library.service.BookIssueService;
import com.cnb.library.service.BookService;
import com.cnb.library.model.Book;
import com.cnb.library.service.LocationService;
import feign.Param;
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

    private LocationService locationService;

    private BookIssueService bookIssueService;


    @Autowired
    public BookController(BookService bookService, Bookrepo bookrepo, LocationService locationService,BookIssueService bookIssueService) {
            this.bookService = bookService;
            this.bookrepo = bookrepo;
            this.locationService= locationService;
            this.bookIssueService=bookIssueService;

        }
        @GetMapping(value = "/")
        public Iterable<Book> list () {
            return bookService.list();
        }


        @PutMapping(value = "/{id}", consumes = "application/json")
        public Book updateBook(@PathVariable long id, @RequestBody Book book){
        logger.info("update book" + book);
       return bookService.updateBook(id, book);
        }

     @GetMapping(value = "{id}/location")
     public Location getBookLocation (@PathVariable Long id){
        return locationService.findBookLocation(id);

      }

     @PutMapping(value = "/{bookId}/location", consumes = "application/json")
      public void updateLocation (@PathVariable Long bookId ,@RequestBody Location location){
        locationService.updateLocation(bookId, location);
        }

        @GetMapping(value = "{id}/bookIssue")
       public BookIssue getBookIssueHistory(@PathVariable Long id){
        return bookIssueService.findBookIssueHistory(id);
    }

     @PutMapping(value = "/{id}/bookIssue")
      public void updateBookIssued(@PathVariable Long id, @RequestBody BookIssue bookIssue){
        logger.info("bookIssued updated"+bookIssue);
        bookIssueService.updateBookIssued(id,bookIssue);

    }

     @DeleteMapping(value = "/{id}")
     public void deleteBook ( long id){
            bookService.removeBook(id);
        }


 }
