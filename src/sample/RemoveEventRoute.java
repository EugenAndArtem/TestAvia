package sample;



/**
 * Created by ���� on 27.11.2015.
 */


public  class RemoveEventRoute extends ParentEvent {

    public RemoveEventRoute(Object source, int index){
        super(source);
        TYPE="removeEventRoute";
        super.index=index;
    }

    public String getType(){
        return TYPE;
    }
    public Object getObject(){/////////////////////////////////////////////
        return null;
    }
    public int getIndex(){
        return index;
    }
}