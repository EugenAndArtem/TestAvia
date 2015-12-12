package sample;

import java.util.ArrayList;

/**
 * Created by Eugen on 27.11.2015.
 */
public class List {
    public static ArrayList<Listener> listener;
    public static void addListner(Listener ln){
        if(listener==null)listener=new ArrayList<Listener>();
        listener.add(ln);
    }
    public static void deleteListner(int ind){
        if(ind<0||ind>=listener.size()){
            return;
        }else listener.remove(ind);
    }
    public static void changeListner(int ind,Listener ln){
        listener.set(ind,ln);
    }
    public static void createFire(ParentEvent pe){
        for(Listener ln:listener)
            ln.handle(pe);
    }
}
