package com.labus.transportation.controller;

import com.labus.transportation.service.StayingService;
import com.labus.transportation.service.TransportService;
import com.labus.transportation.parser.TransportPool;
import com.labus.transportation.parser.entity.Staying;
import com.labus.transportation.parser.entity.Transport;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("update")
public class DataUpdateController {
    private final TransportService transportService;
    private final StayingService stayingService;
    private final Logger log = LoggerFactory.getLogger(DataUpdateController.class);

    @GetMapping
    public void update() {
        try {
            List<Transport> transportList = TransportPool.getInstance().getTransport();
            Set<Staying> stayingSet = new HashSet<>();
            int i=0;
            for (Transport transport : transportList) {
                com.labus.transportation.model.Transport newTransport = new com.labus.transportation.model.Transport();
                newTransport.setId(i++);
                newTransport.setName(transport.getName());
                newTransport.setNameRoute(transport.getNameRoute());
                newTransport.setNameType(transport.getNameType());
                newTransport.setBackward(transport.getBackward());
                newTransport.setForward(transport.getForward());
                stayingSet.addAll(transport.getForward());
                stayingSet.addAll(transport.getBackward());
                transportService.save(newTransport);
            }
            List<com.labus.transportation.model.Staying> stayingList = new ArrayList();
            stayingList.addAll(stayingSet.stream().map(staying -> {
                com.labus.transportation.model.Staying newStaying = new com.labus.transportation.model.Staying();
                newStaying.setName(staying.getName());
                return newStaying;
            }).collect(Collectors.toList()));
            stayingService.saveAll(stayingList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
