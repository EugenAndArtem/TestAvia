package sample.services; /**
 * Created by ���� on 31.10.2015.
 */

import java.io.*;
import java.util.*;

public abstract class BaseModelHolder implements  Serializable{
    protected ArrayList list;
    public abstract ArrayList getArrayList();
    public abstract void add(Object object);
    public abstract void change(Object object,int ind);
    public abstract void remove(int ind);


}
