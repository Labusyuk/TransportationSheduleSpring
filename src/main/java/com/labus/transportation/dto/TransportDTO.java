package com.labus.transportation.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections.CollectionUtils;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Data
public class TransportDTO {
    private String name;
    private String nameType;
    private List<StayingDTO> forwardRoute;
    private List<StayingDTO> backwardRoute;
    /*ARCHETYPE*/
    private List<StayingDTO> generalRoute;
    private LocalTime startLocalTime;
    private LocalTime finishLocalTime;
    /*--ARCHETYPE--*/
    public List<StayingDTO>[] getRoute(){
        return new List[]{getForwardRoute(), getBackwardRoute()};
    }
    public TransportDTO verifysTA(StayingDTO staying1, StayingDTO staying2){
        int indexA, indexB;
        if((indexA = getForwardRoute().indexOf(staying1))>=0 && (indexB=getForwardRoute().indexOf(staying2))>=0 && indexA<=indexB){
            generalRoute = getForwardRoute().subList(indexA,indexB+1);
            return this;
        }
        if((indexA = getBackwardRoute().indexOf(staying1))>=0 && (indexB=getBackwardRoute().indexOf(staying2))>=0 && indexA<=indexB){
            generalRoute = getBackwardRoute().subList(indexA,indexB+1);
            return this;
        }
        return null;
    }
    public boolean containsStaying(StayingDTO staying){
        return forwardRoute.contains(staying) || backwardRoute.contains(staying);
    }
    public StayingDTO getFirstStaying(){
        /*for(int i=0;i<getGeneralRoute().size();i++){
            StayingDTO stayingDTO = getGeneralRoute().get(i);
            System.out.println(stayingDTO.getPosition()+": "+stayingDTO.getName());
        }*/
        if (generalRoute != null && !generalRoute.isEmpty())
            return generalRoute.get(0);
        return null;
    }
    public StayingDTO getLastStaying(){
        if (generalRoute != null && !generalRoute.isEmpty())
            return generalRoute.get(generalRoute.size()-1);
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportDTO that = (TransportDTO) o;
        return Objects.equals(name, that.name);
    }

}
