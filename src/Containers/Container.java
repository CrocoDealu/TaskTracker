package Containers;

import java.util.Iterator;

public interface Container<T> {
    T remove(int id) throws Exception;
    void add(T o);
    int size();
    boolean isEmpty();
    Iterator<T> iterator();
}
