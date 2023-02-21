package com.zhangxiukai.antodo.ui.settings;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zhangxiukai.antodo.R;
import com.zhangxiukai.antodo.ui.settings.fragment.PreferenceFragment;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings_container, new PreferenceFragment())
                .commit();
    }

}
