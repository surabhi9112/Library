package com.cnb.library.model;

import com.cnb.library.dto.BookDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ISBN;
    private String name;
    private String authorFirstName;
    private String authorLastName;

    private String shelfNum;

    private String rowNum;

    private String columnNum;

//    @ManyToOne
//    @JoinColumn(name = "author_id")
//    private Author author;

    private Status status;


    @Builder
    public Book(String ISBN, String name, String authorFirstName, String authorLastName, Status status, String shelfNum, String rowNum, String columnNum) {
        this.ISBN = ISBN;
        this.name = name;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.status = status;
        this.shelfNum = shelfNum;
        this.rowNum = rowNum;
        this.columnNum = columnNum;


    }
}
