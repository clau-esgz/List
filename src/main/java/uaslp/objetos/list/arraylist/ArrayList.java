package uaslp.objetos.list.arraylist;
import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;


//nota inserted es cuanto llevo y array.length es cuanto espacio tengo en total
public class ArrayList <T> implements List<T> {
    public static final int INITIAL_SIZE = 2;

    private T[] array;
    private int inserted; //cuantos datos se han insertado al arreglo

    public ArrayList() {
        array = (T[])new Object [INITIAL_SIZE];
    }

    public void addAtTail(T data) throws NotNullAllowedException {
        if (data == null){
            throw new NotNullAllowedException();
        }
        if (inserted == array.length) {
            increaseSize();
        }
        array[inserted] = data;
        inserted++;
    }

    private void increaseSize() {
        T[] newArray = (T[])new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public int getSize() {
        return inserted;
    }

    public int getLength() {
        int length = array.length;
        return length;
    }

    public void removeAll() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
            inserted--;
        }
    }

    public void addAtFront(T data)throws NotNullAllowedException {
        if (data == null){
            throw new NotNullAllowedException();
        }
        if (inserted == array.length) {
            increaseSize();
        }
        for (int i = inserted; i > 0; i--) { //inicia CON EL VALOR DE insertados
            array[i] = array[i - 1];
        }
        array[0] = data; //al final queda un espacio libre
        inserted++; //incremento el valor de size, porque ya se insertó el dato
    }

    public void remove(int index) throws BadIndexException
    {
        if (index < 0 || index >= inserted) { //valores no validos
            throw new BadIndexException();
        }
        for (int i = index; i < inserted -1; i++)
        {
            array[i] = array[i + 1];
        }
        array[inserted -1] = null;
        inserted--;
    }

    public void setAt(int index,T data) throws BadIndexException,NotNullAllowedException { //remplazar el dato
        if (data == null){
                throw new NotNullAllowedException();
        }
        if (index < 0 || index >= inserted) { //valores no validos
            throw new BadIndexException();
        }
        for (int i = 0; i <= inserted; i++) {
            if (i == index) {
                array[i] = data;
            }
        }
    }


    public T getAt(int index) throws BadIndexException { //retorna info de un index pedido

        T info = (T) "";
        if (index < 0 || index >= inserted) { //valores no validos
            throw new BadIndexException();
        }
        for (int i = 0; i <= inserted; i++) {
            if (i == index) {
                info = array[i];
            }
        }
        return info;
    }

    public void removeAllWithValue(T data) {
        T[] newArray = (T[]) new Object[array.length];
        for (int i = 0; i <= inserted; i++) {
            if (array[i] != data) {
                newArray[i] = array[i];
            }
        }
        array = newArray;
        inserted--;
    }



    public Iterator<T> getIterator(){ //
        return new ArrayListIterator(this);// retorna un objeto de tipo linkedlistiterator sin asignar a una variable
    }



}
