package org.example.servermodule.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(schema = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    Long phno;
    String email;

    LocalDate date;

    @Enumerated(EnumType.STRING)
    Mode mode;

    public User(){

    }
    public User(String name, String email, Long phno) {
        this.name = name;
        this.email = email;
        this.phno = phno;
    }

    enum Mode{
        BACK_OFFICE, FRONT_OFFICE;
    }

}
