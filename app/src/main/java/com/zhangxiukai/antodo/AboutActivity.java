package com.zhangxiukai.antodo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.noties.markwon.Markwon;
import io.noties.markwon.html.HtmlPlugin;
import io.noties.markwon.image.ImagesPlugin;


public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about);

        final Markwon markwon = Markwon.builder(getApplicationContext())
                .usePlugin(ImagesPlugin.create())
                .usePlugin(HtmlPlugin.create())
                .build();

        markwon.setMarkdown(findViewById(R.id.textView2), getString(R.string.long_markdown));
    }
}