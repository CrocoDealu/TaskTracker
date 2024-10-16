package Containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public abstract class AbstractMapContainer<T> implements Container<T>{

    HashMap<Integer, T> elems = new HashMap<>();

    @Override
    public int size() {
        return elems.size();
    }


    public ArrayList<T> getAll() {
        return new ArrayList<>(elems.values());
    }

    public void listAll() {}
    @Override
    public boolean isEmpty() {
        return elems.isEmpty();
    }

    public Iterator<T> iterator() {
        return elems.values().iterator();
    }
}
