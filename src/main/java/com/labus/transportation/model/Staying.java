package com.labus.transportation.db.mongoDB.model;

import com.labus.transportation.parser.entity.Showcase;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@Document
public class Staying {
    @Id
    private int id;
    @Indexed
    private String name;
}
