package com.cnb.library.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationDTO {

    private Long id;
    private String  shelfNum;
    private String rowNum;
    private String columnNum;
}


