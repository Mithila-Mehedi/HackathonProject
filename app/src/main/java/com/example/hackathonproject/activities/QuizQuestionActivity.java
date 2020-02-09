package com.example.hackathonproject.activities;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hackathonproject.model.Question;
import com.example.hackathonproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class QuizQuestionActivity extends AppCompatActivity {

    Button b1, b2, b3, b4;
    TextView timerTxt, t1_question;
    DatabaseReference reference;
    int total = 0;
    int correct = 0;
    int wrong = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);


        b1 = (Button) findViewById(R.id.firstBtn);
        b2 = (Button) findViewById(R.id.secondBtn);
        b3 = (Button) findViewById(R.id.thirdBtn);
        b4 = (Button) findViewById(R.id.fourthBtn);


        timerTxt = (TextView) findViewById(R.id.timerText);
        t1_question = (TextView) findViewById(R.id.questions);

        updateQuestion();
        reverseTimer(30,timerTxt);


    }

    private void updateQuestion() {
        total++;
        System.out.println(total);
        if (total > 10) {
            Intent i=new Intent(QuizQuestionActivity.this,ResultActivity.class);
            i.putExtra("total", String.valueOf(total));
            i.putExtra("correct", String.valueOf(correct));
            i.putExtra("incorrect", String.valueOf(wrong));
            startActivity(i);

        }
        else {
                        reference = FirebaseDatabase.getInstance().getReference().child("Sheet1").child(String.valueOf(total));
                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                final Question question = dataSnapshot.getValue(Question.class);
                                if(question != null) {
                                    t1_question.setText(question.getQuestion());
                                    b1.setText(question.getOption1());
                                    b2.setText(question.getOption2());
                                    b3.setText(question.getOption3());
                                    b4.setText(question.getOption4());
                                } else {
                                    System.out.println("total=" + total);
                                }

                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b1.getText().toString().equals(question.getAnswer()))
                            {
                                b1.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        updateQuestion();


                                    }
                                }, 1000);

                            }
                            else
                            {
                                wrong++;
                                b1.setBackgroundColor(Color.RED);
                                if (b2.getText().toString().equals(question.getAnswer())) {
                                    b2.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(question.getAnswer())) {
                                    b3.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(question.getAnswer())) {
                                    b4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                                    @Override
                                    public void run() {
                                        b1.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        b2.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        b3.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        b4.setBackground(getResources().getDrawable(R.drawable.signin_bg));

                                        updateQuestion();
                                    }
                                }, 1000);


                            }

                        }
                    });

                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (b2.getText().toString().equals(question.getAnswer()))
                            {
                                b2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                                    @Override
                                    public void run() {
                                        correct++;
                                        b2.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        updateQuestion();

                                    }
                                }, 1000);
                            }
                            else{
                                wrong++;
                                b2.setBackgroundColor(Color.RED);
                                if (b1.getText().toString().equals(question.getAnswer())) {
                                    b1.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(question.getAnswer())) {
                                    b3.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(question.getAnswer())) {
                                    b4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                                    @Override
                                    public void run() {
                                        b1.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        b2.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        b3.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        b4.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        updateQuestion();
                                    }
                                }, 1000);

                            }

                        }
                    });

                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b3.getText().toString().equals(question.getAnswer()))
                            {
                                b3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b3.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        updateQuestion();

                                    }
                                }, 1000);
                            }
                            else{
                                wrong++;
                                b3.setBackgroundColor(Color.RED);
                                if (b2.getText().toString().equals(question.getAnswer())) {
                                    b2.setBackgroundColor(Color.GREEN);
                                } else if (b1.getText().toString().equals(question.getAnswer())) {
                                    b1.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(question.getAnswer())) {
                                    b4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                                    @Override
                                    public void run() {
                                        b1.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        b2.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        b3.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        b4.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        updateQuestion();
                                    }
                                }, 1000);

                            }
                        }
                    });

                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b4.getText().toString().equals(question.getAnswer()))
                            {
                                b4.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                                    @Override
                                    public void run() {
                                        correct++;
                                        b4.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        updateQuestion();

                                    }
                                }, 1000);
                            }
                            else{
                                wrong++;
                                b4.setBackgroundColor(Color.RED);
                                if (b2.getText().toString().equals(question.getAnswer())) {
                                    b2.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(question.getAnswer())) {
                                    b3.setBackgroundColor(Color.GREEN);
                                } else if (b1.getText().toString().equals(question.getAnswer())) {
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                                    @Override
                                    public void run() {
                                        b1.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        b2.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        b3.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        b4.setBackground(getResources().getDrawable(R.drawable.signin_bg));
                                        updateQuestion();
                                    }
                                }, 1000);

                            }
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }

                ;
            });

        }
    }
    public void reverseTimer(int seconds, final TextView tv)
    {
        new CountDownTimer(seconds* 1000 + 1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds=(int) (millisUntilFinished/1000);
                int minutes= seconds%60;
                tv.setText(String.format("%02d",minutes)
                        + ":" + String.format("%02d",seconds));
            }

            @Override
            public void onFinish() {
                tv.setText("completed");
                Intent myintent=new Intent(QuizQuestionActivity.this,ResultActivity.class);
                myintent.putExtra("total", String.valueOf(total));
                myintent.putExtra("correct", String.valueOf(correct));
                myintent.putExtra("wrong", String.valueOf(wrong));
                startActivity(myintent);

            }
        }.start();
    }

}