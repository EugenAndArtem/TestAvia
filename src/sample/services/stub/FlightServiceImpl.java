package sample.services.stub;

import sample.helpers.JSONSerializationHelperImpl;
import sample.models.Flight;
import sample.models.InnerFlight;
import sample.models.WorldWideFlight;
import sample.services.*;
import java.util.ArrayList;

/**
 * Created by ���� on 31.10.2015.
 */
public class FlightServiceImpl implements FlightService {

    private FlightModelHolder collection = null;


    @Override
    public Flight getFlightByNumber(int n) {
        ArrayList<Flight> coll = collection.<Flight>getArrayList();
        for (int i = 0; i < coll.size(); i++)
            if (coll.get(i).getNumber() == n)
                return coll.get(i);
        return null;
    }

    @Override
    public FlightModelHolder getAllFlights() {
        if (collection == null) {
            collection = (FlightModelHolder) JSONSerializationHelperImpl.getInstance().deserialize("AviaDB.bin");
            if (collection == null)
                collection = new FlightModelHolder();
        }
        return collection;
    }

    @Override
    public FlightModelHolder getInnerFlights()  {
        ArrayList<Flight> coll = collection.<Flight>getArrayList();
        FlightModelHolder collectionInner = new FlightModelHolder();

        for (int i = 0; i < coll.size(); i++)
            if (coll.get(i).getType().equals(InnerFlight.TYPE))
                collectionInner.getArrayList().add(coll.get(i));
        return collectionInner;
    }

    @Override
    public FlightModelHolder getWorldWideFlights() {
        ArrayList coll = collection.<Flight>getArrayList();
        FlightModelHolder collectionWorldWideFlights = new FlightModelHolder();

        for (int i = 0; i < coll.size(); i++) {
            Flight flight = (Flight)coll.get(i);
            if (flight.getType().equals(WorldWideFlight.TYPE))
                collectionWorldWideFlights.getArrayList().add(flight);
        }
        return collectionWorldWideFlights;
    }
    public Flight getFlightByIndex(int ind){
        return (Flight) collection.getArrayList().get(ind);
    }
    
    
}
