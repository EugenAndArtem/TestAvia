package sample.filters;

import javafx.collections.ObservableList;
import sample.models.Flight;
import sample.models.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Eugen on 05.12.2015.
 */
public class FilterChain {
    private List<Filter> chain;
    public FilterChain(){
        chain=new ArrayList<Filter>();
    }
    public void addFilter(Filter filter){
        chain.add(filter);
    }
    public void deleteFilter(Filter filter){
        chain.remove(filter);
    }
    public ObservableList<Flight> execute(ObservableList<Flight> list,Route route){
        for(Filter filter:chain)
            filter.execute(list,route);
        return list;
    }
}
