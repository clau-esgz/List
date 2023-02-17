import uaslp.objetos.list.arraylist.ArrayList;
import uaslp.objetos.list.arraylist.ArrayListIterator;


public class Main {
    public static void main(String[] args) {
        String info;
        ArrayList arrayList = new ArrayList();
        ArrayListIterator iterator;
        iterator = arrayList.getIterator();

       arrayList.addAtTail("C");
       // impirmira C null
        System.out.println("inicio de impresion de arreglo");
       while(iterator.hasNext()){
           String array = iterator.next();
           System.out.println(" " + array);
       }
        System.out.println("final de impresion de arreglo");

        arrayList.addAtTail("D");
       //imprimira C D
        iterator = arrayList.getIterator();
        System.out.println("inicio de impresion de arreglo");
        while(iterator.hasNext()){
            String array = iterator.next();
            System.out.println(" " + array);
        }
        System.out.println("final de impresion de arreglo");

        arrayList.addAtFront("B");
       // Imprimira B C D
        iterator = arrayList.getIterator();
        System.out.println("inicio de impresion de arreglo");
        while(iterator.hasNext()){
            String array = iterator.next();
            System.out.println(" " + array);
        }
        System.out.println("final de impresion de arreglo");

        arrayList.addAtFront("A");
        //Imprimira  A B C D
        iterator = arrayList.getIterator();
        System.out.println("inicio de impresion de arreglo");
        while(iterator.hasNext()){
            String array = iterator.next();
            System.out.println(" " + array);
        }
        System.out.println("final de impresion de arreglo");


        arrayList.remove(3);
       // Imprimira A B C
        iterator = arrayList.getIterator();
        System.out.println("inicio de impresion de arreglo");
        while(iterator.hasNext()){
            String array = iterator.next();
            System.out.println(" " + array);
        }
        System.out.println("final de impresion de arreglo");

        arrayList.removeAllWithValues("C");
        // imprimira A B
        iterator = arrayList.getIterator();
        System.out.println("inicio de impresion de arreglo");
        while(iterator.hasNext()){
            String array = iterator.next();
            System.out.println(" " + array);
        }
        System.out.println("final de impresion de arreglo");


        arrayList.setAt(0,"Z");
         // Imprimira Z B
        iterator = arrayList.getIterator();
        System.out.println("inicio de impresion de arreglo");
        while(iterator.hasNext()){
            String array = iterator.next();
            System.out.println(" " + array);
        }
        System.out.println("final de impresion de arreglo");

        info = arrayList.getAt(0);

        System.out.println(" info del index pedido " + info);
        arrayList.removeAll();

        iterator = arrayList.getIterator();

        while(iterator.hasNext()){
            String array = iterator.next();
            System.out.println(" " + array);
        }


    }
}