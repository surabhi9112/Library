package com.cnb.library;


import com.cnb.library.model.Book;
import com.cnb.library.model.BookIssue;
import com.cnb.library.model.Location;
import com.cnb.library.repo.Bookrepo;
import com.cnb.library.service.BookIssueService;
import com.cnb.library.service.BookService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;


@SpringBootApplication(exclude = BatchAutoConfiguration.class)
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);


    }



    @Bean
  CommandLineRunner runner(BookService bookService, BookIssueService bookIssueService) {
        return args -> {
            // read json and write to db
              Logger logger = LoggerFactory.getLogger(this.getClass());

           ObjectMapper mapper = new ObjectMapper();
            Book book = mapper.readValue(new File("src/main/resources/json/book.json"), Book.class);
            logger.info(book.toString());
            bookService.addBook(book);



            ObjectMapper mapper1 = new ObjectMapper();
            Location location = mapper1.readValue(new File("src/main/resources/json/location.json"), Location.class);
            logger.info(location.toString());
            bookService.addLocation(location);


            ObjectMapper mapper2 = new ObjectMapper();
            BookIssue bookIssue = mapper2.readValue(new File("src/main/resources/json/bookIssue.json"), BookIssue.class);
            logger.info(bookIssue.toString());
            bookIssueService.addBookIssue(bookIssue);




        };
   }
}









