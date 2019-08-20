package com.cnb.library.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity

public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shelfNum;
    private Long rowNum;
    private Long columnNum;


    @OneToOne(mappedBy = "location")
    private Book book;



   /* @Builder
    public Location( Long shelfNum, Long rowNum, Long columnNum, Book book) {
        this.shelfNum=shelfNum;
        this.rowNum=rowNum;
        this.columnNum=columnNum;
        this.book=book;
*/




}
