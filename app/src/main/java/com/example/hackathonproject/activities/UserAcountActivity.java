package com.example.hackathonproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.hackathonproject.R;

public class UserAcountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_acount);
        TextView textView = findViewById(R.id.text1);
    }
}
