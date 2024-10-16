package Model.Commands;

import Model.Containers.TaskMapContainer;
import Model.Tasks.Task;
import Utils.ComandParser;

import Enum.CommandStrategy;

import java.io.IOException;



public class DeleteCommand extends AbstractCommand{

    private final String[] stringTask;
    public DeleteCommand(String args) throws IOException {
        super(args);
        CommandStrategy commandStrategy = CommandStrategy.DELETE;
        stringTask = ComandParser.getInstance().parse(args, commandStrategy);
    }

    @Override
    public void execute(TaskMapContainer o) {
        int tid = Integer.parseInt(stringTask[0]);
        o.remove(tid);
    }
}
