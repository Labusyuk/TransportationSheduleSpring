package com.labus.transportation.parser.entity.PublicTransport;

import com.labus.transportation.parser.entity.Transport;

public class Bus extends Transport {
public Bus(){
    nameType = "Автобус";
    }
    public Transport getTransport(){
        return new Transport(nameType);
    }

}
