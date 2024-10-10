package Utils;

import Model.Containers.Container;

import java.util.Iterator;

public final class Printer<T> {

    public Printer() {}


    public void printAll(Container<T> container) {
        Iterator<T> iterator = container.iterator();
        while (iterator.hasNext()) {
            T o = iterator.next();
            System.out.println(o);
        }
    }
}
