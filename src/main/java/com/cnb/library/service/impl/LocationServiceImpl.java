package com.cnb.library.service.impl;


import com.cnb.library.model.Book;
import com.cnb.library.model.Location;
import com.cnb.library.repo.Bookrepo;
import com.cnb.library.repo.LocationRepo;
import com.cnb.library.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepo locationRepo;

    private Bookrepo bookrepo;

    @Autowired
    public LocationServiceImpl(LocationRepo locationRepo,Bookrepo bookrepo ){
        this.locationRepo=locationRepo;
        this.bookrepo=bookrepo;
    }

    public void updateLocation(long bookId, Location location){

        Optional<Book> optionalBook = bookrepo.findById(bookId);

        Book book = optionalBook.get();

        book.getLocation().setShelfNum(location.getShelfNum());

       /* Location location1 = getLocation(id);

        location1.setShelfNum(location.getShelfNum());
        location1.setColumnNum(location.getColumnNum());*/

         bookrepo.save(book);


    }

    public Location findBookLocation(long id){
        Optional<Book> optionalBook = bookrepo.findById(id);

        Book book = optionalBook.get();

        return book.getLocation();
    }

    public  Location getLocation(Long id){
        Optional<Location> location = locationRepo.findById(id);
        if(!location.isPresent()){
            throw new EntityNotFoundException("Book with id : " + id + " does not exist");

        }
        return  location.get();

    }


}
