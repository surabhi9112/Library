package com.cnb.library.service.impl;


import com.cnb.library.model.Book;
import com.cnb.library.model.BookIssue;
import com.cnb.library.repo.BookIssueRepo;
import com.cnb.library.service.BookIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookIssueServiceImpl implements BookIssueService {


    private BookIssueRepo bookIssueRepo;

    @Autowired
    public BookIssueServiceImpl(BookIssueRepo bookIssueRepo){
        this.bookIssueRepo= bookIssueRepo;
    }

    public BookIssue addBookIssue(BookIssue bookIssue){
        return bookIssueRepo.save(bookIssue);
    }

    public BookIssue findBookIssueHistory(long id){
        BookIssue bookIssue = getBookIssueById(id);
         return bookIssue;
    }

    public BookIssue getBookIssueById(Long id){
        Optional<BookIssue>  optionalBookIssue= bookIssueRepo.findById(id);
        return optionalBookIssue.get();
    }
}
