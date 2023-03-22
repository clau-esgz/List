package test;
import uaslp.objetos.list.List;
import uaslp.objetos.list.arraylist.ArrayList;
import uaslp.objetos.list.linkedlist.LinkedList;
import uaslp.objetos.list.Iterator;

public class main {
    public static void main(String[] args) {

        List list = new LinkedList();
        list.addAtTail("B"); //B
        list.addAtFront("A"); //AB
        list.addAtFront("X"); //XAB
        list.setAt(0, "Z");//ZAB
        list.remove(0);//AB
        list.getAt(0); //A
        list.removeAllWithValue("B"); // A
        list.getSize();//1

        List array = new ArrayList();
        array.addAtTail("Z"); //Z
        array.addAtFront("Y");//YZ
        array.addAtFront("W");//WYZ
        array.setAt(0, "X");//XYZ
        array.remove(0);//X
        array.getAt(0);//Y
        array.removeAllWithValue("Z");
        array.getSize();

        //AL FINAL imprime A,Y

        System.out.println("inicio de impresion de Lista: ");
        Iterator iteratorList = list.getIterator();
        while (iteratorList.hasNext()) {
            System.out.println("  " + iteratorList.next());
        }
        System.out.println("final de impresion de lista");


        System.out.println("inicio de impresion de Array: ");
        Iterator iteratorArray = array.getIterator();
        while (iteratorArray.hasNext()) {
            System.out.println(iteratorArray.next());
        }
        System.out.println("final de impresion de Array: ");

        array.removeAll();
        list.removeAll();
    }
}
