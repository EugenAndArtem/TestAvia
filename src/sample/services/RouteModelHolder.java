package sample.services;
import sample.models.*;
import java.util.ArrayList;

/**
 * Created by јртЄм on 13.11.2015.
 */
public class RouteModelHolder extends BaseModelHolder{
    public RouteModelHolder(){
        list = new ArrayList<Route>();
    }
    public ArrayList getArrayList(){
        return list;
    }
    public void add(Object object){
        list.add((Route)object);/////надо ли приводить?
    }
    public void change(Object object, int ind){
        list.set(ind, (Route) object);
    }
    public void remove(int ind){
        list.remove(ind);
    }
}
