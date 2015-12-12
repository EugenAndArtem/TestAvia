package sample;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;
import sample.models.*;
import sample.helpers.FileOHelper;
import sample.helpers.FileOHelperImpl;
import sample.helpers.JSONSerializationHelperImpl;
import sample.helpers.SerializationHelper;
import sample.services.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.services.stub.FlightServiceImpl;
import sample.services.stub.RouteServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import sample.filters.*;
public class Controller extends BaseController{

    public static FileOHelper fileHelper;
    public static SerializationHelper serializeHelper;

    public static FlightService flightService;
    public static RouteService routeService;

    private FlightModelHolder flightHolder;
    private RouteModelHolder routeHolder;
    FilterDipatcher filterDispatcher;
    @FXML
    private Label infoLabel;
    @FXML
    private CheckBox innerCb;
    @FXML
    private CheckBox worldCb;
    @FXML
    private ChoiceBox<Route> routeCb;
    @FXML
    private TabPane infoTabPane;
    @FXML
    public void initialize(){
        filterDispatcher=new FilterDipatcher(new FilterChain());
        routeCb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                System.out.println(number2);
                filterDispatcher.deleteFilter(FilterSingleton.getRouteInstance());
                Route route=routeService.getRouteByIndex((int)number2);
                filterDispatcher.registerFilter(FilterSingleton.getRouteInstance());
                listFlights.setItems(filterDispatcher.execute(route));
                System.out.println(filterDispatcher);
            }
        });

        fileHelper = new FileOHelperImpl();
        serializeHelper = JSONSerializationHelperImpl.getInstance();

        if (!fileHelper.checkFileExist("AviaDB.bin"))
            try {
                fileHelper.createFile("AviaDB.bin");
            } catch (IOException e) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
                System.exit(2);
            }
        if (!fileHelper.checkFileExist("RouteDB.bin"))
            try {
                fileHelper.createFile("RouteDB.bin");
            } catch (IOException e) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
                System.exit(2);
            }

        flightService = new FlightServiceImpl();
        routeService = new RouteServiceImpl();

        flightHolder = flightService.getAllFlights();
        routeHolder = routeService.getAllRoutes();

        List.addListner(this);
        ObservableList<Flight> list= FXCollections.observableArrayList();
        if(flightHolder!=null) {
            ArrayList<Flight> flights = flightHolder.getArrayList();
            for (int i = 0; i < flights.size(); i++) {
                Flight fl=flights.get(i);
                list.add(fl);
            }
        }
        this.listFlights.setItems(list);
        ObservableList<Route> list1=FXCollections.observableArrayList();
        ObservableList<String> listCb=FXCollections.observableArrayList();
        if(routeHolder!=null) {
            ArrayList<Route> routes = routeHolder.getArrayList();
            for (int i = 0; i < routes.size(); i++) {
                list1.add(routes.get(i));
                listCb.add(routes.get(i).toString());
            }
        }
        this.listRoutes.setItems(list1);
        routeCb.setItems(listRoutes.getItems());
    }
    public void showFullInformation(ActionEvent ev) throws IOException {
        System.out.println("Show Full Info");
        Tab tab=infoTabPane.getSelectionModel().getSelectedItem();
        System.out.println(tab.getText());
        if(tab.getText().equals("Flights"))
        {
            if(listFlights.getSelectionModel().getSelectedIndex()!=-1) {
                Stage stage=new Stage();
                FlightInfo.setFlight((Flight) flightService.getAllFlights().getArrayList().get(listFlights.getSelectionModel().getSelectedIndex()));
                Parent root = FXMLLoader.load(getClass().getResource("flightInfo.fxml"));
                stage.setResizable(false);
                stage.setTitle("Flight");
                stage.setScene(new Scene(root));
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(((Node)ev.getSource()).getScene().getWindow());
                stage.show();
            }

        }
        if(tab.getText().equals("Routes"))
        {
            if(listRoutes.getSelectionModel().getSelectedIndex()!=-1) {
                Stage stage=new Stage();
                RouteInfo.setRoute((Route) routeService.getAllRoutes().getArrayList().get(listRoutes.getSelectionModel().getSelectedIndex()));
                Parent root = FXMLLoader.load(getClass().getResource("routeInfo.fxml"));
                stage.setResizable(false);
                stage.setTitle("Cracker AirLines");
                stage.setScene(new Scene(root));
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(((Node)ev.getSource()).getScene().getWindow());
                stage.show();
            }

        }
        else ;
    }
    private void showFlightInformation(){

    }
    private void showRouteInformation(){

    }
    public void handle(ParentEvent ev){
        System.out.println("Handlee!!!");
        System.out.println(flightService.getAllFlights().getArrayList().size());
        super.handle(ev);
        ArrayList array=flightService.getAllFlights().getArrayList();
        for(int i=0;i<array.size();i++) {
            System.out.println(array.get(i));

        }
        Route r=null;
        int ind=routeCb.getSelectionModel().getSelectedIndex();
        if(ind!=-1)r=(Route)routeHolder.getArrayList().get(ind);
        System.out.println(r);
        filterDispatcher.execute(r);
    }


    public void showServiceWindow(ActionEvent actionEvent) {
        try{

            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("service.fxml"));
            stage.setTitle("Cracker AirLines");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }catch (IOException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }

    public void saveToFile(ActionEvent actionEvent) {
        fileHelper.saveFile("AviaDB.bin", "RouteDB.bin", flightService.getAllFlights(), routeService.getAllRoutes());
    }

    public void deleteFile(ActionEvent actionEvent){

        fileHelper.deleteFile("AviaDB.bin");
        fileHelper.deleteFile("RouteDB.bin");


    }



    public void setLabelInfo(String str){
        infoLabel.setText(str);
    }

    public void innerSelect(ActionEvent actionEvent) {
        Route r=null;
        int ind=routeCb.getSelectionModel().getSelectedIndex();
        if(ind!=-1)r=(Route)routeHolder.getArrayList().get(ind);
        if(innerCb.isSelected()) {
            setInnerFilter(r);
        }else
            deleteInnerFilter(r);

    }
    public void worldSelect(ActionEvent actionEvent) {
        Route r=null;
        int ind=routeCb.getSelectionModel().getSelectedIndex();
        if(ind!=-1)r=(Route)routeHolder.getArrayList().get(ind);
        if(worldCb.isSelected()) {
            setWorldFilter(r);
        }else
            deleteWorldFilter(r);

    }
    public void setInnerFilter(Route r){
        System.out.println("Filter Inner Set");
        filterDispatcher.registerFilter(FilterSingleton.getInnerInstance());
        listFlights.setItems(filterDispatcher.execute(r));
    }
    public void deleteInnerFilter(Route r){
        System.out.println("Filter Inner Delete");
        filterDispatcher.deleteFilter(FilterSingleton.getInnerInstance());
        listFlights.setItems(filterDispatcher.execute(r));
    }
    public void setWorldFilter(Route r){
        System.out.println("Filter World Set");
        filterDispatcher.registerFilter(FilterSingleton.getWorldInstance());
        listFlights.setItems(filterDispatcher.execute(r));
    }
    public void deleteWorldFilter(Route r){
        System.out.println("Filter World Delete");
        filterDispatcher.deleteFilter(FilterSingleton.getWorldInstance());
        ObservableList<Flight> l=filterDispatcher.execute(r);
        listFlights.setItems(l);
    }
}
