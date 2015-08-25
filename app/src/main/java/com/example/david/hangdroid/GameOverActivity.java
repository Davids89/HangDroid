package com.example.david.hangdroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class GameOverActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        int points = getIntent().getIntExtra("POINTS",0);

        TextView pointsTextView = (TextView) findViewById(R.id.textViewPoints);
        pointsTextView.setText(String.valueOf(points));
    }


}
