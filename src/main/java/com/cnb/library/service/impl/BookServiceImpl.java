package com.cnb.library.service.impl;


import com.cnb.library.model.Book;
import com.cnb.library.model.Status;
import com.cnb.library.repo.Authorrepo;
import com.cnb.library.repo.Bookrepo;
import com.cnb.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private Bookrepo bookrepo;

    private Authorrepo authorrepo;



    @Autowired
    public BookServiceImpl(Bookrepo bookrepo, Authorrepo authorrepo){
        this.bookrepo=bookrepo;
        this.authorrepo=authorrepo;

    }

    public Iterable<Book> list(){
        return bookrepo.findAll();
    }



   public Book addBook(Book books){

        Book book = Book.builder()
                .ISBN("12A")
               .name("Last Leave")
               .authorFirstName("surabhi")
                .authorLastName("sharma")
                .status(Status.AVAILABLE)
                .build();

        return bookrepo.save(book);


   }

   public Book update( Long id){

        Book book = findBookById(id);
        book.setISBN("ijj8");
        book.setName("ram");
        book.setAuthorFirstName("Amish");
        book.setAuthorLastName("Tripathi");
         book.setStatus(Status.ISSUED);

        return bookrepo.save(book);

    }

    public Book findBookById(Long id){
        Optional<Book>  book = bookrepo.findById(id);
        return book.get();

    }

    public void removeBook(long id){
        bookrepo.deleteById(id);
    }

}
