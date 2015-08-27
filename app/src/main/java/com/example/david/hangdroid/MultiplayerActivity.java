package com.example.david.hangdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MultiplayerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);
    }

    public void startMultiGame(View v){
        EditText wordIntroduced = (EditText) findViewById(R.id.editTextWord);
        Intent myIntent = new Intent(this, GameMultiActivity.class);

        myIntent.putExtra("WORD", wordIntroduced.getText().toString());

        wordIntroduced.setText("");

        startActivity(myIntent);
    }
}
