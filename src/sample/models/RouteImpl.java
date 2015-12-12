package sample.models;
import com.google.gson.*;

import java.io.Serializable;

/**
 * Created by Eugen on 25.10.2015.
 */
public class RouteImpl implements Route,Serializable {
    private int id;
    private String fromPoint;
    private String toPoint;

    public RouteImpl(String from, String to) {
        fromPoint = from;
        toPoint = to;
    }

    public String getFromPoint() {
        return fromPoint;
    }
    public int getId(){
        return id;
    }

    public String getToPoint() {
        return toPoint;
    }

    public String toJson() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(this);
    }

    public String toString(){
        return "Route from " + fromPoint + " to " + toPoint;
    }


}
