package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.arraylist.ArrayList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;


    public int getSize() {
        return size;
    }

    public void  addAtTail(String data) {
        Node node = new Node();
        node.data = data;
        if (size == 0){ // si no hay datos
        head = node;
        }
        else { // ya existen datos entonces tenemos que enlazar nodos
         node.previous = tail;// el nodo nuevo en su "campo" anterior(por decirlo asi) ahora apunta donde apunta tail
         tail.next = node;// ahora el campo siguiente del nodo existente (que era tail )ahora apunta al nuevo nodo
        }
        tail = node;// tail apunta al nodo nuevo
      size ++;
    }

    public void addAtFront(String data){
        Node node = new Node();
        node.data = data;
        if (size == 0){ // si no hay datos
            head = node;
            tail = node;
        }
        else { // ya existen datos entonces tenemos que enlazar nodos
            node.next = head;
            head.previous = node;
            head = node;
        }
        size ++;
    }

   public void remove(int index){
        if (index < 0 || index > size) { //valores fuera de rango
            return;
        }
        if (size == 1){ // significa que es el unico dato
            head = null;
            tail = null;
            size = 0;
        }
        else if(index == 0){ // es la cabeza
            head = head.next;
            head.previous = null;
        }
        else if (index == size) { // que es el final de la lista
            tail = tail.previous;
            tail.next = null;
        }
        else{ // que el dato a eliminar está en medio
            Node iteratorNode = findNode(index); //se llama a este metodo para encontrar el nodo y nos dé el nodo con todoYSusAtributos

            //Node previous = iteratorNode.getPrevious(); estas dos lineas son equivalentes a iteratorNode.getPrevious().setNext(iteratorNode.getNext()); // ->
            //previous.setNext(iteratorNode.getNext());

            iteratorNode.previous.next = iteratorNode.next;//->
            iteratorNode.next.previous= iteratorNode.previous;//<-

        }
    }



    private Node findNode(int indexToRemove){ //devuelveTodoElNodo
        if (indexToRemove < 0 || indexToRemove > size){ //valores imposibles
            return null;
        }
        Node iteratorNode = head; //se crea una variable "iteratorNode" para avanzar, este empieza en la cabeza
        int i = 0;
        while(i != indexToRemove) {
            i++;
            iteratorNode = iteratorNode.next;
        }
        return iteratorNode;
    }


    public void removeAll(){
        head = null;
        tail = null;
        size = 0;
    }

    public void setAt(int index,String data){ //remplaza valores
        Node foundNode = findNode(index);
        if (index < 0 || index >= size) { //valores imposibles
            return;
        }
        if ( foundNode != null) {
            foundNode.data = data;
        }
    }

    public String getAt(int index){ //metodo que devuelve informacion de un nodo medido "obtener en"
        if (index < 0 || index > size){ //valores imposibles
            return null;
        }
        Node currentNode = head; // declaracion de nodo actual
        for (int currentIndex = 0; currentIndex <index; currentIndex ++){ //
            currentNode = currentNode.next; //avanza el currentoNode
        }
        return currentNode.data; // se sale del for cuando lo encuentra y retorna la informacion del nodo pedido
    }




    public void removeAllWithValues(String data){
        Node iteratorNode = head;
        while(iteratorNode != null) {
            if (iteratorNode.data.equals(data)) {
                if (iteratorNode == head) // Es el primer dato
                {
                    head = head.next;
                    head.previous = null;
                } else if (iteratorNode == tail) { //Es el ultimo dato
                    tail = tail.previous;
                    tail.next = null;
                } else if (size == 1) { // significa que es el unico dato
                    head = null;
                    tail = null;
                    size = 0;
                } else {
                    iteratorNode.previous.next = iteratorNode.next; // ->
                    iteratorNode.next.previous = iteratorNode.previous;//<-
                }
            }
            iteratorNode = iteratorNode.next;
        }
    }

    public LinkedListIterator getIterator(){ //
      return new LinkedListIterator(head);// retorna un objeto de tipo linkedlistiterator sin asignar a una variable
    }




}

