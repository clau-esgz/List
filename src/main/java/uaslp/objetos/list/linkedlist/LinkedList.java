package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;


    public int getSize() {
        return size;
    }

    public void addAtTail(T data) throws NotNullAllowedException {
        validateNotNullValue(data);
        Node<T> node = new Node<>();
        node.data = data;
        if (isEmpty() == true) { // si no hay datos
            head = node;
        } else { // ya existen datos entonces tenemos que enlazar nodos
            node.previous = tail;// el nodo nuevo en su "campo" anterior(por decirlo asi) ahora apunta donde apunta tail
            tail.next = node;// ahora el campo siguiente del nodo existente (que era tail )ahora apunta al nuevo nodo
        }
        tail = node;// tail apunta al nodo nuevo
        size++;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }


    public void addAtFront(T data) throws NotNullAllowedException {
        validateNotNullValue(data);
        Node<T> node = new Node<>();
        node.data = data;
        if (isEmpty() == true) { // si no hay datos
            head = node;
            tail = node;
        } else { // ya existen datos entonces tenemos que enlazar nodos
            node.next = head;
            head.previous = node;
            head = node;
        }
        size++;
    }
    public void remove(int index) throws BadIndexException {
        validateBadIndexException(index, size);
        if (size == 1) { // significa que es el unico dato
            head = null;
            tail = null;
            size = 0;
        } else if (index == 0) { // es la cabeza
            head = head.next;
            head.previous = null;
            size--;
        } else if (index == size - 1) { // que es el final de la lista
            tail = tail.previous;
            tail.next = null;
            size--;
        } else { // que el dato a eliminar está en medio
            Node<T> iteratorNode = findNode(index); //se llama a este metodo para encontrar el nodo y nos dé el nodo con todoYSusAtributos
            //Node previous = iteratorNode.getPrevious(); estas dos lineas son equivalentes a iteratorNode.getPrevious().setNext(iteratorNode.getNext()); // ->
            //previous.setNext(iteratorNode.getNext());
            iteratorNode.previous.next = iteratorNode.next;//->
            iteratorNode.next.previous = iteratorNode.previous;//<-
            size--;
        }
    }


    private Node<T> findNode(int indexToRemove) throws BadIndexException { //devuelveTodoElNodo
        validateBadIndexException(indexToRemove, size);
        Node<T> iteratorNode = head; //se crea una variable "iteratorNode" para avanzar, este empieza en la cabeza
        int i = 0;
        while (i != indexToRemove) {
            i++;
            iteratorNode = iteratorNode.next;
        }
        return iteratorNode;
    }


    public void removeAll() {
        head = null;
        tail = null;
        size = 0;
    }

    public void setAt(int index, T data) throws BadIndexException, NotNullAllowedException { //remplaza valores
        Node<T> foundNode = findNode(index);
        validateBadIndexException(index, size);
        validateNotNullValue(data);
        if (foundNode != null) {
            foundNode.data = data;
        }
    }
    public T getAt(int index) throws BadIndexException { //metodo que devuelve informacion de un nodo pedido "obtener en"
        validateBadIndexException(index, size);
        Node<T> currentNode = head; // declaracion de nodo actual
        for (int currentIndex = 0; currentIndex < index; currentIndex++) { //
            currentNode = currentNode.next; //avanza el currentoNode
        }
        return currentNode.data; // se sale del for cuando lo encuentra y retorna la informacion del nodo pedido
    }


    public void removeAllWithValue(T data) {
        Node iteratorNode = head;
        while (iteratorNode != null) {
            if (iteratorNode.data.equals(data)) {
                if (iteratorNode == head && size != 1) {//Es el primer dato
                    head = head.next;
                    head.previous = null;
                    size--;
                } else if (iteratorNode == tail && size != 1) { //Es el ultimo dato
                    tail = tail.previous;
                    tail.next = null;
                    size--;
                } else if (iteratorNode == head && size == 1) { // significa que es el unico dato
                    head = null;
                    tail = null;
                    size = 0;
                } else { //el dato esta en el medio
                    iteratorNode.previous.next = iteratorNode.next; // ->
                    iteratorNode.next.previous = iteratorNode.previous;//<-
                    size--;
                }
            }
            iteratorNode = iteratorNode.next;
        }
    }

    public Iterator getIterator() { //
        return new LinkedListIterator(head);// retorna un objeto de tipo linkedlistiterator sin asignar a una variable
    }
    private void validateNotNullValue(T data) throws NotNullAllowedException {
        if (data == null) {
            throw new NotNullAllowedException();
        }
    }

    private void validateBadIndexException(int index, int tamanno) throws BadIndexException {
        if (index < 0 || index >= tamanno) {
            throw new BadIndexException();
        }
    }
}
