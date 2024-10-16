package Model.Containers;

import Model.Tasks.Task;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractMapContainer<T> implements Container<T>{

    HashMap<Integer, T> elems = new HashMap<>();

    @Override
    public int size() {
        return elems.size();
    }


    public HashMap<Integer, T> getAll() {
        return elems;
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
