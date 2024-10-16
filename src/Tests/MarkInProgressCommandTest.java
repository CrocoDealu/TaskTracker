package Tests;

import Model.Commands.MarkInProgressCommand;
import Containers.TaskMapContainer;
import Model.Tasks.Task;

import org.junit.Test;

import java.time.LocalDateTime;

public class MarkInProgressCommandTest {
    @Test
    public void testExecute() {
        TaskMapContainer container = new TaskMapContainer();
        Task task = new Task(0, "Task", "to do", LocalDateTime.now(), LocalDateTime.now());
        container.add(task);

        MarkInProgressCommand markInProgressCommand = new MarkInProgressCommand("mark_in_progress 1");
        markInProgressCommand.execute(container);

        Task modifiedTask = container.get(1);
        assert modifiedTask.getStatus().equals("in progress");
    }

    @Test
    public void testExecuteInvalidInput() {
        new MarkInProgressCommand("mark-in-progress InvalidInput");
    }
}
