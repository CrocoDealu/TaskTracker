package Model.Commands;

import Containers.TaskMapContainer;

import Enum.CommandStrategy;
import Model.Tasks.Task;
import Utils.Printer;
import Utils.TaskFilter;

import java.util.List;

public class ListInProgressCommand extends AbstractListCommand{
    public ListInProgressCommand(CommandStrategy c, Printer<Task> printer) {
        super(c, printer);
    }

    @Override
    public void execute(TaskMapContainer o) {
        List<Task> l = TaskFilter.filterByStatus(o, "in progress");
        printer.printAll(l);
    }
}
