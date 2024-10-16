package Tests;

import Model.Commands.UpdateCommand;
import Containers.TaskMapContainer;
import Model.Tasks.Task;

import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;

public class UpdateCommandTest {
    @Test
    public void testExecute() {
        TaskMapContainer container = new TaskMapContainer();
        Task task = new Task(0, "Old Task", "to do", LocalDateTime.now(), LocalDateTime.now());
        container.add(task);

        UpdateCommand updateCommand = new UpdateCommand("update 1 \"UpdatedTask\"");
        updateCommand.execute(container);

        Task updatedTask = container.get(1);
        assert updatedTask.getDescription().equals("Updated Task");
        assert updatedTask.getStatus().equals("to do");
    }

    @Test(expected = IOException.class)
    public void testExecuteInvalidInput() {
        new UpdateCommand("update InvalidInput");
    }
}
