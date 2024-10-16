package Model.Commands;

import Containers.TaskMapContainer;
import Model.Tasks.Task;
import Utils.ComandParser;
import Enum.CommandStrategy;

import java.time.LocalDateTime;

public class MarkDoneCommand extends AbstractCommand{

    private String[] stringTask;
    public MarkDoneCommand(String args) {
        super(args);
        CommandStrategy strategy = CommandStrategy.MARK_DONE;
        stringTask = ComandParser.getInstance().parse(args, strategy);
    }

    @Override
    public void execute(TaskMapContainer o) {
        int tid = Integer.parseInt(stringTask[0]);
        Task oldT = o.get(tid);
        Task newT = new Task(tid, oldT.getDescription(), "done", oldT.getCreatedAt(), LocalDateTime.now());
        o.modify(tid, newT);
    }
}
