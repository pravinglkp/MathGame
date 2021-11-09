package com.pravinglkp.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    TextView finalScoreTextView;
    Button playAgainButton,exitButton;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        finalScoreTextView =findViewById(R.id.finalScoreTextView);
        playAgainButton=findViewById(R.id.playAgainButton);
        exitButton =findViewById(R.id.exitButon);

        Intent i = getIntent();
        score = i.getIntExtra("score",0);
        finalScoreTextView.setText("Score : "+score);

        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(GameOver.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}