package com.gritlab.letsplay.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

@Data
public class User {
    private @Id String id;
    private String name;
    private String email;
    private @JsonIgnore String password;
    private String role;

    public User(){}
}
