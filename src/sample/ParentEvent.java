package sample;

import java.util.EventObject;



/**
 * Created by Àðò¸ì on 27.11.2015.
 */
public abstract class ParentEvent extends EventObject {
    protected String TYPE;
    protected Object object;
    protected int index;

    public ParentEvent(Object source) {
        super(source);
    }

    public abstract Object getObject();

    public abstract String getType();

    public abstract int getIndex();

}  /**
     * Created by Àðò¸ì on 27.11.2015.
     */
