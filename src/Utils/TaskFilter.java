package Utils;

import Containers.TaskMapContainer;
import Model.Tasks.Task;

import java.util.List;
import java.util.stream.Collectors;

public class TaskFilter {
public static List<Task> filterByStatus(TaskMapContainer container, String status) {
        return container.getAll().stream()
                .filter(task -> task.getStatus().equals(status))
                .collect(Collectors.toList());
    }
}
