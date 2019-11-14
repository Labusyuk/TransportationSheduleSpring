package com.labus.transportation.model;

import com.labus.transportation.model.enums.DayEnum;
import com.labus.transportation.model.enums.DirectionEnum;
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
    @Enumerated(EnumType.STRING)
    private DirectionEnum directionEnum;
    @Column(nullable = true)
    private int timeAfterStart = 0;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "route_id")
    private Route route;
}
