package com.cnb.library.service;

import com.cnb.library.model.Book;

public interface BookService {

Iterable<Book>list();

Book addBook(Book books);

Book update(Long id);

void removeBook(long id);

Long findBookLocation(Long id);



}
