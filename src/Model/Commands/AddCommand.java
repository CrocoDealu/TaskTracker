package Model.Commands;

import Model.Containers.TaskMapContainer;
import Enum.CommandStrategy;
import Model.Tasks.Task;
import Utils.ComandParser;

import java.io.IOException;
import java.time.LocalDateTime;

public class AddCommand extends AbstractCommand{

    private final String[] stringTask;
    public AddCommand(String args) throws IOException {
        super(args);
        CommandStrategy commandStrategy = CommandStrategy.ADD;
        stringTask = ComandParser.getInstance().parse(args, commandStrategy);
    }

    @Override
    public void execute(TaskMapContainer o) {
        Task task = new Task(0, stringTask[0], "to do", LocalDateTime.now(), LocalDateTime.now());
        o.add(task);
    }
}
