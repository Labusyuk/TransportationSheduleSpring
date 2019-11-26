package com.labus.transportation.model;

import com.labus.transportation.parser.entity.Route;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


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
