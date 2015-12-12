package sample.helpers;


import sample.Controller;
import sample.services.FlightModelHolder;
import sample.services.RouteModelHolder;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ���� on 31.10.2015.
 */
public class JSONSerializationHelperImpl implements SerializationHelper {

    private static JSONSerializationHelperImpl singleton = null;

    private JSONSerializationHelperImpl() {}

    public static JSONSerializationHelperImpl getInstance() {
        if (singleton == null)
            singleton = new JSONSerializationHelperImpl();
        return singleton;
    }

    public void serializeFlights(FlightModelHolder object, String fileName)  {////////////////�������?
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileName));
            stream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void serializeRoutes(RouteModelHolder object, String fileName)  {
        try {
            System.out.println(fileName);
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileName));
            stream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    public Object deserialize(String fileName) {
        Object object;
        ObjectInputStream stream = null;
        try {
            stream = new ObjectInputStream(new FileInputStream(fileName));
            object = stream.readObject();
            return object;
        } catch (ClassNotFoundException e) {
            e.getMessage();
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } catch (EOFException e) {
            e.getMessage();
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } catch (IOException e) {
            e.getMessage();
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }


}
