package com.zhangxiukai.antodo.ui.main.fragment;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;

import com.zhangxiukai.antodo.R;
import com.zhangxiukai.antodo.adapter.TodoListAdapter;

public class ActiveTasksFragment extends ListFragment {

    //    private FragmentActiveTasksBinding binding;
    private ActiveTasksViewModel activeTasksViewModel;
    private TodoListAdapter adapter;


//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        // Create a view model from view model provider and get the model of HomeViewModel
//
////        binding = FragmentActiveTasksBinding.inflate(inflater, container, false);
//
////        registerForContextMenu(binding.activeTaskListView);
//
//
////        return binding.getRoot();
//    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        activeTasksViewModel =
                new ViewModelProvider(this).get(ActiveTasksViewModel.class);
        adapter = new TodoListAdapter(getActivity().getApplication(), activeTasksViewModel.getTodos().getValue());
        activeTasksViewModel.getTodos().observe(getViewLifecycleOwner(), todos -> adapter.setTodos(todos));
        setListAdapter(adapter);
    }


    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        System.out.println("Create context menu");
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.active_task_list_view) {
            MenuInflater inflater = getActivity().getMenuInflater();
            inflater.inflate(R.menu.task_list_item_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
    }
}