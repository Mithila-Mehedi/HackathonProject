package com.example.hackathonproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hackathonproject.R;
import com.example.hackathonproject.database.SharedPref;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView t1 = findViewById(R.id.textView4);
        TextView t2 = findViewById(R.id.textView5);
        TextView t3 = findViewById(R.id.textView6);

        SharedPref sharedPref = SharedPref.getInstance(this);

        Intent i=getIntent();
        String questions=i.getStringExtra("total");
        sharedPref.saveData("total", questions);
        String correct=i.getStringExtra("correct");
        sharedPref.saveData("correct", correct);
        String wrong=i.getStringExtra("wrong");
        sharedPref.saveData("wrong", wrong);

        t1.setText(questions);
        t2.setText(correct);
        t3.setText(wrong);









    }
}
