package sample.services.stub;


import sample.helpers.JSONSerializationHelperImpl;
import sample.services.RouteModelHolder;
import sample.services.RouteService;
import sample.models.*;
import java.util.ArrayList;

/**
 * Created by ���� on 31.10.2015.
 */
public class RouteServiceImpl implements RouteService {

    private RouteModelHolder collection = null;


    @Override
    public RouteModelHolder getAllRoutes() {

        if (collection == null) {
            collection = (RouteModelHolder) JSONSerializationHelperImpl.getInstance().deserialize("RouteDB.bin");
            if (collection == null)
                collection = new RouteModelHolder();
        }
        return collection;

    }

    @Override
    public Route getRouteById(int n) {
        ArrayList<Route> coll = collection.getArrayList();
        for(int i=0; i<coll.size(); i++)
            if(coll.get(i).getId() == n)
                return coll.get(i);
        return null;
    }
    public Route getRouteByIndex(int ind){
        return (Route) collection.getArrayList().get(ind);
    }
}
