package pl.insudev.notes.Models;

public class Note {
    private int id;
    private String noteTitle;
    private String content;
    private String date;

    public Note() {
    }

    public Note(int id, String noteTitle, String content, String date) {
        this.id = id;
        this.noteTitle = noteTitle;
        this.content = content;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
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
}
