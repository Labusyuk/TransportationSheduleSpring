package com.labus.transportation.db.mongoDB.model;

import com.labus.transportation.parser.entity.Showcase;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;

@Document
public class Staying {
    @Id
    private int id;
    @Indexed
    private String name;
    private int timeAfterStart = 0;
    private Showcase ShowCaseWorkingDays;
    private Showcase ShowCaseWeekend;
}
