package com.labus.transportation.db.sql.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Staying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generated DataBase auto_increment when insert value
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private int id;
    private String name;
    @OneToMany(mappedBy = "staying", cascade=CascadeType.ALL)
    private List<Route> transport;

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /*   @ManyToOne
    @JoinColumn(name="route_id", nullable=false)
    private Set<LocalTime> showCaseWorkingDays, showCaseWeekend; */

}
