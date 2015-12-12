package sample;



/**
 * Created by Àðò¸ì on 27.11.2015.
 */
public  class AddEventRoute extends ParentEvent {
    public AddEventRoute(Object source, Object objectToCollection){
        super(source);
        object=objectToCollection;
        TYPE="addEventRoute";
    }

    public String getType(){
        return TYPE;
    }
    public Object getObject(){
        return object;
    }
    public int getIndex(){
        return index;
    }
}