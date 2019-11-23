package com.labus.transportation.db.mongoDB.model;

import com.labus.transportation.parser.entity.Route;
import com.labus.transportation.parser.entity.Staying;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@Document
public class Transport {
    @Id
    private int id;
    @Indexed
    protected String name;
    private String nameType;
    private String nameRoute;
    protected Route forward;
    private Route backward;
}
