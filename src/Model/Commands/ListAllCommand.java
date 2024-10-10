package Model.Commands;

import Model.Containers.TaskMapContainer;

import Enum.CommandStrategy;
import Model.Tasks.Task;
import Utils.Printer;

public class ListAllCommand extends AbstractListCommand {

    public ListAllCommand(CommandStrategy c) {
        super(c);
    }

    @Override
    public void execute(TaskMapContainer o) {
        Printer<Task> printer = new Printer<>();
        printer.printAll(o);
    }
}
