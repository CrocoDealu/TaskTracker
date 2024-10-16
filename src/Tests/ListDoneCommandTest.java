package Tests;

import Model.Commands.ListDoneCommand;
import Containers.TaskMapContainer;
import Model.Tasks.Task;
import Utils.ContainerPrinter;
import Enum.CommandStrategy;

import org.junit.Test;

import java.io.IOException;

public class ListDoneCommandTest {
    public void testExecute() {
        TaskMapContainer container = new TaskMapContainer();
        ContainerPrinter<Task> printer = new ContainerPrinter<>(container);

        ListDoneCommand c = new ListDoneCommand(CommandStrategy.LIST_DONE, printer);
        c.execute(container);
        assert printer.getContainer().isEmpty();

        Task t1 = new Task(1, "ss", "done");

        container.add(t1);

        c.execute(container);
        assert printer.getContainer().size() == 1;
    }
    @Test(expected = IOException.class)
    public void testExecuteInvalidInput() {
    }

}
