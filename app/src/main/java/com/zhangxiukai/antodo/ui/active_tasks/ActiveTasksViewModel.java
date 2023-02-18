package com.zhangxiukai.antodo.ui.active_tasks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class ActiveTasksViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    private final Timer timer;
    private int count = 0;

    public ActiveTasksViewModel() {
        mText = new MutableLiveData<>();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (++count > 10) {
                    timer.cancel();
                } else {
//                    mText.setValue("Count: " + String.valueOf(count));
                    mText.postValue("Count: " + String.valueOf(count));
                }
            }
        }, 1000, 1000);

        mText.setValue("Count: " + String.valueOf(count));
    }

    public LiveData<String> getText() {
        return mText;
    }
}