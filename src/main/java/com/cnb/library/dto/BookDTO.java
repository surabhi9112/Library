package com.cnb.library.dto;

import com.cnb.library.model.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@NoArgsConstructor

public class BookDTO {
    private Long id;
    private String ISBN;
    private String name;
    private String authorFirstName;
    private String authorLastName;
    private Status status;



}
