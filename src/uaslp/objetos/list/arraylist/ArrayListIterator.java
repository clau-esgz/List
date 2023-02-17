package uaslp.objetos.list.arraylist;

public class ArrayListIterator {
    private ArrayList arraylist;
    private int currentSpace = 0;

    ArrayListIterator( ArrayList arrayList){ // constructor
        this.arraylist = arrayList;
    }

    public String next(){ //regresa el valor actual y avanza al siguiente elemento
        String data = arraylist.getAt(currentSpace);
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
