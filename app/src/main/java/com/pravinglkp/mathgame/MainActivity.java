package com.pravinglkp.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    Button buttonAdd,buttonSub,buttonMul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);
        buttonMul = findViewById(R.id.buttonMul);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,GameAdd.class);
                startActivity(i);
                finish();
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,GameSub.class);
                startActivity(i);
                finish();
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,GameMul.class);
                startActivity(i);
                finish();
            }
        });

    }

}