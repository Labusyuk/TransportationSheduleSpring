package com.labus.transportation.db.mongoDB.utill;

import com.labus.transportation.db.mongoDB.model.Transport;
import com.labus.transportation.dto.StayingDTO;
import com.labus.transportation.dto.TransportDTO;
import com.labus.transportation.parser.entity.Showcase;
import com.labus.transportation.parser.entity.Staying;
import com.labus.transportation.parser.entity.TimeOfDay;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ModelMapper {

    public static List<TransportDTO> convertListTransportToDTO(List<Transport> transportList){
        List<TransportDTO> transportDTOList = transportList.stream().map(transport -> convertTransportToDTO(transport)).collect(Collectors.toList());
        return transportDTOList;
    }
    public static TransportDTO convertTransportToDTO(Transport transport){
        TransportDTO transportDTO = new TransportDTO();
        transportDTO.setName(transport.getName());
        transportDTO.setForwardRoute(convertListStayingToStayingDTO(transport.getForward()));
        transportDTO.setBackwardRoute(convertListStayingToStayingDTO(transport.getBackward()));
        transportDTO.setNameType(transport.getNameType());
        return transportDTO;
    }

    public static List<StayingDTO> convertListStayingToStayingDTO(List<Staying> stayingList) {
        List<StayingDTO> stayingDTOList = new ArrayList<>();
        for(int i=0;i<stayingList.size();i++){
            Staying staying = stayingList.get(0);
            StayingDTO newStaying = new StayingDTO();
            newStaying.setName(staying.getName());
            newStaying.setPosition(i);
            newStaying.setTimeAfterStart(staying.getTimeAfterStart());
            newStaying.setWeekendDay(convertShowcaseToListLocalTime(staying.getShowCaseWeekend()));
            newStaying.setWorkingDay(convertShowcaseToListLocalTime(staying.getShowCaseWorkingDays()));
            stayingDTOList.add(newStaying);
        }
        stayingDTOList.sort(Comparator.comparingInt(StayingDTO::getPosition));
        return stayingDTOList;
    }

    public static List<LocalTime> convertShowcaseToListLocalTime(Showcase showcaseList) {
        return showcaseList.stream().map(showcase -> LocalTime.of(showcase.getHour(),showcase.getMinute(),showcase.getSecond())).collect(Collectors.toList());
    }

    public static LocalTime convertStringToLocalTime(String timeStr){
            String[] str = timeStr.split(":");
        int hour = Integer.parseInt(str[0].replaceAll("[^0-9]", ""));
        int minute = Integer.parseInt(str[1].replaceAll("[^0-9]", ""));
        return LocalTime.of(hour,minute);
        }

}
