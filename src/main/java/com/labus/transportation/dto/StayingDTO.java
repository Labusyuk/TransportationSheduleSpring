package com.labus.transportation.dto;

import com.labus.transportation.parser.entity.TimeOfDay;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Data
public class StayingDTO {
    private String name;
    private int position;
    private int timeAfterStart;
    private List<LocalTime> workingDay, weekendDay;

    public StayingDTO() {
    }

    public StayingDTO(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StayingDTO that = (StayingDTO) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public LocalTime getLocalTimeAfter(LocalTime localTime, boolean weekend) {
        Iterator<LocalTime> iterator;
        if(weekend)
            iterator = weekendDay.iterator();
        else iterator =  workingDay.iterator();
        while (iterator.hasNext()) {
            LocalTime tempLocalTime = iterator.next();
            if (localTime.getHour() <= tempLocalTime.getHour()) {
                if (localTime.getHour() < tempLocalTime.getHour()) return tempLocalTime;
                if (localTime.getMinute() <= tempLocalTime.getMinute()) {
                    if (localTime.getMinute() < tempLocalTime.getMinute()) return tempLocalTime;
                    if (localTime.getSecond() <= tempLocalTime.getSecond())
                        return localTime;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getName();
    }
}
