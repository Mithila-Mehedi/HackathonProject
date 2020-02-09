package com.example.hackathonproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    TextView t1,t2,t3;

    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t1= findViewById(R.id.textView4);
        t2= findViewById(R.id.textView5);
        t3= findViewById(R.id.textView6);

        sharedPref = SharedPref.getInstance(this);

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
