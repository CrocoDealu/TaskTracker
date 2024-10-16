package Tests;

import Model.Commands.ListToDoCommand;
import Containers.TaskMapContainer;
import Model.Tasks.Task;
import Utils.ContainerPrinter;
import Enum.CommandStrategy;

import org.junit.Test;

import java.io.IOException;

public class ListToDoCommandTest {
    public void testExecute() {
        TaskMapContainer container = new TaskMapContainer();
        ContainerPrinter<Task> printer = new ContainerPrinter<>(container);

        ListToDoCommand c = new ListToDoCommand(CommandStrategy.LIST_TODO, printer);
        c.execute(container);
        assert printer.getContainer().isEmpty();

        Task t1 = new Task(1, "ss", "done");

        container.add(t1);

        c.execute(container);
        assert printer.getContainer().isEmpty();

        Task t2 = new Task(1, "ss", "to do");
        container.add(t2);
        c.execute(container);
        assert printer.getContainer().size() == 1;
    }
    @Test(expected = IOException.class)
    public void testExecuteInvalidInput() {
    }

}
