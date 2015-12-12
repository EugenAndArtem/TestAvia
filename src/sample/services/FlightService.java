package sample.services;

import sample.models.Flight;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Àðò¸ì on 30.10.2015.
 */

public interface FlightService {
    Flight getFlightByNumber(int n);
    Flight getFlightByIndex(int n);
    FlightModelHolder getAllFlights();
    FlightModelHolder getInnerFlights();
    FlightModelHolder getWorldWideFlights();

}
