package com.zhangxiukai.antodo.ui.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zhangxiukai.antodo.R;
import com.zhangxiukai.antodo.databinding.FragmentEmptyTaskListBinding;

public class EmptyTaskListFragment extends Fragment {
    private FragmentEmptyTaskListBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fucking layout
        binding = FragmentEmptyTaskListBinding.inflate(inflater, container, false);

        binding.emptyTaskListImageView.setImageResource(R.drawable.ic_launcher2_foreground);

        return binding.getRoot();
    }
}
