package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.models.Route;

/**
 * Created by Eugen on 12.12.2015.
 */
public class RouteInfo {
    @FXML
    private Label lFrom;
    @FXML
    private Label lTo;
    private static Route route;

    public  static void setRoute(Route flights){
        route=flights;
    }
    @FXML
    public void initialize(){
        System.out.println("Init");
        lTo.setText(route.getToPoint());
        lFrom.setText(route.getFromPoint());
    }
}
