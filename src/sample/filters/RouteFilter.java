package sample.filters;

import javafx.collections.ObservableList;
import sample.models.Flight;
import sample.models.InnerFlight;
import sample.models.Route;

/**
 * Created by Eugen on 06.12.2015.
 */
public class RouteFilter implements Filter {
    public void execute(ObservableList<Flight> flights,Route route){
        for(int i=0;i<flights.size();i++)
        {
            if(!flights.get(i).getRoute().getFromPoint().equals(route.getFromPoint())&&!flights.get(i).getRoute().getToPoint().equals(route.getToPoint()))flights.remove(i--);
        }
    }
}
