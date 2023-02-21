package com.zhangxiukai.antodo.adapter;

import android.app.Application;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.zhangxiukai.antodo.R;
import com.zhangxiukai.antodo.data.repository.TodoListRepository;
import com.zhangxiukai.antodo.data.source.sqlite.model.Todo;
import com.zhangxiukai.antodo.ui.edittask.EditTaskActivity;

import java.util.ArrayList;
import java.util.List;

public class TodoListAdapter extends BaseAdapter {

    private List<Todo> mTodos;
    private Application mContext;

    public TodoListAdapter(Application context, List<Todo> todos) {
        this.mContext = context;
        mTodos = todos;
        if (mTodos == null) {
            mTodos = new ArrayList<>();
        }
    }

    @Override
    public int getCount() {
        return mTodos.size();
    }

    @Override
    public Todo getItem(int i) {
        return mTodos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).id;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        System.out.println("getView: " + i + " of " + mTodos.size() + ", " + mTodos.get(i).title);
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).
                    inflate(R.layout.todo_list_item, parent, false);
        }

        Todo todo = mTodos.get(i);

        CheckBox checkBox = convertView.findViewById(R.id.todo_list_item_checked);
        TextView titleTextView = convertView.findViewById(R.id.todo_list_item_title);
        TextView descTextView = convertView.findViewById(R.id.todo_list_item_description);
        ImageButton deleteButton = convertView.findViewById(R.id.todo_list_item_delete_task_button);
        ImageButton editButton = convertView.findViewById(R.id.todo_list_item_edit_task_button);

        checkBox.setChecked(todo.isDone);
        titleTextView.setText(todo.title);
        descTextView.setText(todo.description);

        //! This is called whenever the checkbox's value has changed.
//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                // This called twice?
//                System.out.println("Twice motherfucker!");
//                todo.isDone = b;
//                TodoListRepository.getRepository(mContext).update(todo);
//            }
//        });
        //? This is called whenever the checkbox is clicked.
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todo.isDone = checkBox.isChecked();
                TodoListRepository.getRepository(mContext).update(todo);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TodoListRepository.getRepository(mContext).delete(todo);
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, EditTaskActivity.class);
                intent.putExtra("todo_id", todo.id);
                //! need a better resort
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

        // returns the view for the current row
        return convertView;
    }

    public void setTodos(List<Todo> todos) {
        mTodos = todos;
        notifyDataSetChanged();
    }
}
