package com.cnb.library.repo;

import com.cnb.library.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bookrepo extends CrudRepository<Book, Long> {
}
