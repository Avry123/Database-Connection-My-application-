package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText username, password, rollNo;
    Button login, insertRecord;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollNo = findViewById(R.id.rollNo);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        insertRecord = findViewById(R.id.insertRecord);
        db = new DatabaseHelper(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username1 = username.getText().toString();
                String password1 = password.getText().toString();
                String rollNo1 = rollNo.getText().toString();
            }
        });
        insertRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username1 = username.getText().toString();
                String password1 = password.getText().toString();
                String rollNo1 = rollNo.getText().toString();
                boolean done = db.insertValue(Integer.valueOf(rollNo1), username1, password1);
                if (done) {
                    Snackbar.make(view, "Record Inserted Successfully", Snackbar.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(view, "Record could not be inserted", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}
