package Model.Commands;

import Model.Containers.TaskMapContainer;

import Enum.CommandStrategy;

public abstract class AbstractListCommand implements Command<TaskMapContainer>{

    CommandStrategy commandStrategy;
    public AbstractListCommand(CommandStrategy c) {
        super();
        commandStrategy = c;
    }
}
