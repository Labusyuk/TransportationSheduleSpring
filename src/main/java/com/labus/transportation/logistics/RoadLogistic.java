package com.labus.transportation.logistics;

import com.labus.transportation.dto.StayingDTO;
import com.labus.transportation.dto.TransportDTO;
import com.labus.transportation.dto.WaysDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@RequiredArgsConstructor
public class RoadLogistic implements Logistic {

    private final List<TransportDTO> transports;
    private final int minCount = 1; // Искать пересадки если найдено меньше ровно minCount

    public List<WaysDTO> buildWays(StayingDTO a, StayingDTO b) {
        List<WaysDTO> ways = new ArrayList<>();
        /*Route myRoute;*/
        //Построения маршрута без пересадок
        for (TransportDTO transport : transports) {
            WaysDTO waysDTO = new WaysDTO();
            TransportDTO tempTransportDTO;
            if((tempTransportDTO = transport.verifysTA(a,b))!=null) {
                waysDTO.add(tempTransportDTO);
                ways.add(waysDTO);
            }
            }
            //Построения маршрутов с одной пересадкой
            if (ways.size() <= minCount) {
                List<TransportDTO> transportsA = new ArrayList<>(), transportsB = new ArrayList<>();
                for (TransportDTO transport : transports) {
                    if (transport.containsStaying(a))
                        transportsA.add(transport);
                    if (transport.containsStaying(b))
                        transportsB.add(transport);
                }
                label1:
                for (TransportDTO transportA : transportsA) {
                    label2:
                    for (TransportDTO transportB : transportsB) {
                        LinkedList<StayingDTO> jointRoute;
                        //У каждого транспорта по 2 маршрута.
                           for(int i=0;i<minCount && ways.size()!=0;i++){
                               if (ways.get(i).contains(transportA))
                                   continue label1;
                               if(ways.get(i).contains(transportB))
                                   continue label2;
                           }
                    outer:
                        for (int i = 0; i < 2; i++)
                            for (int k = 0; k < 2; k++)
                                if ((jointRoute = new LinkedList<>(CollectionUtils.retainAll(transportA.getRoute()[i], transportB.getRoute()[k]))).size() >= 1) {
                                    //System.out.println(jointRoute.getFirst().getName());
                                    WaysDTO way = new WaysDTO();
                                    TransportDTO transportDTO1 = transportA.verifysTA(a, jointRoute.getFirst()),
                                            transportDTO2 = transportB.verifysTA(jointRoute.getFirst(), b);
                                   /* System.out.println(transportA.getName()+" "+a.getName()+" "+jointRoute.getFirst().getName());
                                    System.out.println(transportB.getName()+" "+jointRoute.getFirst().getName()+" "+b.getName());
                                    System.out.println("----"+(transportDTO1!=null) +" "+ (transportDTO2!=null)+"\n-----");*/
                                    if (transportDTO1 == null || transportDTO2 == null)
                                        continue;
                                    /*System.out.println("+++"+transportDTO1.getName()+" - "+transportDTO2.getName());*/
                                    way.add(transportDTO1);
                                    way.add(transportDTO2);
                                    ways.add(way);
                                    break outer;
                                }
                    }
                }
            }
            return ways;
        }

    public List<WaysDTO> buildWays(StayingDTO a, StayingDTO b, LocalTime localTime, boolean weekend) {
        List<WaysDTO> list = buildWays(a, b);
        for(WaysDTO ways:list){
            LocalTime tempLocalTime = localTime;
            for(TransportDTO transport: ways) {
                transport.setStartLocalTime(transport.getGeneralRoute().get(0).getLocalTimeAfter(tempLocalTime,weekend));
               for (StayingDTO staying : transport.getGeneralRoute()) {
                   tempLocalTime = (staying.getLocalTimeAfter(tempLocalTime,weekend));
                }
               transport.setFinishLocalTime(tempLocalTime);
            }
        }
        return list; //TODO
    }

}
