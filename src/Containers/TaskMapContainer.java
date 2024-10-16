package Containers;

import Exceptions.IdNotFoundException;
import Model.Tasks.Task;

import java.util.HashMap;

public class TaskMapContainer extends AbstractMapContainer<Task>{

    private static final int NOT_INITIALIZED = 0;
    private int lastId;

    public TaskMapContainer() {
        lastId = 1;
    }

    @Override
    public Task remove(int tid) {
        Task t = elems.remove(tid);
        if (t == null)
            throw new IdNotFoundException("Id ul nu a fost gasit");
        return elems.remove(tid);
    }

    @Override
    public void add(Task o) {
        if (o.getId() == NOT_INITIALIZED)
            o.setId(getLastId());
        elems.put(o.getId(), o);
        if (o.getId() > lastId)
            lastId = o.getId();
        lastId++;
    }

    private int getLastId() {
        return lastId;    }

    public void setTasks(HashMap<Integer, Task> tasks) {
        elems = tasks;
    }

    public void modify(int tid, Task newT) {

        Task t = elems.get(tid);
        if (t != null) {
            elems.replace(tid, newT);
            return;
        }
        throw new IdNotFoundException("Id ul nu a fost gasit");
    }

    public Task get(int tid) {
        Task t = elems.get(tid);
        if (t != null) {
            return t;
        }
        throw new IdNotFoundException("Id ul nu a fost gasit");
    }
}
