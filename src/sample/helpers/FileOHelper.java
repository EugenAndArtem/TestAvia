package sample.helpers;


import sample.services.FlightModelHolder;
import sample.services.RouteModelHolder;
import java.io.IOException;

/**
 * Created by Àðò¸ì on 31.10.2015.
 */
public interface FileOHelper {
    void saveFile(String filename1, String filename2, FlightModelHolder objectFlightCollection, RouteModelHolder objectRouteCollection);
    void createFile(String s)throws IOException ;
    void deleteFile(String s) ;
    boolean checkFileExist(String filename);
}
