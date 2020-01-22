package com.labus.transportation.service;

import com.labus.transportation.model.Transport;
import com.labus.transportation.repositories.TransportRespository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
class TransportServiceTest {
    @MockBean
    TransportRespository transportRespository;
    @Autowired
    TransportService transportService;

    @Test
    void save() {
        Transport transport = new Transport();
        Mockito.doReturn(transport).when(transportRespository).save(transport);
        Assert.assertEquals(transport,transportService.save(transport));
        verify(transportRespository).save(transport);
    }

    @Test
    void getTransports() {
        Transport transport1 = new Transport(), transport2 = new Transport();
        List<Transport> transportList = new ArrayList<>(Arrays.asList(transport1, transport2));
        Mockito.doReturn(transportList).when(transportRespository).findAll();
        Assert.assertEquals(transportList,transportService.getTransports());
        verify(transportRespository).findAll();
    }

    @Test
    void getTransportCount() {
        Transport transport1 = new Transport(), transport2 = new Transport();
        List<Transport> transportList = new ArrayList<>(Arrays.asList(transport1, transport2));
        Mockito.doReturn(transportList).when(transportRespository).findByNameType("nameType");
        Assert.assertEquals(Integer.valueOf(2),transportService.getTransportCount("nameType"));
        verify(transportRespository).findByNameType("nameType");
    }
}