package com.cnb.library.model;


import lombok.Data;

import javax.persistence.*;

import java.util.Date;

@Entity
@Data
public class BookIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private Date issueDate;
    private Date returnDate;

    @OneToOne
    @JoinColumn(name ="book_id")
    private Book book;
}
