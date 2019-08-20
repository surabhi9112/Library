package com.cnb.library.model;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor

public class BookIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private Date issueDate;
    private Date returnDate;

    @OneToOne(mappedBy = "location")
    private Book book;


    @Builder
    public BookIssue(String customerName, Date issueDate, Date returnDate){
        this.customerName=customerName;
        this.issueDate=issueDate;
        this.returnDate=returnDate;



    }
}
