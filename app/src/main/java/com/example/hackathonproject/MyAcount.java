package com.example.hackathonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MyAcount extends AppCompatActivity implements View.OnClickListener {

    Button license,fitness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_acount);

        license=findViewById(R.id.license);
        fitness=findViewById(R.id.fitness);

        license.setOnClickListener(this);
        fitness.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.license) {
            Intent intent = new Intent(MyAcount.this, SignUpActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.fitness) {
            Intent intent = new Intent(MyAcount.this, SignUpActivity.class);
            startActivity(intent);

    }
}}
