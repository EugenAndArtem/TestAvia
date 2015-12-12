package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.models.Flight;
import sample.models.Route;
import sample.services.FlightModelHolder;
import sample.services.RouteModelHolder;
import java.io.IOException;
import java.net.URL;
import java.util.*;


/**
 * Created by Eugen on 26.11.2015.
 */
public class ServiceController extends BaseController  implements Initializable {
    @FXML
    private TabPane services;
    @FXML
    private Button deleteButton;
    @FXML
    private Label infoLabel;
    private FlightModelHolder flightHolder;
    private RouteModelHolder routeHolder;

    public void initialize(URL url, ResourceBundle rb){

        flightHolder = Controller.flightService.getAllFlights();
        routeHolder = Controller.routeService.getAllRoutes();

        sample.List.addListner(this);
        ObservableList<Flight> list = FXCollections.observableArrayList();
        if (flightHolder != null) {
            ArrayList<Flight> flights = flightHolder.getArrayList();
            for (int i = 0; i < flights.size(); i++) {
                list.add((flights.get(i)));
            }
        }
        listFlights.setItems(list);
        ObservableList<Route> list1=FXCollections.observableArrayList();
        if(routeHolder!=null) {
            ArrayList<Route> routes = routeHolder.getArrayList();
            for (int i = 0; i < routes.size(); i++) {
                list1.add(routes.get(i));
            }
        }
        listRoutes.setItems(list1);
    }


    public void showAddFlightWindow(ActionEvent actionEvent) {
        try{
            if(Controller.routeService.getAllRoutes().getArrayList().size()!=0) {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("addFlight.fxml"));
                stage.setTitle("Add Flight");
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
                stage.show();
            }else{
                infoLabel.setText("No route!");
            }
        }catch (IOException ex){}
    }

    public void showAddRouteWindow(ActionEvent actionEvent) {
        try{
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("addRoute.fxml"));
            stage.setTitle("Add Route");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }catch (IOException ex){}
    }

    public void selectAddWindow(ActionEvent actionEvent) {
        Tab tab=services.getSelectionModel().getSelectedItem();
        System.out.println(tab.getText());
        if(tab.getText().equals("Flights"))
            showAddFlightWindow(actionEvent);
        else showAddRouteWindow(actionEvent);
    }

    public void selectDeleteType(ActionEvent actionEvent) {
        Tab tab = services.getSelectionModel().getSelectedItem();
        System.out.println(tab.getText());
        if (tab.getText().equals("Flights")) {
            int ind = listFlights.getSelectionModel().getSelectedIndex();
            if(ind!=-1) {
                sample.List.createFire(new RemoveEventFlight(this, ind));
                Controller.flightService.getAllFlights().remove(ind);
            }
        } else {
            int ind = listRoutes.getSelectionModel().getSelectedIndex();
            if(ind!=-1) {
                ArrayList mas=Controller.flightService.getAllFlights().deleteFlightsByRoute(Controller.routeService.getRouteByIndex(ind));
                for(int i=0; i<mas.size(); i++)
                    sample.List.createFire(new RemoveEventFlight(this, (int)mas.get(i)));
                Controller.routeService.getAllRoutes().remove(ind);
                sample.List.createFire(new RemoveEventRoute(this, ind));

            }
        }
    }
}
