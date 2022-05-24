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

public class Login extends AppCompatActivity {
    EditText loginInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginInput = findViewById(R.id.Username_login);
    }
    public void login(View view){
        if (MainActivity.userDao.findId(loginInput.getText().toString()).size() >= 1){
            Intent loginSwitch = new Intent(getApplicationContext(), User_Page.class);
            loginSwitch.putExtra("Name", MainActivity.userDao.findId(loginInput.getText().toString()).get(0).name);
            startActivity(loginSwitch);
            finish();
        }
        else{
            Button btn = (Button) view;
            btn.setTextSize(8);
            btn.setText("Wrong Username, Try again");
        }
    }
}