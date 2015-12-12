package sample.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.beans.Transient;
import java.io.Serializable;

/**
 * Created by Eugen on 26.10.2015.
 */
public class WorldWideFlight implements Flight ,Serializable {
        public static String TYPE="WorldWideFlight";
        private int number;
        private String planeName;
        private String startTime;
        private String flightTime;
    private int id;
    Route route;

        public WorldWideFlight( int number,String planeName,String startTime,String flightTime,Route route){
            this.number=number;
            this.planeName=planeName;
            this.startTime=startTime;
            this.flightTime=flightTime;
            this.route=route;
        }
    public int getId(){
        return id;
    }
        public int getNumber(){
            return number;
        }

        public String getType(){
            return TYPE;
        }

        public String getPlaneName(){
            return planeName;
        }

        public String getStartTime(){
            return startTime;
        }

        public String getFlightTime(){
            return flightTime;
        }

    @Transient
    public Route getRoute(){
            return route;
        }
        public String toJson(){
            GsonBuilder builder=new GsonBuilder();
            Gson Gson=builder.create();
            return Gson.toJson(this);
        }
    public String toString(){
        return "World Flight "+Integer.toString(number) +" " + planeName + " from " + route.getFromPoint() + " to " + route.getToPoint() + " starts at " + startTime +
                " and arrives at " + flightTime;
    }



}
