package com.zhangxiukai.antodo.data.repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import com.zhangxiukai.antodo.data.source.sqlite.LocalDatabaseSqlite;
import com.zhangxiukai.antodo.data.source.sqlite.dao.TodoDao;
import com.zhangxiukai.antodo.data.source.sqlite.model.Todo;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TodoListRepository {
    private TodoDao todoDao;
    private LiveData<List<Todo>> mAllTodos;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Handler handler = new Handler(Looper.getMainLooper());

    public TodoListRepository(Application application) {
        todoDao = LocalDatabaseSqlite.getDatabase(application).todoDao();
        mAllTodos = todoDao.getAll();
    }

    public void insert(Todo todo) {
        executor.execute(() -> {
            //Background work here
            todoDao.insert(todo);
//            handler.post(() -> {
//                //UI Thread work here
//            });
        });
    }

    private static TodoListRepository INSTANCE;

    public static TodoListRepository getRepository(Application application) {
        if (INSTANCE == null) {
            INSTANCE = new TodoListRepository(application);
        }
        return INSTANCE;
    }

    public LiveData<List<Todo>> getAllTodos() {
        return mAllTodos;
    }

    public LiveData<List<Todo>> getTodosWithFilter(TodoListFilter filter) {
        switch (filter) {
            case All:
                return getAllTodos();
            case Done:
                return todoDao.getAllDone();
            case NotDone:
                return todoDao.getAllNotDone();
        }
        // stupid fucking java
        return getAllTodos();
    }

    public void update(Todo todo) {
        executor.execute(() -> {
            todoDao.update(todo);
        });
    }

    public void delete(Todo todo) {
        executor.execute(() -> {
            todoDao.delete(todo);
        });
    }

    public Todo getTodoById(int todoId) {
        return todoDao.findById(todoId);
    }
}
