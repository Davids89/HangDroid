package com.example.david.hangdroid;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ScoresActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        SharedPreferences preferences = getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);

        //get the values as strings -- Value / default
        String scores = preferences.getString("SCORE", "NO SCORE");

        TextView scoreTextView = (TextView) findViewById(R.id.textScores);

        //set the text
        scoreTextView.setText(scores);
    }
}
