package sample;



/**
 * Created by Àðò¸ì on 27.11.2015.
 */

public  class ChangeEventFlight extends ParentEvent {

    public ChangeEventFlight(Object source, Object objectToCollection, int index){
        super(source);
        TYPE="changeEventFlight";
        this.object=objectToCollection;
        this.index=index;
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