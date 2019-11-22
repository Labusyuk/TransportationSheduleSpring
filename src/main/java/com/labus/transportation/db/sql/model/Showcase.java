package com.labus.transportation.db.sql.model;

import com.labus.transportation.db.sql.model.enums.DayEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@Entity
public class Showcase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generated DataBase auto_increment when insert value
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private int id;
    private LocalTime localTime;
    @Enumerated(EnumType.STRING)
    private DayEnum dayEnum;
    @Column(nullable = true)
    private int timeAfterStart = 0;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "route_id")
    private Route route;
}
