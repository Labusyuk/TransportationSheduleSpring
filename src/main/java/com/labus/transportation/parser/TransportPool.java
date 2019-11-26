package com.labus.transportation.parser;

import com.labus.transportation.parser.entity.Route;
import com.labus.transportation.parser.entity.Staying;
import com.labus.transportation.parser.entity.Transport;
import com.labus.transportation.parser.ParseTransportFactory.ParseTransport;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TransportPool {
    private static boolean isCreated = false;
    private static TransportPool poolInstance;
    private static Date dateCreatedTransports, dateCreatedStayings;
    private static long actualIntervalTime= 60*60*100;
    private static List<Transport> transportsList = null;
    private static Set<Staying> stayingsList = new TreeSet<Staying>((x, y)->x.getName().compareTo(y.getName()));

    private TransportPool(){
        isCreated = true;
        transportsList = new ParseTransport().getTransports();
        dateCreatedTransports = new Date();
    }

    public static TransportPool getInstance() {
        if (!isCreated) {
            synchronized (TransportPool.class) {
                poolInstance = new TransportPool();
            }
        }
        return poolInstance;
    }

    public List<Transport> getTransport() throws IOException {
        if(new Date().getTime()-dateCreatedTransports.getTime()>actualIntervalTime) {
            transportsList.clear();
            transportsList = new ParseTransport().getTransports();
            dateCreatedTransports = new Date();
        }
        return transportsList;
    }
    public Set<Staying> getStaying() throws IOException {
        if(dateCreatedStayings==null || new Date().getTime()-dateCreatedStayings.getTime()>actualIntervalTime) {
            stayingsList.clear();
            for (Transport transport : getTransport())
                for (Route route : transport.getRoute())
                    for (Staying staying : route)
                        stayingsList.add(staying);
            dateCreatedStayings = new Date();
            return stayingsList;
        }
        return stayingsList;
    }
}
