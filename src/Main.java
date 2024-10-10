import Model.Commands.AddCommand;
import Model.Commands.ListAllCommand;
import Model.Containers.TaskMapContainer;
import Model.Tasks.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Enum.CommandStrategy;
import Utils.Printer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TaskMapContainer taskMapContainer = new TaskMapContainer();
        Printer<Task> printer = new Printer<>();
        while (true) {
            System.out.print("task-cli ");
            String line = reader.readLine();
            try {
                AddCommand addCommand = new AddCommand(line);
                addCommand.execute(taskMapContainer);
                ListAllCommand listAllCommand = new ListAllCommand(CommandStrategy.LIST);
                listAllCommand.execute(taskMapContainer);
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n");
            }

        }
    }
}