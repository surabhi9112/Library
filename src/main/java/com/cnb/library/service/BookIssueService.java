package com.cnb.library.service;

import com.cnb.library.model.Book;
import com.cnb.library.model.BookIssue;

public interface BookIssueService {

    BookIssue findBookIssueHistory(long id);

    BookIssue addBookIssue(BookIssue bookIssue);

    void updateBookIssued(long id, BookIssue bookIssue);
}
