package sample.models;

/**
 * Created by Eugen on 25.10.2015.
 */
public interface Flight {
    int getId();
    int getNumber();
    String getType();
    String getPlaneName();
    String getStartTime();
    String getFlightTime();
    Route getRoute();

}
