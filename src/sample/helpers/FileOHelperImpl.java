package sample.helpers;


import sample.Controller;
import sample.services.FlightModelHolder;
import sample.services.RouteModelHolder;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Артём on 31.10.2015.
 */
public class FileOHelperImpl implements FileOHelper {



    public void saveFile(String filename1, String filename2, FlightModelHolder objectFlightCollection, RouteModelHolder objectRouteCollection) {//////////////////////////////////Эксепшн!!!!!!!!!!!!!
        checkFileExist(filename1);
        checkFileExist(filename2);

        deleteFile(filename1);
        deleteFile(filename2);

        try {
            createFile(filename1);
        } catch (IOException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        try {
            createFile(filename2);

        } catch (IOException e) {
            e.printStackTrace();
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
        }
        JSONSerializationHelperImpl.getInstance().serializeFlights(objectFlightCollection, filename1);
        JSONSerializationHelperImpl.getInstance().serializeRoutes(objectRouteCollection, filename2);
    }
    public void createFile(String s)throws IOException{
        File file = new File(s);
            file.createNewFile();
    }

    public void deleteFile(String s) {
        File file = new File(s);
        checkFileExist(s);
        file.delete();
    }

    public boolean checkFileExist(String filename) {
        File file = new File(filename);
        if (!file.exists()){
            return false;
        }
        return true;
    }

}
