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

public class User_Page extends AppCompatActivity {
    TextView greetings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);
        greetings = findViewById(R.id.Greetings);
        greetings.setText("Hello " + getIntent().getStringExtra("Name"));
    }

    public void logout(View view){
        Intent newIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(newIntent);
        finish();
    }
}