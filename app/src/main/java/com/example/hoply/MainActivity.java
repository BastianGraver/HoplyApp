package com.example.hoply;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.hoply.database.AppDatabase;
import com.example.hoply.database.User;
import com.example.hoply.database.UserDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Creates a local database for the device
        AppDatabase database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database").enableMultiInstanceInvalidation().build();
        // Creates the Dao for the user.
        UserDao userDao = database.userDao();
        userDao.insertAll();
    }
}