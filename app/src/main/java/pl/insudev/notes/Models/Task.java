package pl.insudev.notes.Models;

import java.util.UUID;

public class Task {
    private UUID id;
    private String content;
    private String date;
    private boolean isFinished;

    public Task() {
    }

    public Task(String content, String date, boolean isFinished) {
        this.id = UUID.randomUUID();
        this.content = content;
        this.date = date;
        this.isFinished = isFinished;
    }

    public Task(UUID uuid, String content, String date, boolean isFinished) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.isFinished = isFinished;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", isFinished=" + isFinished +
                '}';
    }
}
