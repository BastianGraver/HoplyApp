package com.example.hoply;

import static android.util.Log.d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

import com.example.hoply.database.AppDatabase;
import com.example.hoply.database.Users;
import com.example.hoply.database.UserDao;

public class MainActivity extends AppCompatActivity {
    AppDatabase database;
    UserDao userDao;
    int databaseSize;
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
        //init
        nameInput = findViewById(R.id.NameInput);
        userNameInput = findViewById(R.id.UsernameInput);
    }

    public void createUser(View view){
        Users newUser = new Users();
        newUser.id = userNameInput.getText().toString();
        newUser.name = nameInput.getText().toString();
        newUser.timestamp = System.currentTimeMillis();
        Button b = (Button) view;
        userDao.insert(newUser);
        b.setText("User created");
        d("Bastian", "Table size: " + userDao.getAll().size());
    }

}