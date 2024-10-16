package Tests;

import Model.Commands.AddCommand;
import Containers.TaskMapContainer;
import Model.Tasks.Task;

import org.junit.Test;

import java.io.IOException;

public class AddCommandTest {
    @Test
    public void testExecute() {
        TaskMapContainer container = new TaskMapContainer();
        AddCommand addCommand = null;
        try {
             addCommand = new AddCommand("add \"New Task\"");
        } catch (Exception e) {
            assert false;
        }
        addCommand.execute(container);
        assert container.size() == 1;

        Task addedTask = container.get(1);
        assert addedTask.getDescription().equals("New Task");
        assert addedTask.getStatus().equals("to do");
    }

    @Test(expected = IOException.class)
    public void testExecuteInvalidInput() {
        new AddCommand("add InvalidInput");
    }
}

