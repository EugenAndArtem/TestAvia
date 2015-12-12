package sample.filters;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Controller;
import sample.models.Flight;
import sample.models.Route;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Eugen on 05.12.2015.
 */
public class FilterDipatcher {
    FilterChain filterChain;
    ObservableList<Flight> flights= FXCollections.observableArrayList();
    public FilterDipatcher(FilterChain chain){
        filterChain=chain;
    }
    public void registerFilter(Filter filter){
        if(filter!=null)
            filterChain.addFilter(filter);
    }
    public void deleteFilter(Filter filter){
        filterChain.deleteFilter(filter);
    }
    public ObservableList<Flight> execute(Route route){
        ArrayList<Flight> array=Controller.flightService.getAllFlights().getArrayList();
        flights.clear();
        for(int i=0;i<array.size();i++) {
            System.out.println(array.get(i));
            flights.add(array.get(i));
        }
        return filterChain.execute(flights,route);
    }
}
