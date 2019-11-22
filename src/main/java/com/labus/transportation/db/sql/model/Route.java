package com.labus.transportation.db.sql.model;

import com.labus.transportation.db.sql.model.enums.DirectionEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity

public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generated DataBase auto_increment when insert value
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private int id;
    @Enumerated(EnumType.STRING)
    private DirectionEnum directionEnum;
    private int position;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "staying_id")
    private Staying staying;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "transport_id")
    private Transport transport;
    @OneToMany(mappedBy = "route", cascade=CascadeType.ALL)
    private List<Showcase> showcase;
}
