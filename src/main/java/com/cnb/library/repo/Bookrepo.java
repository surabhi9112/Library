package com.cnb.library.repo;

import com.cnb.library.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Bookrepo extends CrudRepository<Book, Long> {

    @Query(value = "SELECT  shelf_num FROM Book " , nativeQuery = true)
    Long findBookLocation ();
}
