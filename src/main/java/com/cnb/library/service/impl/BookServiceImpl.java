package com.cnb.library.service.impl;


import com.cnb.library.model.Book;
import com.cnb.library.model.Status;
import com.cnb.library.repo.Bookrepo;
import com.cnb.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private Bookrepo bookrepo;


    @Autowired
    public BookServiceImpl(Bookrepo bookrepo){
        this.bookrepo=bookrepo;



    }

    public Iterable<Book> list(){
        return bookrepo.findAll();
    }



   public Book addBook(Book books){

//        Book book = Book.builder()
//                .ISBN("12A")
//                .name("Last Leave")
//                .authorFirstName("surabhi")
//                .authorLastName("sharma")
//                .status(Status.AVAILABLE)
//                .shelfNum("A")
//                .rowNum("1")
//                .columnNum("1")
//                .build();

        return bookrepo.save(books);


   }

   public Book update( Long id){

        Book book = findBookById(id);
        book.setAuthorLastName("adf");
       return bookrepo.save(book);

    }

    public Book findBookById(Long id){


        Optional<Book> book = bookrepo.findById(id);

        if (!book.isPresent())
            throw new EntityNotFoundException("Book with id : " + id + " does not exist");

        return book.get();


    }

    public void removeBook(long id){

        bookrepo.deleteById(id);
    }

    public Long findBookLocation(Long id){
        Book book = findBookById(id);
        return book.getShelfNum();

   }






}
