package com.example.hoply;

import static android.util.Log.d;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hoply.database.Users;

public class Create_User extends AppCompatActivity {
    EditText userInput;
    EditText nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        userInput = findViewById(R.id.Username_Input);
        nameInput = findViewById(R.id.Name_Input);
    }
    public void createUser(View view){
        Button btn = (Button) view;
        Users newUser = new Users();
        newUser.id = userInput.getText().toString();
        if (MainActivity.userDao.findId(newUser.id).size() < 1) {
            newUser.name = nameInput.getText().toString();
            newUser.timestamp = System.currentTimeMillis();
            MainActivity.userDao.insert(newUser);
            Intent newIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(newIntent);
            finish();
        }
        else{
            btn.setTextSize(10);
            btn.setText("Username taken");
        }
    }
}