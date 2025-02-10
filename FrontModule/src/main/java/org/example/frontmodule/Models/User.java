package org.example.servermodule.Models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Long id;
    String name;
    Long phno;
    String email;

    public User(){

    }
    public User(Long id, String name, String email, Long phno) {
        this.name = name;
        this.email = email;
        this.phno = phno;
    }
}
