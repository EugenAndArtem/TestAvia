package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.models.Flight;
import sample.models.InnerFlight;
import sample.models.Route;
import sample.models.WorldWideFlight;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Eugen on 26.11.2015.
 */
public class AddFlightController implements Initializable{
    @FXML
    private Button closeButton;
    @FXML
    private TextField flightType;
    @FXML
    private TextField number;
    @FXML
    private TextField name;
    @FXML
    private TextField startTime;
    @FXML
    private TextField flightTime;
    @FXML
    private Label infoLabel;
    @FXML
    private ChoiceBox<String> selectRoute;
    public void initialize(URL url, ResourceBundle rb){
        ObservableList<String> list= FXCollections.observableArrayList();
        ArrayList<Route> array= Controller.routeService.getAllRoutes().getArrayList();
        for(Route route:array)
            list.add(route.toString());
        selectRoute.setItems(list);
    }
    public void closeAddFlight(ActionEvent actionEvent) throws IOException {
        Flight flight;
        String typeString=flightType.getText();
        String numberString=number.getText();
        String nameString=name.getText();
        String startString=startTime.getText();
        String flightString=flightTime.getText();
        try {
            Integer.parseInt(number.getText());
        }
        catch (Exception e){
            infoLabel.setText("Values is not valid!");
            return;
        }
        if (typeString.equals("") || numberString.equals("") || nameString.equals("") || startString.equals("") || flightString.equals("") || selectRoute.getSelectionModel().getSelectedIndex() == -1) {
            infoLabel.setText("Fill in all the fields, MOTHERFUCKER!!!");
        } else {
            Route route = Controller.routeService.getRouteByIndex(selectRoute.getSelectionModel().getSelectedIndex());

            if (flightType.getText().equals("Inner"))
                flight = new InnerFlight(Integer.parseInt(number.getText()), name.getText(), startTime.getText(), flightTime.getText(), route);
            else
                flight = new WorldWideFlight(Integer.parseInt(number.getText()), name.getText(), startTime.getText(), flightTime.getText(), route);
            Controller.flightService.getAllFlights().add(flight);
            List.createFire(new AddEventFlight(this, flight));

            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        }

    }
}
