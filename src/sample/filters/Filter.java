package sample.filters;

import javafx.collections.ObservableList;
import sample.models.Flight;
import sample.models.Route;

/**
 * Created by Eugen on 05.12.2015.
 */
public interface Filter {
    void execute(ObservableList<Flight> list, Route route);
}
