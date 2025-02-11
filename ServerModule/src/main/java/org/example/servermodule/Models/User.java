package org.example.servermodule.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Entity
@Table(schema = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    String name;
    @NonNull
    Long phno;
    @NonNull
    String email;

    @NonNull
    LocalDate date;

    @Enumerated(EnumType.STRING)
    Mode mode;

    public User(){

    }
    public User(String name, String email, Long phno, Mode mode,LocalDate date) {
        this.name = name;
        this.email = email;
        this.phno = phno;
        this.mode=mode;
        this.date=date;
    }

}
