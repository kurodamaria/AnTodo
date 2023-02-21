package com.zhangxiukai.antodo.data.source.sqlite.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Todo {
    // todo how to solve potential conflict? i.e, when used out all int32 keys
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id = 0;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "is_done")
    public boolean isDone;

    @ColumnInfo(name = "date_done")
    public Date dateDone;

    public Todo(String title, String description, boolean isDone) {
        this.title = title;
        this.description = description;
        this.isDone = isDone;
    }
}
