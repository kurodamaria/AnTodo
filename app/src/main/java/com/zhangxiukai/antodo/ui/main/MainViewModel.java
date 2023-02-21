package com.zhangxiukai.antodo.ui.main;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zhangxiukai.antodo.data.repository.TodoListFilter;
import com.zhangxiukai.antodo.data.repository.TodoListRepository;
import com.zhangxiukai.antodo.data.source.sqlite.model.Todo;

import java.util.List;

public class MainViewModel extends ViewModel {
    private TodoListFilter filter;
    private MutableLiveData<List<Todo>> todos;
    private MediatorLiveData<Boolean> isTaskListEmpty;
    private TodoListRepository todoListRepository;

    public MainViewModel(TodoListRepository repository) {
        filter = TodoListFilter.NotDone;
        todoListRepository = repository;

        isTaskListEmpty.addSource(todos, todos1 -> {
            isTaskListEmpty.setValue(todos1.isEmpty());
        });


//        todos.setValue(todoListRepository.getTodos(filter));
    }
}
