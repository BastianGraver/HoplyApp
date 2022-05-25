package com.example.hoply;

import static android.util.Log.d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;import static android.util.Log.d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

import com.example.hoply.database.AppDatabase;
import com.example.hoply.database.PostsDao;
import com.example.hoply.database.Users;
import com.example.hoply.database.UserDao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

import com.example.hoply.database.AppDatabase;
import com.example.hoply.database.Users;
import com.example.hoply.database.UserDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static AppDatabase database;
    public static UserDao userDao;
    public static PostsDao postDao;
    TextView userCount;
    EditText nameInput;
    EditText userNameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Creates a local database for the device
        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database").allowMainThreadQueries().build();
        // Creates the Dao for the user.
        userDao = database.userDao();
        d("Bastian", "User Database size: " + userDao.getAll().size());
        postDao = database.postsDao();
        d("Bastian", "Post Database size: " + postDao.getAll().size());
    }

    public void toCreateUser(View view){
        Intent newIntent = new Intent(getApplicationContext(), Create_User.class);
        startActivity(newIntent);
    }
    public void toLogin(View view){
        Intent newIntent = new Intent(getApplicationContext(), Login.class);
        startActivity(newIntent);
    }
}