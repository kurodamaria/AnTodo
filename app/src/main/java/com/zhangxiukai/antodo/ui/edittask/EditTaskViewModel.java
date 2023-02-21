package com.zhangxiukai.antodo.ui.edittask;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.zhangxiukai.antodo.data.repository.TodoListRepository;
import com.zhangxiukai.antodo.data.source.sqlite.model.Todo;

public class EditTaskViewModel extends AndroidViewModel {
    private Todo mTodo;
    final private TodoListRepository repository;

    private boolean mCanSave;

    public EditTaskViewModel(@NonNull Application application) {
        super(application);
        mCanSave = true;
        repository = TodoListRepository.getRepository(application);
    }

    void setTodo(int todoId) {
        mTodo = repository.getTodoById(todoId);
    }

    public String getInitialTitle() {
        return mTodo.title;
    }

    public String getInitialDesc() {
        return mTodo.description;
    }

    public void setTitle(String title) {
        mTodo.title = title;
        mCanSave = !title.isEmpty();
    }

    public void setDesc(String desc) {
        mTodo.description = desc;
    }

    public boolean canSave() {
        return mCanSave;
    }

    public void save() {
        if (mCanSave) {
            repository.update(mTodo);
        }
    }
}
