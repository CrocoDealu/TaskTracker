package Tests;

import Model.Commands.ListAllCommand;
import Containers.TaskMapContainer;
import Model.Tasks.Task;
import Utils.ContainerPrinter;
import Enum.CommandStrategy;

import org.junit.Test;

public class ListAllCommandTest {
    @Test
    public void testExecute() {
        TaskMapContainer container = new TaskMapContainer();
        ContainerPrinter<Task> printer = new ContainerPrinter<>(container);

        ListAllCommand c = new ListAllCommand(CommandStrategy.LIST, printer);
        c.execute(container);
        assert printer.getContainer().isEmpty();

        Task t1 = new Task(1, "ss", "s");

        container.add(t1);

        c.execute(container);
        assert printer.getContainer().size() == 1;
    }
}
