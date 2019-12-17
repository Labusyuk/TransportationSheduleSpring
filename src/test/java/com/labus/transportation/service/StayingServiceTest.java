package com.labus.transportation.service;

import com.labus.transportation.model.Staying;
import com.labus.transportation.repositories.StayingRespository;
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
class StayingServiceTest {
    @MockBean
    StayingRespository stayingRespository;
    @Autowired
    StayingService stayingService;
    @Test
    void save() {
        Staying staying = new Staying();
        Mockito.doReturn(staying).when(stayingRespository).save(staying);
        Assert.assertEquals(stayingService.save(staying),staying);
        verify(stayingRespository).save(staying);
    }

    @Test
    void getAll() {
        Staying staying1 = new Staying(), staying2 = new Staying();

        List<Staying> transportList = new ArrayList<>(Arrays.asList(staying1, staying2));
        Mockito.doReturn(transportList).when(stayingRespository).findBy();
        Assert.assertEquals(transportList,stayingService.getAll());
        verify(stayingRespository).findBy();
    }
}