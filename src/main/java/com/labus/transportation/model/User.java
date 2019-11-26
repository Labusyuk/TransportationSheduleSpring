package com.labus.transportation.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    private int id;
    public String username;
    public String password;
}
