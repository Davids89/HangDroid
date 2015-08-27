package com.example.david.hangdroid;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GameOverActivity extends Activity {

    int mPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        int points = getIntent().getIntExtra("POINTS",0);

        TextView pointsTextView = (TextView) findViewById(R.id.textViewPoints);
        pointsTextView.setText(String.valueOf(points));

        mPoints = points;
    }

    public void saveScore(View v){
        //we create a SharedPreferences variable and read what we have stored
        SharedPreferences preferences = getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);

        //we get the name
        EditText editTextName = (EditText) findViewById(R.id.editTextName);

        String name = editTextName.getText().toString();

        //now we need a editor to write in the SharedPreferences
        SharedPreferences.Editor editor = preferences.edit();

        //save previous values
        String previousScores = preferences.getString("SCORE", "");

        //here is where we write what we want
        editor.putString("SCORE", name + " " + mPoints + " POINTS\n" + previousScores);

        //at last, we need to commit the changes or wont save
        editor.apply();

        finish();
    }

}
