package sample.services;
import sample.models.Route;
/**
 * Created by ���� on 31.10.2015.
 */
public interface RouteService {
    RouteModelHolder getAllRoutes() ;
    Route getRouteById(int n);
    Route getRouteByIndex(int n);
}
