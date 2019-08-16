package com.cnb.library.repo;

import com.cnb.library.model.BookIssue;
import org.springframework.data.repository.CrudRepository;

public interface BookIssueRepo extends CrudRepository<BookIssue, Long> {
}
