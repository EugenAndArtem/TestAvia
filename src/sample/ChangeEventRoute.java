package sample;



/**
 * Created by Àðò¸ì on 27.11.2015.
 */
public  class ChangeEventRoute extends ParentEvent {

    public ChangeEventRoute(Object source, Object objectToCollection, int index){
        super(source);
        TYPE="changeEventRoute";
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