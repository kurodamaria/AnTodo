package com.zhangxiukai.antodo.ui.addtask;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.zhangxiukai.antodo.data.repository.TodoListRepository;
import com.zhangxiukai.antodo.data.source.sqlite.model.Todo;

public class AddTaskViewModel extends AndroidViewModel {
    private final TodoListRepository repository;

    private final MutableLiveData<String> mTaskTitle;
    private final MutableLiveData<String> mTaskDesc;

    private final MediatorLiveData<Boolean> mCanSave;

    public AddTaskViewModel(@NonNull Application application) {
        super(application);

        mTaskTitle = new MutableLiveData<>("");
        mTaskDesc = new MutableLiveData<>("");
        mCanSave = new MediatorLiveData<>();

        mCanSave.addSource(mTaskTitle, title -> mCanSave.setValue(!title.isEmpty()));
        // no need to add deadline as source since it is always set

        repository = TodoListRepository.getRepository(application);

    }

    private void setCanSave(String s) {
        System.out.println("SET CAN SAVE?");
        mCanSave.setValue(!mTaskTitle.getValue().isEmpty());
    }

    public String getTaskTitle() {
        return mTaskTitle.getValue();
    }

    public String getTaskDesc() {
        return mTaskDesc.getValue();
    }

    public LiveData<Boolean> getCanSave() {
        return mCanSave;
    }

    public void setTaskTitle(String taskTitle) {
        mTaskTitle.setValue(taskTitle);
    }

    public void setTaskDesc(String taskDesc) {
        mTaskDesc.setValue(taskDesc);
    }

    public void save() {
        if (!mTaskTitle.getValue().isEmpty()) {
            repository.insert(new Todo(mTaskTitle.getValue(), mTaskDesc.getValue(), false));
        }
    }
}
