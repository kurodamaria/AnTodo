package com.zhangxiukai.antodo;

import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class AddTaskActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_task);

        final DatePicker datePicker = findViewById(R.id.task_add_date_picker);
        datePicker.setMinDate(System.currentTimeMillis() - 1000);
    }
}
