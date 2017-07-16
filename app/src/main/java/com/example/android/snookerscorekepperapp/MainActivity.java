package com.example.android.snookerscorekepperapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int PLAYER_A_ID = 1;
    private final int PLAYER_B_ID = 2;

    private int scorePlayerA = 0;
    private int scorePlayerB = 0;

    private TextView playerAScoreView;
    private TextView playerBScoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerAScoreView = (TextView) findViewById(R.id.playerA_score);
        playerBScoreView = (TextView) findViewById(R.id.playerB_score);

        findViewById(R.id.player_A_red_ball_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addForPlayerA(view);
            }
        });

        findViewById(R.id.reset_score_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetScore();
            }
        });

        updateScores();
    }

    /**
     * Increase the  score for Player A by TAG points.
     */
    public void addForPlayerA(View view) {
        addPoints(PLAYER_A_ID, view);
    }

    /**
     * Increase the  score for Player B by TAG points.
     */
    public void addForPlayerB(View view) {
        addPoints(PLAYER_B_ID, view);
    }

    public void addPoints(int playerId, View view) {
        int points = Integer.parseInt(view.getTag().toString());
        if (playerId == PLAYER_A_ID) {
            scorePlayerA += points;
        } else {
            scorePlayerB += points;
        }
        updateScores();
    }

    /**
     * Displays the given score for Player A.
     */
    public void updateScore(int score, int playerId) {
        final String scoreString = String.valueOf(score);
        if (playerId == PLAYER_A_ID) {
            playerAScoreView.setText(scoreString);
        } else {
            playerBScoreView.setText(scoreString);
        }
    }

    public void updateScores() {
        updateScore(scorePlayerA, PLAYER_A_ID);
        updateScore(scorePlayerB, PLAYER_B_ID);
    }

    public void resetScore() {
        scorePlayerA = 0;
        scorePlayerB = 0;
        updateScores();
    }
}

