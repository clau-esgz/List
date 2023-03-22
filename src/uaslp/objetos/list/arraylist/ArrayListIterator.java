package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;

public class ArrayListIterator <T> implements Iterator <T> {
    private ArrayList arraylist;
    private int currentSpace = 0;

    ArrayListIterator( ArrayList arrayList){ // constructor
        this.arraylist = arrayList;
    }

    public T next(){ //regress el valor actual y avanza al siguiente elemento
        T data = (T) arraylist.getAt(currentSpace);
        currentSpace ++;
        return data;

    }
    public boolean hasNext() {

        if( currentSpace < arraylist.getSize() ){
            return true;
        }
        else{
            return false;
        }
    }




}
