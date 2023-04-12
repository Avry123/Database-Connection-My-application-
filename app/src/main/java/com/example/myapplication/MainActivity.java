package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText username, password, rollNo;
    Button login, insertRecord, showRecord, searchRecord;

    DatabaseHelper db;

    StringBuffer stringBuffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollNo = findViewById(R.id.rollNo);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        insertRecord = findViewById(R.id.insertRecord);
        showRecord = findViewById(R.id.showRecord);
        searchRecord = findViewById(R.id.searchRecord);
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

        showRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Cursor res = db.viewRecords();
              stringBuffer = new StringBuffer();
              while (res.moveToNext()) {
                  stringBuffer.append("roll no " + res.getString(0));
                  stringBuffer.append("name " + res.getString(1));
                  stringBuffer.append("password " + res.getString(2));
                  stringBuffer.append("\n\n");
                  Log.d("rollNo", res.getString(0));
                  Log.d("rollNo", res.getString(1));
                  Log.d("rollNo", res.getString(2));
//                  Toast.makeText(MainActivity.this,stringBuffer, Toast.LENGTH_SHORT).show();
              }
//                Toast.makeText(MainActivity.this,stringBuffer, Toast.LENGTH_SHORT).show();
            }
        });

        searchRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Cursor res = db.viewSpecificRecords(2);
               while (res.moveToNext()) {
                   String rollNo = res.getString(0);
                   String name = res.getString(1);
                   String password = res.getString(2);
                   Toast.makeText(MainActivity.this,"the id is " + rollNo + " the name is " + name + " the password is " + password ,  Toast.LENGTH_SHORT).show();

               }
            }
        });

    }
}
