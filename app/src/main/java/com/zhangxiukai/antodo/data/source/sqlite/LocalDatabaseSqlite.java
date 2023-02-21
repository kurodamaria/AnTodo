package com.zhangxiukai.antodo.data.source.sqlite;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.zhangxiukai.antodo.data.source.sqlite.converters.DateTypeConverter;
import com.zhangxiukai.antodo.data.source.sqlite.dao.TodoDao;
import com.zhangxiukai.antodo.data.source.sqlite.model.Todo;

@Database(entities = {Todo.class}, version = 1)
@TypeConverters({DateTypeConverter.class})
public abstract class LocalDatabaseSqlite extends RoomDatabase {
    public abstract TodoDao todoDao();

    private static volatile LocalDatabaseSqlite INSTANCE;

    public static LocalDatabaseSqlite getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LocalDatabaseSqlite.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    LocalDatabaseSqlite.class, "todo_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
