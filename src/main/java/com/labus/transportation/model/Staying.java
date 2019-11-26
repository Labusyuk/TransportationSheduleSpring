package com.labus.transportation.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Staying {
    @Id
    private int id;
    @Indexed
    private String name;
}
