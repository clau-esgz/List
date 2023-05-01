package uaslp.objetos.list;

import uaslp.objetos.list.exceptions.BadIndexException;

public interface Iterator <T> {
    T next() throws BadIndexException;
    boolean hasNext();
}