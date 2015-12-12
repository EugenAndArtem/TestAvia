package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import sample.models.*;

import java.util.ArrayList;
import sample.models.*;

/**
 * Created by Àðò¸ì on 27.11.2015.
 */
public  class BaseController implements Listener {

    @FXML
    protected ListView<Flight> listFlights;
    @FXML
    protected ListView<Route> listRoutes;

    public void addFlightToListView(Flight o) {
        listFlights.getItems().add(o);
    }

    public void addRouteToListView(Route o) {
        listRoutes.getItems().add(o);
    }

    public void changeRouteFromListView(Route o, int ind) {
        listRoutes.getItems().set(ind, o);
    }

    public void changeFlightFromListView(Flight o, int ind) {
        listFlights.getItems().set(ind, o);
    }

    public void removeFlightFromList(int ind) {
        listFlights.getItems().remove(ind);
    }

    public void removeRouteFromList(int ind) {
        listRoutes.getItems().remove(ind);
    }

    public void handle(ParentEvent ev) {

        switch (ev.getType()) {
            case "addEventFlight": {
                addFlightToListView((Flight) ev.getObject());
                break;
            }
            case "addEventRoute": {
                addRouteToListView((Route) ev.getObject());
                break;
            }

            case "changeEventRoute": {
                changeRouteFromListView((Route) ev.getObject(), ev.getIndex());
                break;
            }
            case "changeEventFlight": {
                changeFlightFromListView((Flight) ev.getObject(), ev.getIndex());
                break;
            }

            case "removeEventRoute": {
                removeRouteFromList(ev.getIndex());
                break;
            }
            case "removeEventFlight": {
                removeFlightFromList(ev.getIndex());
                break;
            }
        }
    }
}
