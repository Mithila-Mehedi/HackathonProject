package com.example.hackathonproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hackathonproject.R;

public class MyAcountActivity extends AppCompatActivity implements View.OnClickListener {

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
            Intent intent = new Intent(MyAcountActivity.this, SignUpActivity.class);
            startActivity(intent);
            finishAffinity();
        } else if (view.getId() == R.id.fitness) {
            Intent intent = new Intent(MyAcountActivity.this, SignUpActivity.class);
            startActivity(intent);
            finishAffinity();
        }
    }
}
