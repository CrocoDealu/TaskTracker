import Containers.JSONRepository;
import Model.Commands.*;
import Containers.TaskMapContainer;
import Model.Tasks.Task;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import Enum.CommandStrategy;
import Tests.*;
import Utils.CLIPrinter;
import Utils.Printer;

public class Main {
    public static void main(String[] args) throws IOException {
        TestAll.test();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        JSONRepository taskMapContainer = new JSONRepository("/home/david/Development/java-ws/PersonalProjects/TaskTracker/src/tasks.json");
        taskMapContainer.read();
        Printer<Task> printer = new CLIPrinter<>();
        while (true) {
            System.out.print("task-cli ");
            String line = reader.readLine();
            String command = line.split(" ")[0];
            command = command.toUpperCase();
            try {

                switch (command) {
                    case "ADD" -> {
                        AddCommand c = new AddCommand(line);
                        c.execute(taskMapContainer);
                    }
                    case "LIST" -> {
                        if (line.split(" ").length == 1) {
                            ListAllCommand c = new ListAllCommand(CommandStrategy.LIST, printer);
                            c.execute(taskMapContainer);
                        } else {
                            switch (line.split(" ")[1].toUpperCase()) {
                                case "DONE" -> {
                                    ListDoneCommand c = new ListDoneCommand(CommandStrategy.LIST_DONE, printer);
                                    c.execute(taskMapContainer);
                                }
                                case "TODO" -> {
                                    ListToDoCommand c = new ListToDoCommand(CommandStrategy.LIST_TODO, printer);
                                    c.execute(taskMapContainer);
                                }
                                case "IN-PROGRESS" -> {
                                    ListInProgressCommand c = new ListInProgressCommand(CommandStrategy.LIST_IN_PROGRESS, printer);
                                    c.execute(taskMapContainer);
                                }
                                default -> {
                                    System.out.println("Options are: done, todo, in-progress");
                                }
                            }
                        }
                    }
                    case "DELETE" -> {
                        DeleteCommand c = new DeleteCommand(line);
                        c.execute(taskMapContainer);
                    }
                    case "UPDATE" -> {
                        UpdateCommand c = new UpdateCommand(line);
                        c.execute(taskMapContainer);
                    }
                    case "MARK-IN-PROGRESS" -> {
                        MarkInProgressCommand c = new MarkInProgressCommand(line);
                        c.execute(taskMapContainer);
                    }
                    case "MARK-DONE" -> {
                        MarkDoneCommand c = new MarkDoneCommand(line);
                        c.execute(taskMapContainer);
                    }
                    default -> {
                        System.out.println("Avalabile commands are: ");
                        System.out.println("add");
                        System.out.println("update");
                        System.out.println("delete");
                        System.out.println("mark-in-progress");
                        System.out.println("mark-done");
                        System.out.println("list");
                    }
                }
                taskMapContainer.save();
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }
}