package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;

public class LinkedListIterator implements Iterator {
 private Node currentNode;
    LinkedListIterator(Node head){ // constructor
        currentNode = head;
    }
    public String next(){ //regresa el valor actual y avanza al siguiente elemento
        String value = currentNode.data;
        currentNode = currentNode.next;
        return value;
    }
    public boolean hasNext() {
       if( currentNode == null){
           return false;
       }
       else{
           return true;
       }
    }
}
