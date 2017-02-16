package com.example.android.courtcounter;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private int foulsTeamA = 0;
    private int foulsTeamB = 0;
    private String[] names = new String[16];
    private TextView[] nameTVList = new TextView[16];

    private TextView scoreViewA;
    private TextView foulsViewA;
    private TextView scoreViewB;
    private TextView foulsViewB;
    private Button team_a_foul_button;
    private Button team_b_foul_button;
    private LinearLayout goal_layout;
    private LinearLayout snitch_layout;
    private LinearLayout wins_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreViewA = (TextView) findViewById(R.id.team_a_score);
        foulsViewA = (TextView) findViewById(R.id.team_a_fouls);
        scoreViewB = (TextView) findViewById(R.id.team_b_score);
        foulsViewB = (TextView) findViewById(R.id.team_b_fouls);

        nameTVList[0] = (TextView) findViewById(R.id.teamNameA);
        nameTVList[1] = (TextView) findViewById(R.id.teamNameB);
        nameTVList[2] = (TextView) findViewById(R.id.seekerA);
        nameTVList[3] = (TextView) findViewById(R.id.beater1A);
        nameTVList[4] = (TextView) findViewById(R.id.beater2A);
        nameTVList[5] = (TextView) findViewById(R.id.chaser1A);
        nameTVList[6] = (TextView) findViewById(R.id.chaser2A);
        nameTVList[7] = (TextView) findViewById(R.id.chaser3A);
        nameTVList[8] = (TextView) findViewById(R.id.keeperA);
        nameTVList[9] = (TextView) findViewById(R.id.seekerB);
        nameTVList[10] = (TextView) findViewById(R.id.beater1B);
        nameTVList[11] = (TextView) findViewById(R.id.beater2B);
        nameTVList[12] = (TextView) findViewById(R.id.chaser1B);
        nameTVList[13] = (TextView) findViewById(R.id.chaser2B);
        nameTVList[14] = (TextView) findViewById(R.id.chaser3B);
        nameTVList[15] = (TextView) findViewById(R.id.keeperB);

        team_a_foul_button = (Button) findViewById(R.id.team_a_foul_button);
        team_b_foul_button = (Button) findViewById(R.id.team_b_foul_button);
        goal_layout = (LinearLayout) findViewById(R.id.goal_layout);
        snitch_layout = (LinearLayout) findViewById(R.id.snitch_layout);
        wins_layout = (LinearLayout) findViewById(R.id.wins_layout);

        updateNames();
        updateScores();
    }

    public void updateNames() {
        names[0] = "Team A";
        names[1] = "Team B";
        names[2] = "Seeker";
        names[3] = "Beater";
        names[4] = "Beater";
        names[5] = "Chaser";
        names[6] = "Chaser";
        names[7] = "Chaser";
        names[8] = "Keeper";
        names[9] = "Seeker";
        names[10] = "Beater";
        names[11] = "Beater";
        names[12] = "Chaser";
        names[13] = "Chaser";
        names[14] = "Chaser";
        names[15] = "Keeper";

        nameTVList[0].setText(names[0]);
        nameTVList[1].setText(names[1]);
        nameTVList[2].setText(getString(R.string.seeker, names[2]));
        nameTVList[3].setText(getString(R.string.beater, names[3]));
        nameTVList[4].setText(getString(R.string.beater, names[4]));
        nameTVList[5].setText(getString(R.string.chaser, names[5]));
        nameTVList[6].setText(getString(R.string.chaser, names[6]));
        nameTVList[7].setText(getString(R.string.chaser, names[7]));
        nameTVList[8].setText(getString(R.string.keeper, names[8]));
        nameTVList[9].setText(getString(R.string.seeker, names[9]));
        nameTVList[10].setText(getString(R.string.beater, names[10]));
        nameTVList[11].setText(getString(R.string.beater, names[11]));
        nameTVList[12].setText(getString(R.string.chaser, names[12]));
        nameTVList[13].setText(getString(R.string.chaser, names[13]));
        nameTVList[14].setText(getString(R.string.chaser, names[14]));
        nameTVList[15].setText(getString(R.string.keeper, names[15]));

    }

    public void updateScores() {
        String foulsA = getString(R.string.fouls, foulsTeamA);
        String foulsB = getString(R.string.fouls, foulsTeamB);

        scoreViewA.setText(String.valueOf(scoreTeamA));
        foulsViewA.setText(foulsA);
        scoreViewB.setText(String.valueOf(scoreTeamB));
        foulsViewB.setText(foulsB);


        if (scoreTeamA > scoreTeamB) {
            scoreViewA.setTextColor(Color.GREEN);
            scoreViewB.setTextColor(Color.RED);
        } else if (scoreTeamA < scoreTeamB) {
            scoreViewA.setTextColor(Color.RED);
            scoreViewB.setTextColor(Color.GREEN);
        } else {
            scoreViewA.setTextColor(Color.BLACK);
            scoreViewB.setTextColor(Color.BLACK);
        }
    }

    public void endGame() {
        TextView winTextView = (TextView) findViewById(R.id.win_text);
        if (scoreTeamA > scoreTeamB) {
            winTextView.setText(getString(R.string.wins, names[0]));
        } else if (scoreTeamA < scoreTeamB) {
            winTextView.setText(getString(R.string.wins, names[1]));
        } else {
            winTextView.setText(R.string.draw);
        }

        team_a_foul_button.setVisibility(View.INVISIBLE);
        team_b_foul_button.setVisibility(View.INVISIBLE);

        goal_layout.setVisibility(View.GONE);
        snitch_layout.setVisibility(View.GONE);
        wins_layout.setVisibility(View.VISIBLE);
    }

    public void goalTeamA(View view) {
        scoreTeamA += 10;
        updateScores();
    }

    public void snitchTeamA(View view) {
        scoreTeamA += 150;
        updateScores();
        endGame();
    }

    public void goalTeamB(View view) {
        scoreTeamB += 10;
        updateScores();
    }

    public void snitchTeamB(View view) {
        scoreTeamB += 150;
        updateScores();
        endGame();
    }

    public void resetGame(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulsTeamA = 0;
        foulsTeamB = 0;
        updateScores();

        team_a_foul_button.setVisibility(View.VISIBLE);
        team_b_foul_button.setVisibility(View.VISIBLE);
        goal_layout.setVisibility(View.VISIBLE);
        snitch_layout.setVisibility(View.VISIBLE);
        wins_layout.setVisibility(View.GONE);

        for (int i = 2; i < nameTVList.length; i++) {
            nameTVList[i].setPaintFlags(nameTVList[i].getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            nameTVList[i].setEnabled(true);
        }
    }

    public void setFoulsTeamA(View view) {
        foulsTeamA += 1;
        updateScores();
    }

    public void setFoulsTeamB(View view) {
        foulsTeamB += 1;
        updateScores();
    }

    public void playerClickedHandler(View view) {
        TextView textView = (TextView) findViewById(view.getId());
        textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        textView.setEnabled(false);
    }
}
