package Tests;

import Model.Commands.MarkDoneCommand;
import Containers.TaskMapContainer;
import Model.Tasks.Task;

import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;

public class MarkDoneCommandTest {
    @Test(expected = IOException.class)
    public void testExecuteInvalidInput() throws IOException {
        new MarkDoneCommand("mark-done InvalidInput");
    }

    @Test
    public void testExecute() {
        TaskMapContainer container = new TaskMapContainer();
        Task task = new Task(0, "Task", "to do", LocalDateTime.now(), LocalDateTime.now());
        container.add(task);

        MarkDoneCommand markDoneCommand = new MarkDoneCommand("mark_done 1");
        markDoneCommand.execute(container);

        Task modifiedTask = container.get(1);
        assert modifiedTask.getStatus().equals("done");
    }
}

