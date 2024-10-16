package Model.Commands;

import Model.Containers.TaskMapContainer;
import Model.Tasks.Task;
import Utils.ComandParser;

import Enum.CommandStrategy;

import java.io.IOException;
import java.time.LocalDateTime;

public class UpdateCommand extends AbstractCommand{

    private final String[] stringTask;
    public UpdateCommand(String args) throws IOException {
        super(args);
        stringTask = ComandParser.getInstance().parse(args, CommandStrategy.UPDATE);
    }

    @Override
    public void execute(TaskMapContainer o) {
        int tid = Integer.parseInt(stringTask[0]);
        String taskS = stringTask[1];
        Task lastT = o.get(tid);
        Task newT = new Task(lastT.getId(), taskS, lastT.getStatus(), lastT.getCreatedAt(), LocalDateTime.now());
        o.modify(tid, newT);
    }
}
