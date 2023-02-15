import uaslp.objetos.list.linkedlist.LinkedList;
import uaslp.objetos.list.linkedlist.LinkedListIterator;


public class Main {
    public static void main(String[] args) {
        LinkedList lista = new LinkedList();

       lista.addAtTail("medio");

        LinkedListIterator iterator;
        iterator = lista.getIterator();

        while(iterator.hasNext ()) {
            String data = iterator.next();
            System.out.print(" " + data);
        }
        System.out.println("");

        lista.setAt(0,"aquel");

        iterator = lista.getIterator();

        while(iterator.hasNext ()) {
            String data = iterator.next();
            System.out.print(" " + data);
        }
        System.out.println("");
        
       lista.addAtTail("final"); //adAtTailNoSirve
        iterator = lista.getIterator();

        while(iterator.hasNext ()) {
            String data = iterator.next();
            System.out.print(" " + data);
        }
        System.out.println("");

       lista.addAtFront("Inicio");// inicio aquel final

        iterator = lista.getIterator();

        while(iterator.hasNext ()) {
            String data = iterator.next();
            System.out.print(" " + data);
        }
        System.out.println("");

        lista.addAtFront("este"); // este inicio aquel final

        iterator = lista.getIterator();

        while(iterator.hasNext ()) {
            String data = iterator.next();
            System.out.print(" " + data);
        }
        System.out.println();

       lista.removeAllWithValues("este");// inicio aquel final

        iterator = lista.getIterator();

        while(iterator.hasNext ()) {
            String data = iterator.next();
            System.out.print(" " + data);
            
        }
        System.out.println();


       lista.remove(1); // inicio final
        iterator = lista.getIterator();
        while(iterator.hasNext ()) {
            String data = iterator.next();
            System.out.print(" " + data);
        }



       lista.removeAll();

        iterator = lista.getIterator();

        while(iterator.hasNext ()) {
            String data = iterator.next();
            System.out.println(data);
        }


    }
}