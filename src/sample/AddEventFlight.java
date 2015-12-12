package sample;



/**
 * Created by Àðò¸ì on 27.11.2015.
 */
public  class AddEventFlight extends ParentEvent {
    public AddEventFlight(Object source, Object objectToCollection){
        super(source);
        object=objectToCollection;
        TYPE="addEventFlight";
    }

    public String getType(){
        return TYPE;
    }
    public Object getObject(){
        return object;
    }

    public int getIndex(){//////////////////////////////////////////////////////
        return 0;
    }
}

