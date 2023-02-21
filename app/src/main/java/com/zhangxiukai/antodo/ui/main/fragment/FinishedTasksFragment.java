package com.zhangxiukai.antodo.ui.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.zhangxiukai.antodo.adapter.TodoListAdapter;
import com.zhangxiukai.antodo.databinding.FragmentFinishedTasksBinding;

public class FinishedTasksFragment extends Fragment {
    private FragmentFinishedTasksBinding binding;
    private FinishedTasksViewModel finishedTasksViewModel;
    private TodoListAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Create a view model from view model provider and get the model of HomeViewModel
        finishedTasksViewModel =
                new ViewModelProvider(this).get(FinishedTasksViewModel.class);
        adapter = new TodoListAdapter(getActivity().getApplication(), finishedTasksViewModel.getTodos().getValue());

        binding = FragmentFinishedTasksBinding.inflate(inflater, container, false);

        finishedTasksViewModel.getTodos().observe(getViewLifecycleOwner(), todos -> adapter.setTodos(todos));

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.finishedTaskListView.setAdapter(adapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}