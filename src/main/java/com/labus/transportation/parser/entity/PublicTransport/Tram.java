package com.labus.transportation.parser.entity.PublicTransport;

import com.labus.transportation.parser.entity.Transport;

public class Tram extends Transport {
    public Tram(){
        nameType = "Трамвай";
    }
    public Transport getTransport(){
        return new Transport(nameType);
    }
}
