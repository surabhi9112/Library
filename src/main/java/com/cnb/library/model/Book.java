package com.cnb.library.model;

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

//    private Long shelfNum;
//
//    private Long rowNum;
//
//    private Long columnNum;

//    @ManyToOne
//    @JoinColumn(name = "author_id")
//    private Author author;

    private Status status;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;


    @OneToOne
    @JoinColumn(name = "bookIssue_id")
    private BookIssue bookIssue;

    @Builder
    public Book(String ISBN, String name, String authorFirstName, String authorLastName, Status status, Location location, BookIssue bookIssue) {
        this.ISBN = ISBN;
        this.name = name;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.status = status;
        this.location= location;
        this.bookIssue =bookIssue;




    }


}
