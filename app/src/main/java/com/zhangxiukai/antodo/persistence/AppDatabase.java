package com.zhangxiukai.antodo.persistence;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.zhangxiukai.antodo.persistence.dao.UserDao;
import com.zhangxiukai.antodo.persistence.data.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
