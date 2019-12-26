package com.gidw.luis.quiz;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {

    TextView n1, n2, n3, n4, n5, n6, n7, n8, n9, n10;
    String txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        SharedPreferences score = getSharedPreferences("ScoreActivity", Context.MODE_PRIVATE);

        n1 = findViewById(R.id.scoreNivel1);
        n2 = findViewById(R.id.scoreNivel2);
        n3 = findViewById(R.id.scoreNivel3);
        n4 = findViewById(R.id.scoreNivel4);
        n5 = findViewById(R.id.scoreNivel5);
        n6 = findViewById(R.id.scoreNivel6);
        n7 = findViewById(R.id.scoreNivel7);
        n8 = findViewById(R.id.scoreNivel8);
        n9 = findViewById(R.id.scoreNivel9);
        n10 = findViewById(R.id.scoreNivel10);

        txt1 = "" + score.getInt("score_level_1",0);
        txt2 = "" + score.getInt("score_level_2",0);
        txt3 = "" + score.getInt("score_level_3",0);
        txt4 = "" + score.getInt("score_level_4",0);
        txt5 = "" + score.getInt("score_level_5",0);
        txt6 = "" + score.getInt("score_level_6",0);
        txt7 = "" + score.getInt("score_level_7",0);
        txt8 = "" + score.getInt("score_level_8",0);
        txt9 = "" + score.getInt("score_level_9",0);
        txt10 = "" + score.getInt("score_level_10",0);

        try {

            n1.setText(txt1);
            n2.setText(txt2);
            n3.setText(txt3);
            n4.setText(txt4);
            n5.setText(txt5);
            n6.setText(txt6);
            n7.setText(txt7);
            n8.setText(txt8);
            n9.setText(txt9);
            n10.setText(txt10);

        } catch (Exception e) {
            Toast.makeText(ScoreActivity.this, "" + e, Toast.LENGTH_SHORT).show();
        }

    }
}
