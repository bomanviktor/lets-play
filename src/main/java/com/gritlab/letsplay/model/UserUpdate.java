package com.gritlab.letsplay.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Optional;

@Data
public class UserUpdate {
    private String name;
    private String email;
    private @JsonIgnore String password;
    private String role;
}
