package com.pravinglkp.mathgame;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
public class GameMul extends AppCompatActivity {
    TextView scoreTextView,lifeTextView,timeTextView;
    TextView questionTextView;
    EditText ansEditText;
    Button okButton,nextButton;

    Random random= new Random();
    int number1,number2,realRes,userRes;

    int score=0,life=3;

    CountDownTimer timer;
    private static final long START_TIMER_IN_MILIS=60000;
    long timeLeftInMillis=START_TIMER_IN_MILIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mul);

        scoreTextView = findViewById(R.id.scoreTextView);
        lifeTextView = findViewById(R.id.lifeTextView);
        timeTextView = findViewById(R.id.timeTextView);

        questionTextView = findViewById(R.id.queTextView);
        ansEditText = findViewById(R.id.ansEditText);

        okButton = findViewById(R.id.okButton);
        nextButton = findViewById(R.id.nextButton);

        createQuestion();
        nextButton.setEnabled(false);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseTimer();
                userRes=Integer.parseInt(ansEditText.getText().toString());
                chkAnswer();
                nextButton.setEnabled(true);
                okButton.setEnabled(false);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createQuestion();
                ansEditText.setText("");
                okButton.setEnabled(true);
                nextButton.setEnabled(false);
            }
        });
    }
    private void createQuestion(){
        number1 = random.nextInt(100);
        number2 = random.nextInt(100);
        realRes = number1*number2;
        questionTextView.setText(number1+" * "+number2);
        resetTimer();
        startTimer();
    }

    private void chkAnswer() {

        if(userRes==realRes){
            questionTextView.setText("Congradulations,Your Answer is right");
            score=score+10;
            scoreTextView.setText(""+score);
        }
        else{
            questionTextView.setText("Your answer is wrong");
            life=life-1;
            lifeTextView.setText(""+life);
            chkGameOver();
        }
    }

    private void chkGameOver() {
        if(life==0){
            Toast.makeText(getApplicationContext(),"Game Over",Toast.LENGTH_LONG).show();

            Intent i = new Intent(GameMul.this,GameOver.class);
            i.putExtra("score",score);
            startActivity(i);
            finish();
        }
    }
    private void startTimer(){

        timer = new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis=millisUntilFinished;
                updateText();
            }
            @Override
            public void onFinish() {
                pauseTimer();
                okButton.setEnabled(false);
                nextButton.setEnabled(true);
                life=life-1;
                lifeTextView.setText(""+life);
                questionTextView.setText("Time is up");
                chkGameOver();
            }
        }.start();
    }
    private void updateText() {
        int second=(int)(timeLeftInMillis/1000) % 60;
        timeTextView.setText(String.format("%02d",second));
    }
    private void pauseTimer() {
        timer.cancel();
    }
    private void resetTimer() {
        timeLeftInMillis=START_TIMER_IN_MILIS;
        updateText();
    }
}