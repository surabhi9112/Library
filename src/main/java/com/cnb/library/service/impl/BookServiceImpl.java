package com.cnb.library.service.impl;


import com.cnb.library.dto.BookDTO;
import com.cnb.library.model.Book;
import com.cnb.library.model.Location;
import com.cnb.library.model.Status;
import com.cnb.library.repo.Bookrepo;
import com.cnb.library.repo.LocationRepo;
import com.cnb.library.service.BookService;
import org.slf4j.spi.LocationAwareLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private Bookrepo bookrepo;

    private LocationRepo locationRepo;


    @Autowired
    public BookServiceImpl(Bookrepo bookrepo, LocationRepo locationRepo){
        this.bookrepo=bookrepo;
        this.locationRepo = locationRepo;



    }

    public Iterable<Book> list(){
        return bookrepo.findAll();
    }


    public Book addBook(Book books){

        return bookrepo.save(books);

    }

   public Book updateBook(long id, Book book){

      /* return bookrepo.findById(id)
               .map(book1 -> {
                   book.setISBN(book.getName());
                   book.setName(book.getName());
                   book.setAuthorFirstName(book.getAuthorFirstName());
                   book.setAuthorLastName(book.getAuthorLastName());
                   return bookrepo.save(book1);
               })
               .orElseGet(() -> {
                   book.setId(id);
                   return bookrepo.save(book);
               });*/
        Book book1 = findBookById(id);

        book1.setId(id);
        book1.setISBN("123");
        book1.setName("Mani");
        book1.setAuthorFirstName("sk");
        book1.setAuthorLastName("df");

        return bookrepo.save(book1);

   }


   public Location addLocation(Location location){
        return  locationRepo.save(location);
   }


   public Location updateLocation(long id, Location location){
        Location location1 = getLocation(id);
        location1.setRowNum(1L);

        return locationRepo.save(location1);


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

    public Location findBookLocation(long id){
        Location location = getLocation(id);
        return location;


    }
   public  Location getLocation(Long id){
        Optional<Location> location = locationRepo.findById(id);
        return  location.get();

   }






}
