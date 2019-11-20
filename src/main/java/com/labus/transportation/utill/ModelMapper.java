package com.labus.transportation.utill;

import com.labus.transportation.dto.StayingDTO;
import com.labus.transportation.dto.TransportDTO;
import com.labus.transportation.model.Route;
import com.labus.transportation.model.Showcase;
import com.labus.transportation.model.Transport;
import com.labus.transportation.model.enums.DayEnum;
import com.labus.transportation.model.enums.DirectionEnum;

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
        transportDTO.setNameType(transport.getNameType());
        List<Route> forwardRoute = new ArrayList(transport.getStaying());
        forwardRoute.removeIf(x->x.getDirectionEnum().equals(DirectionEnum.BACKWARD));
        List<Route> backwardRoute = new ArrayList(transport.getStaying());
        backwardRoute.removeIf(x->x.getDirectionEnum().equals(DirectionEnum.FORWARD));
        transportDTO.setForwardRoute(convertListRouteToStayingDTO(forwardRoute));
        transportDTO.setBackwardRoute(convertListRouteToStayingDTO(backwardRoute));
        return transportDTO;
    }

    public static List<StayingDTO> convertListRouteToStayingDTO(List<Route> routeList) {
        List<StayingDTO> stayingDTOList = routeList.stream().map(route -> convertRouteToStayingDTO(route)).collect(Collectors.toList());
        stayingDTOList.sort(Comparator.comparingInt(StayingDTO::getPosition));
        return stayingDTOList;
    }

    public static StayingDTO convertRouteToStayingDTO(Route route){
        StayingDTO stayingDTO = new StayingDTO();
        stayingDTO.setName(route.getStaying().getName());
        stayingDTO.setPosition(route.getPosition());
        stayingDTO.setTimeAfterStart(route.getShowcase().get(0).getTimeAfterStart());//get(0) или любой другой елемент все они дублируют таймАфтерСтарт
        List<Showcase> showcaseListWorkingDay = new ArrayList<>(route.getShowcase());
        showcaseListWorkingDay.removeIf(showcase -> showcase.getDayEnum().equals(DayEnum.WEEKEND));
        stayingDTO.setWorkingDay(convertListShowcaseToLocalTime(showcaseListWorkingDay));
        List<Showcase> showcaseListWeekendDay = new ArrayList<>(route.getShowcase());
        showcaseListWeekendDay.removeIf(showcase -> showcase.getDayEnum().equals(DayEnum.WORKING));
        stayingDTO.setWeekendDay(convertListShowcaseToLocalTime(route.getShowcase()));
        return stayingDTO;
    }

    public static List<LocalTime> convertListShowcaseToLocalTime(List<Showcase> showcaseList) {
        List<LocalTime> localTimeList = showcaseList.stream().map(showcase -> showcase.getLocalTime()).collect(Collectors.toList());
        return localTimeList;
    }

    public static LocalTime convertStringToLocalTime(String timeStr){
            String[] str = timeStr.split(":");
        int hour = Integer.parseInt(str[0].replaceAll("[^0-9]", ""));
        int minute = Integer.parseInt(str[1].replaceAll("[^0-9]", ""));
        return LocalTime.of(hour,minute);
        }

}
