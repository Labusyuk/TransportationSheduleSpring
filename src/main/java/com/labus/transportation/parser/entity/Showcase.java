package com.labus.transportation.parser.entity;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class Showcase extends LinkedList<TimeOfDay> implements Serializable {
    public Showcase() {
    }
    public TimeOfDay getAfter(TimeOfDay timeOfDay){
                Iterator<TimeOfDay> iterator = super.iterator();
        while(iterator.hasNext()){
            TimeOfDay tempTimeOfDay = iterator.next();
            if(timeOfDay.getHour()<=tempTimeOfDay.getHour()){
                if(timeOfDay.getHour()<tempTimeOfDay.getHour())return tempTimeOfDay;
                if(timeOfDay.getMinute()<=tempTimeOfDay.getMinute()){
                    if(timeOfDay.getMinute()<tempTimeOfDay.getMinute())return tempTimeOfDay;
                    if(timeOfDay.getSecond()<=tempTimeOfDay.getSecond())
                        return tempTimeOfDay;
                }
            }
        }
        return null;
    }

    public void sort(){
        sort((x1,x2)->{
            if(x1.getHour()-x2.getHour()==0)
                return x1.getMinute()-x2.getMinute();
            else return x1.getHour()-x2.getHour();
        });
    }
}
