package sample.helpers;

import sample.services.*;

import sample.services.BaseModelHolder;

import java.io.IOException;

/**
 * Created by Àðò¸ì on 31.10.2015.
 */
public interface SerializationHelper {
    void  serializeFlights(FlightModelHolder object, String fileName) ;
    void  serializeRoutes(RouteModelHolder object, String fileName) ;

    Object deserialize(String fileName);
}
