package Model.Tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Task {
    private int id;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd hh:mm");

    public Task(int id, String description, String status) {
        this.id = id;
        this.description = description;
        this.status = status;
        createdAt = LocalDateTime.now();
    }

    public Task(int id, String description, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(description, task.description);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description = " + description +
                ", status = " + status +
                ", createdAt = " + createdAt.format(formatter) +
                ", updatedAt = " + updatedAt.format(formatter) +
                '}';
    }
}
