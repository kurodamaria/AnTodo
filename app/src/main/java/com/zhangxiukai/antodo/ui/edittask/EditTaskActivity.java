package com.zhangxiukai.antodo.ui.edittask;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;
import com.zhangxiukai.antodo.R;
import com.zhangxiukai.antodo.databinding.ActivityEditTaskBinding;

public class EditTaskActivity extends AppCompatActivity {
    ActivityEditTaskBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEditTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EditTaskViewModel editTaskViewModel =
                new ViewModelProvider(this).get(EditTaskViewModel.class);

        int todoId = getIntent().getIntExtra("todo_id", -1);
        if (todoId != -1) {
            editTaskViewModel.setTodo(todoId);

            binding.taskEditTitle.setText(editTaskViewModel.getInitialTitle());
            binding.taskEditDescription.setText(editTaskViewModel.getInitialDesc());


            binding.btnModifyTask.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editTaskViewModel.setTitle(binding.taskEditTitle.getText().toString());
                    editTaskViewModel.setDesc(binding.taskEditDescription.getText().toString());
                    if (editTaskViewModel.canSave()) {
                        editTaskViewModel.save();
                        // todo how the fuck do i go back to previous screen
//                        moveTaskToBack(true);
                    } else {
                        // todo show a dialog
                        Snackbar snackbar = Snackbar.make(view, R.string.app_name, 1000);
                        snackbar.show();
                    }
                }
            });
        }


    }
}
