package com.example.hoply.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Users.class, Posts.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract PostsDao postsDao();
}
