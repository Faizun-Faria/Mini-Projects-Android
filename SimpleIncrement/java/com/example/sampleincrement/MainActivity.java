package com.example.sampleincrement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int score =0;
    Random rand = new Random();
    int rand1, rand2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button player1 = findViewById(R.id.btn1);
        Button player2 = findViewById(R.id.btn2);
        TextView scor = findViewById(R.id.scoreBoard);

        startGame(player1, player2, scor);

    }


    protected void startGame(final Button p1,final Button p2, final TextView scor){
            p1.setText("0");
            p2.setText("0");
            rand1 = rand.nextInt(10);
            rand2 = rand.nextInt(10);
            p1.setText(""+rand1);
            p2.setText(""+rand2);
            scor.setText("Score :"+score);
            p1.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(rand1>rand2) {
                            score++;
                            scor.setText("Score :"+score);
                        }
                        rand1 = rand.nextInt(10);
                        rand2 = rand.nextInt(10);
                        p1.setText(""+rand1);
                        p2.setText(""+rand2);
                    }
            });
            p2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(rand2>rand1) {
                            score++;
                            scor.setText("Score :"+score);
                        }
                        rand1 = rand.nextInt(10);
                        rand2 = rand.nextInt(10);
                        p1.setText(""+rand1);
                        p2.setText(""+rand2);
                    }
            });
    }
}

