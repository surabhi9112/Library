package com.cnb.library.service;

import com.cnb.library.dto.BookDTO;
import com.cnb.library.model.Book;
import com.cnb.library.model.Location;
import org.springframework.http.ResponseEntity;
import sun.jvm.hotspot.types.basic.BasicOopField;

public interface BookService {

Iterable<Book>list();

Book addBook(Book books);

Book updateBook(long id, Book book);

void removeBook(long id);

Location addLocation(Location location);

Book findBookById(Long id);



}
