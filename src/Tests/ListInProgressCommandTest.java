package Tests;

import Model.Commands.ListInProgressCommand;
import Containers.TaskMapContainer;
import Model.Tasks.Task;
import Utils.ContainerPrinter;
import Enum.CommandStrategy;

import org.junit.Test;

import java.io.IOException;

public class ListInProgressCommandTest {
    public void testExecute() {
        TaskMapContainer container = new TaskMapContainer();
        ContainerPrinter<Task> printer = new ContainerPrinter<>(container);

        ListInProgressCommand c = new ListInProgressCommand(CommandStrategy.LIST_IN_PROGRESS, printer);
        c.execute(container);
        assert printer.getContainer().isEmpty();

        Task t1 = new Task(1, "ss", "done");

        container.add(t1);

        c.execute(container);
        assert printer.getContainer().isEmpty();

        Task t2 = new Task(1, "ss", "in progress");
        container.add(t2);

        c.execute(container);
        assert printer.getContainer().size() == 1;

    }
    @Test(expected = IOException.class)
    public void testExecuteInvalidInput() {
    }

}
