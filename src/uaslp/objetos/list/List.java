package uaslp.objetos.list;


public interface List {
    void addAtTail(Object data);

    void addAtFront(Object data);

    void remove(int index);

    void removeAll();

    void setAt(int index, Object data);

    Object getAt(int index);

    void removeAllWithValue(Object data);

    int getSize();

    Iterator getIterator();

}
