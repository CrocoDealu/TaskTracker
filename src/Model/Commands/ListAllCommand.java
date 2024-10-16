package Model.Commands;

import Containers.TaskMapContainer;

import Enum.CommandStrategy;
import Model.Tasks.Task;
import Utils.Printer;

import java.util.ArrayList;

public class ListAllCommand extends AbstractListCommand {
    public ListAllCommand(CommandStrategy c, Printer<Task> printer) {
        super(c, printer);
    }

    @Override
    public void execute(TaskMapContainer o) {
        ArrayList<Task> l = o.getAll();
        printer.printAll(l);
    }
}
