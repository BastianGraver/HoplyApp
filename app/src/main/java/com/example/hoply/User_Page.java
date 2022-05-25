package com.example.hoply;

import static android.util.Log.d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.example.hoply.database.Posts;
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

public class User_Page extends AppCompatActivity {
    TextView greetings;
    private List<Users> usersList;
    private List<Posts> postList;
    private RecyclerView recyclerView;
    Users currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);
        currentUser = MainActivity.userDao.findId(getIntent().getStringExtra("Name")).get(0);
        greetings = findViewById(R.id.Greetings);
        greetings.setText("Hello " + currentUser.name);


        usersList = MainActivity.userDao.getAll();
        postList = MainActivity.postDao.getAll();
        recyclerView = findViewById(R.id.Feed);
        setAdapter();

    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter((new ArrayList<Posts>(postList)));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public void logout(View view){
        Intent newIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(newIntent);
        finish();
    }
}