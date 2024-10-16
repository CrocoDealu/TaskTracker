package Model.Commands;

import Containers.TaskMapContainer;

import Enum.CommandStrategy;
import Model.Tasks.Task;
import Utils.Printer;

public abstract class AbstractListCommand implements Command<TaskMapContainer>{
    protected final Printer<Task> printer;
    CommandStrategy commandStrategy;
    public AbstractListCommand(CommandStrategy c, Printer<Task> printer) {
        super();
        this.printer = printer;
        commandStrategy = c;
    }
}
