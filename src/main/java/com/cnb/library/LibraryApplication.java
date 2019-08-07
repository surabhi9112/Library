package com.cnb.library;

import com.cnb.library.service.BookService;
import com.cnb.library.model.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import jdk.internal.org.objectweb.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;


@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);


    }

    @Bean
    CommandLineRunner runner(BookService bookService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<Book> typeReference = new TypeReference<Book>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("json/Book.json");
            System.out.println(inputStream);
            try {
                Book books = mapper.readValue(inputStream,typeReference);
                //bookService.save(books);
                System.out.println("Books Saved!");
            } catch (IOException e){
                System.out.println("Unable to save books: " + e.getMessage());
            }
        };
    }




}




