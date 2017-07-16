package com.example.android.snookerscorekepperapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
    int scorePlayerA = 0;
    int scorePlayerB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateScores();
    }

    /**
     * Increase the  score for Player A by TAG points.
     */
    public void addForPlayerA(View view) {
        addPoints(1, view);
    }

    /**
     * Increase the  score for Player B by TAG points.
     */
    public void addForPlayerB(View view) {
        addPoints(2, view);
    }

    public void addPoints(int player, View view) {
        int points =  Integer.parseInt(view.getTag().toString());
        if (player == 1) { //player A
            scorePlayerA += points;
        } else { //player B
            scorePlayerB += points;
        }
        updateScores();
    }

    /**
     * Displays the given score for Player A.
     */
    public void updateScore(int score, int player) {
        int idPlayer = player == 1 ? R.id.playerA_score :  R.id.PlayerB_Score;
        TextView scoreView = (TextView) findViewById(idPlayer);
        scoreView.setText(String.valueOf(score));
    }

    public void updateScores() {
        updateScore(scorePlayerA, 1);
        updateScore(scorePlayerB, 2);
    }

    public void resetScore(View view) {
        scorePlayerA = 0;
        scorePlayerB = 0;
        updateScores();
    }

}

