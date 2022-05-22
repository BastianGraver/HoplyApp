package com.example.hoply.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Users.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
