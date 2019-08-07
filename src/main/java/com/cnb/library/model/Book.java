package com.cnb.library.model;

import com.cnb.library.dto.BookDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonAutoDetect;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@JsonAutoDetect
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ISBN;
    private String name;
    private String authorFirstName;
    private String authorLastName;

//    @ManyToOne
//    @JoinColumn(name = "author_id")
//    private Author author;

    private Status status;


    @Builder
    public Book(String ISBN, String name, String authorFirstName, String authorLastName, Status status) {
        this.ISBN = ISBN;
        this.name = name;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.status = status;


    }
}
