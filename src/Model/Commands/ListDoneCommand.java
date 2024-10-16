package Model.Commands;

import Containers.TaskMapContainer;

import Enum.CommandStrategy;
import Model.Tasks.Task;
import Utils.Printer;
import Utils.TaskFilter;

import java.util.List;

public class ListDoneCommand extends AbstractListCommand{
    public ListDoneCommand(CommandStrategy c, Printer<Task> printer) {
        super(c, printer);
    }

    @Override
    public void execute(TaskMapContainer o) {
        List<Task> filtered = TaskFilter.filterByStatus(o, "done");
        printer.printAll(filtered);
    }
}
