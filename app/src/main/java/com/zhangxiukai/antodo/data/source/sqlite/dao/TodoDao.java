package com.zhangxiukai.antodo.data.source.sqlite.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.zhangxiukai.antodo.data.source.sqlite.model.Todo;

import java.util.List;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM todo")
    LiveData<List<Todo>> getAll();

    @Query("SELECT * FROM todo WHERE id = :id")
    Todo findById(int id);

    @Update
    void update(Todo todo);

    @Insert
    void insertAll(Todo... todos);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Todo todo);

    @Delete
    void delete(Todo todo);

    @Query("SELECT * FROM todo WHERE is_done=1")
    LiveData<List<Todo>> getAllDone();

    @Query("SELECT * FROM todo WHERE is_done=0")
    LiveData<List<Todo>> getAllNotDone();
}
