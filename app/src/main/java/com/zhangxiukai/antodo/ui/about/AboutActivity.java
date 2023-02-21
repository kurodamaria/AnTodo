package com.zhangxiukai.antodo.ui.about;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zhangxiukai.antodo.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.noties.markwon.Markwon;
import io.noties.markwon.ext.tasklist.TaskListPlugin;
import io.noties.markwon.html.HtmlPlugin;
import io.noties.markwon.image.ImagesPlugin;


public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about);

        // todo refactor this into a view model.

        final Context context = getApplicationContext();
        final Markwon markwon = Markwon.builder(context)
                .usePlugin(ImagesPlugin.create())
                .usePlugin(HtmlPlugin.create())
                .usePlugin(TaskListPlugin.create(context))
                .build();

        final InputStream stream = getResources().openRawResource(R.raw.about);
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        String markdown = "";
        byte[] buffer = new byte[1024];
        try {
            for (int length; (length = stream.read(buffer)) != -1; ) {
                result.write(buffer, 0, length);
            }
            // StandardCharsets.UTF_8.name() > JDK 7
            markdown = result.toString("UTF-8");
        } catch (IOException e) {
            markdown = "Failed to read about markdown.";
        }

        markwon.setMarkdown(findViewById(R.id.textView2), markdown);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                final Intent intent = new Intent(AboutActivity.this, MainActivity.class);
//                startActivity(intent);
//                break;
//        }
        return super.onOptionsItemSelected(item);
    }
}
