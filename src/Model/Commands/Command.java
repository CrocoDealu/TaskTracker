package Model.Commands;

public interface Command<T> {
    public void execute(T o);
}
