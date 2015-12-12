package sample.filters;

/**
 * Created by Eugen on 07.12.2015.
 */
public class FilterSingleton {
    private static Filter innerFilter=null;
    private static Filter worldFilter=null;
    private static Filter routeFilter=null;
    public static Filter getInnerInstance(){
        if(innerFilter==null)innerFilter=new InnerFilter();
        return innerFilter;
    }
    public static Filter getWorldInstance(){
        if(worldFilter==null)worldFilter=new WorldFilter();
        return worldFilter;
    }
    public static Filter getRouteInstance(){
        if(routeFilter==null)routeFilter=new RouteFilter();
        return routeFilter;
    }
}
