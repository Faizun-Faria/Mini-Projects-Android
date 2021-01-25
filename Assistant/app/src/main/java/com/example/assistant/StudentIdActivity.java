package com.example.assistant;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentIdActivity extends AppCompatActivity {

    private static final String TAG = "StudentIdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_id);
        final EditText studentId = findViewById(R.id.studentId);
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DashboradActivity.class);
                i.putExtra("studentId", studentId.getText().toString());
                startActivity(i);
            }
        });
    }


    //private class onClickListener implements View.OnClickListener
}

