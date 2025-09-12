package com.example.lab3;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "notes")
public class NoteEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String title;

    @NonNull
    public String type; // "text" หรือ "checklist"

    public String checklistItemsJson; // null ถ้าเป็น textnote
    public String content; // null ถ้าเป็น checklist

    public Date dateCreated;

    public NoteEntity(@NonNull String title, @NonNull String type, String checklistItemsJson, String content, Date dateCreated) {
        this.title = title;
        this.type = type;
        this.checklistItemsJson = checklistItemsJson;
        this.content = content;
        this.dateCreated = dateCreated;
    }
}
