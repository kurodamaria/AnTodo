package com.zhangxiukai.antodo.ui.addtask;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;
import com.zhangxiukai.antodo.R;
import com.zhangxiukai.antodo.databinding.ActivityAddTaskBinding;

public class AddTaskActivity extends AppCompatActivity {

    private ActivityAddTaskBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        AddTaskViewModel addTaskViewModel =
                new ViewModelProvider(this).get(AddTaskViewModel.class);


        binding.taskAddTitle.setText(addTaskViewModel.getTaskTitle());
        binding.taskAddDescription.setText(addTaskViewModel.getTaskDesc());

        binding.btnSaveNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTaskViewModel.setTaskTitle(binding.taskAddTitle.getText().toString());
                addTaskViewModel.setTaskDesc(binding.taskAddDescription.getText().toString());
                if (!addTaskViewModel.getTaskTitle().isEmpty()) {
                    addTaskViewModel.save();
                } else {
                    // todo show a dialog
                    Snackbar snackbar = Snackbar.make(view, R.string.app_name, 1000);
                    snackbar.show();
                }
            }
        });
    }
}
