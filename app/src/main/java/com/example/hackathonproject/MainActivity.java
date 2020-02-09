package com.example.hackathonproject;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;

import static android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth= FirebaseAuth.getInstance();



        CardView applyCardView = findViewById(R.id.ApplyCardViewID);
        CardView instructionCardView = findViewById(R.id.InstructionCardViewID);
        CardView examCardView = findViewById(R.id.ExaminationCardViewID);
        CardView noticeboardCardView = findViewById(R.id.NoticeBoardCardViewID);
        CardView myAccountCardView = findViewById(R.id.MyAccountCardViewID);
        CardView biometricsCardView = findViewById(R.id.BiometricsCardViewID);


        applyCardView.setOnClickListener(this);
    instructionCardView.setOnClickListener(this);
        examCardView.setOnClickListener(this);
        noticeboardCardView.setOnClickListener(this);
        myAccountCardView.setOnClickListener(this);
        biometricsCardView.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ApplyCardViewID) {
            Intent intent = new Intent(MainActivity.this, Apply.class);
            startActivity(intent);
        } else if (v.getId() == R.id.InstructionCardViewID) {
            Intent intent = new Intent(MainActivity.this, InstructionsActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.ExaminationCardViewID) {
            Intent intent = new Intent(MainActivity.this,QuizQuestionActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.BiometricsCardViewID) {
            Intent intent = new Intent(MainActivity.this,Biometrics .class);
            startActivity(intent);

        }
        else if (v.getId() == R.id.MyAccountCardViewID) {
            Intent intent = new Intent(MainActivity.this, MyAcount.class);
            startActivity(intent);

        }
    }
}
