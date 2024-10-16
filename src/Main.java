import Model.Commands.AddCommand;
import Model.Commands.DeleteCommand;
import Model.Commands.ListAllCommand;
import Model.Commands.UpdateCommand;
import Model.Containers.TaskMapContainer;
import Model.Tasks.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

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
            String command = line.split(" ")[0];
            command = command.toUpperCase();
            CommandStrategy coma = CommandStrategy.ADD;
            boolean ok = true;
            try {
                coma = CommandStrategy.valueOf(command);
            } catch (Exception e) {
                System.out.println("List of avalabile commands:");
                for (CommandStrategy co: CommandStrategy.values()) {
                    System.out.println(co.toString().toLowerCase());
                }
                System.out.println();
                ok = false;
            }

            if (ok) {
                try {

                    switch (coma) {
                        case ADD -> {
                            AddCommand c = new AddCommand(line);
                            c.execute(taskMapContainer);
                        }
                        case LIST -> {
                            ListAllCommand c = new ListAllCommand(CommandStrategy.LIST);
                            c.execute(taskMapContainer);
                        }
                        case DELETE -> {
                            DeleteCommand c = new DeleteCommand(line);
                            c.execute(taskMapContainer);
                        }
                        case UPDATE -> {
                            UpdateCommand c = new UpdateCommand(line);
                            c.execute(taskMapContainer);
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage() + "\n");
                }
            }
        }
    }
}