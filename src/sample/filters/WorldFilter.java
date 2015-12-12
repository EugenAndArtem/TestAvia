package sample.filters;

import javafx.collections.ObservableList;
import sample.models.Flight;
import sample.models.Route;
import sample.models.WorldWideFlight;

/**
 * Created by Eugen on 06.12.2015.
 */
public class WorldFilter implements Filter {
    public void execute(ObservableList<Flight> flights,Route route){
        for(int i=0;i<flights.size();i++)
        {
            String str=flights.get(i).getType();
            System.out.println(str);
            if (!str.equals(WorldWideFlight.TYPE))flights.remove(i--);
        }
    }
}
