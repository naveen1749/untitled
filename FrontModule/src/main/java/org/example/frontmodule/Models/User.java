package org.example.frontmodule.Models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.example.frontmodule.Models.Mode;

import java.time.LocalDate;

@Getter
@Setter
public class User {

    private Long id;
    String name;
    Long phno;
    String email;

    LocalDate date;
    Mode mode;
    public User(){

    }

    public User(Long id, String name, Long phno, String email, LocalDate date, Mode mode) {
        this.id = id;
        this.name = name;
        this.phno = phno;
        this.email = email;
        this.date = date;
        this.mode = mode;
    }

}
