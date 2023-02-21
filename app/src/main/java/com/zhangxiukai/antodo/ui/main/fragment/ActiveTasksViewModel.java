package com.zhangxiukai.antodo.ui.main.fragment;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.zhangxiukai.antodo.data.repository.TodoListFilter;
import com.zhangxiukai.antodo.data.repository.TodoListRepository;
import com.zhangxiukai.antodo.data.source.sqlite.model.Todo;

import java.util.List;

public class ActiveTasksViewModel extends AndroidViewModel {

    private LiveData<List<Todo>> mTodos;
    private TodoListRepository mTodoListRepository;

    public ActiveTasksViewModel(Application application) {
        super(application);
        mTodoListRepository = TodoListRepository.getRepository(application);
        mTodos = mTodoListRepository.getTodosWithFilter(TodoListFilter.NotDone);
    }

    public LiveData<List<Todo>> getTodos() {
        return mTodos;
    }
}