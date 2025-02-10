package org.example.frontmodule.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Setter
@Getter
@Component
public class UserTemp{
    public UserTemp() {
    }

    String name;
    Long phno;
    String email;

    LocalDate date;
    Mode mode;

    public UserTemp(String name, Long phno, String email, LocalDate date, Mode mode) {
        this.name = name;
        this.phno = phno;
        this.email = email;
        this.date = date;
        this.mode = mode;
    }
}
