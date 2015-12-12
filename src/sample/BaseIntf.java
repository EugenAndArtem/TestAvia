package sample;

import sample.models.Flight;
import sample.models.Route;

/**
 * Created by Eugen on 28.11.2015.
 */
public interface BaseIntf {
    void addFlightToListView(Flight o);
    void addRouteToListView(Route o);
    void changeRouteFromListView(Route o, int ind);
    void changeFlightFromListView(Flight o, int ind);
    void removeFlightFromList(int ind);
    void removeRouteFromList(int ind);
}
