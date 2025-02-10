package org.example.servermodule.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    public User(){

    }
    public User(String name, String email, Long phno) {
        this.name = name;
        this.email = email;
        this.phno = phno;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
