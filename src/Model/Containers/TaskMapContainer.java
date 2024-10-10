package Model.Containers;

import Model.Tasks.Task;

import java.util.HashMap;
import java.util.List;

public class TaskMapContainer extends AbstractMapContainer<Task>{

    private static final int NOT_INITIALIZED = 0;
    private int lastId;

    public TaskMapContainer() {
        lastId = 1;
    }

    @Override
    public Task remove(int tid) {
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

    public void modify(int tid, Task newT) {
        elems.replace(tid, newT);
    }

    public void setTasks(HashMap<Integer, Task> tasks) {
        elems = tasks;
    }

    public HashMap<Integer, Task> getAll() {
        return elems;
    }
}
