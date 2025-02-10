package org.example.frontmodule.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class UserTemp{
    public UserTemp() {
    }

    public UserTemp(String name, Long phno, String email) {
        this.name = name;
        this.phno = phno;
        this.email = email;
    }

    String name;
    Long phno;
    String email;
}
