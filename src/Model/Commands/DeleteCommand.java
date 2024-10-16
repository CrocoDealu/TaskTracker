package Model.Commands;

import Containers.TaskMapContainer;
import Utils.ComandParser;

import Enum.CommandStrategy;


public class DeleteCommand extends AbstractCommand{

    private final String[] stringTask;
    public DeleteCommand(String args){
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
