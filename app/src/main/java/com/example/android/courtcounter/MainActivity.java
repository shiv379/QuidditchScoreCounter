package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.android.courtcounter.R.id.beater1A;
import static com.example.android.courtcounter.R.id.beater1B;
import static com.example.android.courtcounter.R.id.beater2A;
import static com.example.android.courtcounter.R.id.beater2B;
import static com.example.android.courtcounter.R.id.chaser1A;
import static com.example.android.courtcounter.R.id.chaser1B;
import static com.example.android.courtcounter.R.id.chaser2A;
import static com.example.android.courtcounter.R.id.chaser2B;
import static com.example.android.courtcounter.R.id.chaser3A;
import static com.example.android.courtcounter.R.id.chaser3B;
import static com.example.android.courtcounter.R.id.keeperA;
import static com.example.android.courtcounter.R.id.keeperB;
import static com.example.android.courtcounter.R.id.seekerA;
import static com.example.android.courtcounter.R.id.seekerB;
import static com.example.android.courtcounter.R.id.teamNameA;
import static com.example.android.courtcounter.R.id.teamNameB;

//import static android.R.attr.y;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int foulsTeamA = 0;
    int foulsTeamB = 0;
    String[] names = new String[16];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateNames();
        updateScores();
    }

    public void updateNames(){
        TextView[] nameTVList = new TextView[16];
        nameTVList[0] = (TextView) findViewById(teamNameA);
        nameTVList[1] = (TextView) findViewById(teamNameB);
        nameTVList[2] = (TextView) findViewById(seekerA);
        nameTVList[3] = (TextView) findViewById(beater1A);
        nameTVList[4] = (TextView) findViewById(beater2A);
        nameTVList[5] = (TextView) findViewById(chaser1A);
        nameTVList[6] = (TextView) findViewById(chaser2A);
        nameTVList[7] = (TextView) findViewById(chaser3A);
        nameTVList[8] = (TextView) findViewById(keeperA);
        nameTVList[9] = (TextView) findViewById(seekerB);
        nameTVList[10] = (TextView) findViewById(beater1B);
        nameTVList[11] = (TextView) findViewById(beater2B);
        nameTVList[12] = (TextView) findViewById(chaser1B);
        nameTVList[13] = (TextView) findViewById(chaser2B);
        nameTVList[14] = (TextView) findViewById(chaser3B);
        nameTVList[15] = (TextView) findViewById(keeperB);

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
        String foulsA = getString(R.string.fouls,foulsTeamA);
        String foulsB = getString(R.string.fouls,foulsTeamB);
        TextView scoreViewA = (TextView) findViewById(R.id.team_a_score);
        TextView foulsViewA = (TextView) findViewById(R.id.team_a_fouls);
        TextView scoreViewB = (TextView) findViewById(R.id.team_b_score);
        TextView foulsViewB = (TextView) findViewById(R.id.team_b_fouls);
        scoreViewA.setText(String.valueOf(scoreTeamA));
        foulsViewA.setText(foulsA);
        scoreViewB.setText(String.valueOf(scoreTeamB));
        foulsViewB.setText(foulsB);
    }

    public void endGame(int team){
//        if (team=0) {
//
//        } else {
//
//        }
        Button gtA = (Button) findViewById(R.id.button_goal_teamA);
        Button gtB = (Button) findViewById(R.id.button_goal_teamB);
        Button sA = (Button) findViewById(R.id.button_snitch_teamA);
        Button sB = (Button) findViewById(R.id.button_snitch_teamB);
        Button fA = (Button) findViewById(R.id.team_a_foul_button);
        Button fB = (Button) findViewById(R.id.team_b_foul_button);
        gtA.setEnabled(false);
        gtB.setEnabled(false);
        sA.setEnabled(false);
        sB.setEnabled(false);
        fA.setEnabled(false);
        fB.setEnabled(false);
    }

    public void goalTeamA(View view){
        scoreTeamA += 10;
        updateScores();
    }
    public void snitchTeamA(View view){
        scoreTeamA += 150;
        updateScores();
        endGame(0);
    }

    public void goalTeamB(View view){
        scoreTeamB += 10;
        updateScores();
    }

    public void snitchTeamB(View view){
        scoreTeamB += 150;
        updateScores();
        endGame(1);
    }

    public void  resetScore(View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulsTeamA = 0;
        foulsTeamB = 0;
        updateScores();
    }

    public void setFoulsTeamA(View view){
        foulsTeamA += 1;
        updateScores();
    }

    public void setFoulsTeamB(View view){
        foulsTeamB += 1;
        updateScores();
    }
}
