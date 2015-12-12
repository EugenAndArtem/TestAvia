package sample.services;
import sample.models.*;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ���� on 13.11.2015.
 */
public class FlightModelHolder extends BaseModelHolder{
    private ArrayList list;
    public FlightModelHolder(){
        list = new ArrayList<Flight>();
    }
    public ArrayList getArrayList(){
        return list;
    }
    public void add(Object object){
        list.add((Flight)object);/////���� �� ���������?
    }
    public void change(Object object, int ind){
        list.set(ind, (Flight) object);
    }
    public void remove(int ind){
        list.remove(ind);
    }

    public ArrayList deleteFlightsByRoute(Route route){
        ArrayList<Flight> flights=list;
        ArrayList<Integer> ind=new ArrayList<Integer>();
        for(int i=0;i<flights.size();i++){
            if(flights.get(i).getRoute()==route){
                flights.remove(i);
                ind.add(i--);
            }
        }
        return ind;
    }
}
