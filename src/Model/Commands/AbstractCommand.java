package Model.Commands;

import Containers.TaskMapContainer;

public abstract class AbstractCommand implements Command<TaskMapContainer> {
    protected String args;
    public AbstractCommand(String args) {
        this.args = args;
    }
}
