package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.models.Flight;
import sample.services.FlightModelHolder;

/**
 * Created by Eugen on 11.12.2015.
 */
public class FlightInfo {
    @FXML
    private Label lType;
    @FXML
    private Label lNumber;
    @FXML
    private Label lStart;
    @FXML
    private Label lFlight;
    @FXML
    private Label lRoute;
    @FXML
    private Label lPlane;
    private static Flight flight;

    public  static void setFlight(Flight flights){
        System.out.println("Set Flight");
        flight=flights;
    }
    @FXML
    public void initialize(){
        System.out.println("Flight Info");
        System.out.println(flight);
        FlightModelHolder holder=Controller.flightService.getAllFlights();
        lType.setText(flight.getType());
        lRoute.setText(flight.getRoute().toString());
        lPlane.setText(flight.getPlaneName());
        lStart.setText(flight.getStartTime());
        lFlight.setText(flight.getFlightTime());
        lNumber.setText(Integer.toString(flight.getNumber()));
    }
}
