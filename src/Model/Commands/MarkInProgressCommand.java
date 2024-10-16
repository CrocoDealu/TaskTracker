package Model.Commands;

import Model.Containers.TaskMapContainer;
import Enum.CommandStrategy;
import Model.Tasks.Task;
import Utils.ComandParser;

import java.io.IOException;
import java.time.LocalDateTime;

public class MarkInProgressCommand extends AbstractCommand{

    private String[] stringTask;
    public MarkInProgressCommand(String args) throws IOException {
        super(args);
        CommandStrategy strategy = CommandStrategy.MARK_IN_PROGRESS;
        stringTask = ComandParser.getInstance().parse(args, strategy);
    }

    @Override
    public void execute(TaskMapContainer o) {
        int tid = Integer.parseInt(stringTask[0]);
        Task oldT = o.get(tid);
        Task newT = new Task(tid, oldT.getDescription(), "in progress", oldT.getCreatedAt(), LocalDateTime.now());
        o.modify(tid, newT);
    }
}
