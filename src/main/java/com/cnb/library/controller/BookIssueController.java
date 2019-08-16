package com.cnb.library.controller;


import com.cnb.library.model.BookIssue;
import com.cnb.library.service.BookIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookIssueController {

    private BookIssueService bookIssueService;


    @Autowired
    public BookIssueController(BookIssueService bookIssueService){
        this.bookIssueService=bookIssueService;
    }

    @GetMapping(value = "/{id}/issue")
    public BookIssue getBookIssueHistory(@PathVariable Long id){
        return bookIssueService.findBookIssueHistory(id);
    }



}


