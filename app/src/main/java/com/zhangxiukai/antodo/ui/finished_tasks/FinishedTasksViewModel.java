package com.zhangxiukai.antodo.ui.finished_tasks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FinishedTasksViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FinishedTasksViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}