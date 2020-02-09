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
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;

public class QuizQuestionActivity extends AppCompatActivity {

    private Button b1, b2, b3, b4;
    private TextView timerTxt, t1_question;
    private ArrayList<Question> questions;
    private CountDownTimer timer;
    private int total = 0;
    private int correct = 0;
    private int wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        questions = new ArrayList<>();

        b1 = findViewById(R.id.firstBtn);
        b2 = findViewById(R.id.secondBtn);
        b3 = findViewById(R.id.thirdBtn);
        b4 = findViewById(R.id.fourthBtn);

        timerTxt = findViewById(R.id.timerText);
        t1_question = findViewById(R.id.questions);

        getData();
    }

    private void getData() {
        FirebaseDatabase.getInstance().getReference().child("Sheet1")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot data:dataSnapshot.getChildren()) {
                            questions.add(data.getValue(Question.class));
                        }
                        updateQuestion();
                        reverseTimer(30, timerTxt);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }

    private void updateQuestion() {
        if (total > questions.size() - 1) {
            Intent i=new Intent(QuizQuestionActivity.this,ResultActivity.class);
            i.putExtra("total", String.valueOf(total));
            i.putExtra("correct", String.valueOf(correct));
            i.putExtra("wrong", String.valueOf(wrong));
            startActivity(i);
            finish();
        }
        else {
            final Question question = questions.get(total);
            t1_question.setText(question.getQuestion());
            b1.setText(question.getOption1());
            b2.setText(question.getOption2());
            b3.setText(question.getOption3());
            b4.setText(question.getOption4());

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (b1.getText().toString().equals(question.getAnswer())) {
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
                    else {
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
                    if (b2.getText().toString().equals(question.getAnswer())) {
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
                    else {
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
                    if (b3.getText().toString().equals(question.getAnswer())) {
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
                    else {
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
                    if (b4.getText().toString().equals(question.getAnswer())) {
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
                    else {
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

        total++;
        System.out.println(total);
    }

    public void reverseTimer(int seconds, final TextView tv) {
        timer = new CountDownTimer(seconds* 1000 + 1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds=(int) (millisUntilFinished/1000);
                int minutes= seconds%60;
                tv.setText(String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds));
            }

            @Override
            public void onFinish() {
                tv.setText("completed");
                Intent myintent=new Intent(QuizQuestionActivity.this,ResultActivity.class);
                myintent.putExtra("total", String.valueOf(total));
                myintent.putExtra("correct", String.valueOf(correct));
                myintent.putExtra("wrong", String.valueOf(wrong));
                startActivity(myintent);
                finish();
            }
        };
        timer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        timer.cancel();
    }
}