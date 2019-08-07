package com.cnb.library.service;

import com.cnb.library.model.Book;

import java.util.List;

public interface BookService {

Iterable<Book>list();

Book addBook(Book books);

Book update(Long id);

void removeBook(long id);

}
