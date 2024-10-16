package Tests;

import Model.Commands.DeleteCommand;
import Containers.TaskMapContainer;
import Model.Tasks.Task;

import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;

public class DeleteCommandTest {
    @Test
    public void testExecute() {
        TaskMapContainer container = new TaskMapContainer();
        Task task = new Task(0, "Delete this task", "to do", LocalDateTime.now(), LocalDateTime.now());
        container.add(task);

        DeleteCommand deleteCommand = new DeleteCommand("delete 1");
        deleteCommand.execute(container);
        assert container.isEmpty();
    }

    @Test(expected = IOException.class)
    public void testExecuteInvalidInput() {
        new DeleteCommand("delete InvalidInput");
    }
}

