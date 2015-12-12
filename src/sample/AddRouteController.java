package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.models.Route;
import sample.models.RouteImpl;

/**
 * Created by Eugen on 26.11.2015.
 */
public class AddRouteController {
    @FXML
    private Button closeButton;
    @FXML
    private TextField fromPoint;
    @FXML
    private TextField toPoint;
    @FXML
    private Label infoLabel;

    public void closeAddRoute(ActionEvent actionEvent) {
        String fromString=fromPoint.getText();
        String toString=toPoint.getText();
        if(fromString.equals("")||toString.equals(""))
        {
            infoLabel.setText("Fill All Field");
        }else {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            String from = fromPoint.getText();
            String to = toPoint.getText();
            Route route = new RouteImpl(from, to);
            Controller.routeService.getAllRoutes().add(route);
            List.createFire(new AddEventRoute(this, route));
            stage.close();
        }
    }
}
