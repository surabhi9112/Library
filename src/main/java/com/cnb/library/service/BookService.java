package com.cnb.library.service;

import com.cnb.library.dto.BookDTO;
import com.cnb.library.model.Book;
import com.cnb.library.model.Location;
import org.springframework.http.ResponseEntity;

public interface BookService {

Iterable<Book>list();

Book addBook(Book books);

Book updateBook(long id, Book book);

Location updateLocation(long id, Location location);

void removeBook(long id);

Location findBookLocation(long id);

Location addLocation(Location location);



}
