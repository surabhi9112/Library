package com.cnb.library.repo;

import com.cnb.library.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Authorrepo extends CrudRepository<Author, Long> {
}
