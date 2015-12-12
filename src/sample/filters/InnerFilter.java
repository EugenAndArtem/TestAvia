package sample.filters;

import javafx.collections.ObservableList;
import sample.models.Flight;
import sample.models.InnerFlight;
import sample.models.Route;

/**
 * Created by Eugen on 06.12.2015.
 */
public class InnerFilter implements Filter {
    public void execute(ObservableList<Flight> flights,Route route){
        for(int i=0;i<flights.size();i++)
        {
            if(!flights.get(i).getType().equals(InnerFlight.TYPE))flights.remove(i--);
        }
    }
}
