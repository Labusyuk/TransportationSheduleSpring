package com.labus.transportation.parser.ParseTransportFactory;

import com.labus.transportation.parser.entity.PublicTransport.Bus;
import com.labus.transportation.parser.entity.PublicTransport.Tram;
import com.labus.transportation.parser.entity.PublicTransport.Trolleybus;
import com.labus.transportation.parser.entity.Staying;
import com.labus.transportation.parser.entity.Transport;
import com.labus.transportation.parser.PagePool;
import com.labus.transportation.parser.Parser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class ParseTransport implements Parser {
    private PagePool pagePool = PagePool.getInstance();
    private Document document;
    private List<Transport> transports = new ArrayList<>();
    private String url = "https://vn.rozklad.in.ua", pathUrl = "/home/schedule/";
    private static final Map<String, Transport> actionsMap = new HashMap<>();
    static {
        actionsMap.put("div.route.js-route.js-tram", new Tram());
        actionsMap.put("div.route.js-route.js-trolleybus", new Trolleybus());
        actionsMap.put("div.route.js-route.js-bus", new Bus());
    }

    public List<Transport> getTransports(){
        try {
            Date date1 = new Date();
            document = pagePool.getDocument(url+pathUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 0;
        for(String str: actionsMap.keySet()) {
            Elements elements = document.select(str);
                for(Element elementRoute:elements.select("a")){
                    Transport transport;
                    if(actionsMap.get(str)!=null){
                        transport = actionsMap.get(str).getTransport();
                        transport.setNameRoute(elementRoute.select("span").text());
                        System.out.println(transport.getNameRoute());

                        //System.out.println(elementRoute.select("span").text());
                        ParseRoute route = new ParseRoute(url+elementRoute.attr("href"));
                        try {
                            transport.setRoute(route.getRoute());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //   System.out.println(transport.getRoute().getName());
                        transports.add(transport);
                    }
            }
        }
        return transports;
    }

    public static void main(String[] args) {
        for(Transport transport: new ParseTransport().getTransports()) {
            System.out.println(transport.getName() + " " + transport.getForward().getName());
            for(Staying staying:transport.getForward())
                System.out.print(staying.getName()+" - ");
            System.out.println();

        }
    }

}
