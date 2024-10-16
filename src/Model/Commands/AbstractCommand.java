package Model.Commands;

import Model.Containers.TaskMapContainer;
import Utils.ComandParser;

public abstract class AbstractCommand implements Command<TaskMapContainer> {
    protected String args;
    public AbstractCommand(String args) {
        this.args = args;
    }
}
