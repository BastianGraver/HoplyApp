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
    EditText postInput;
    private List<Users> usersList;
    private List<Posts> postList;
    private RecyclerView recyclerView;
    recyclerAdapter adapter;
    Users currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);
        // sets up the user greetings.
        currentUser = MainActivity.userDao.findId(getIntent().getStringExtra("Username")).get(0);
        greetings = findViewById(R.id.Greetings);
        greetings.setText("Hello " + currentUser.name);

        // init for user input.
        postInput = findViewById(R.id.post_input);

        // Sets up Daos
        usersList = MainActivity.userDao.getAll();
        postList = MainActivity.postDao.getAll();

        // Sets up the recycleView.
        recyclerView = findViewById(R.id.Feed);
        adapter = new recyclerAdapter((new ArrayList<Posts>(postList)));
        setAdapter();

    }

    private void setAdapter() {
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

    public void createPost(View view){
        Posts post = new Posts();
        post.content = postInput.getText().toString();
        post.user_id = currentUser.id;
        post.timestamp = System.currentTimeMillis();
        MainActivity.postDao.insert(post);
        postList = MainActivity.postDao.getAll();
        adapter = new recyclerAdapter((new ArrayList<Posts>(postList)));
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

}