package com.example.david.hangdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameMultiActivity extends Activity {

    String mWord;
    int nFails = 0;
    int aciertos = 0;
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_game);
        mWord = getIntent().getStringExtra("WORD");
        createTextView(mWord);
    }

    /**
     * Devuelve la letra introducida en el edittext
     * @param v (boton clickado)
     */
    public void introduceLetter(View v){
        EditText myEditText = (EditText) findViewById(R.id.editTextLetter);

        String letter = myEditText.getText().toString();

        myEditText.setText("");

        Log.d("Mylog", "The letter is " + letter);

        if(letter.length() == 1){
            checkLetter(letter.toUpperCase());
        } else {
            Toast.makeText(this, "Please introduce a letter", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Comprobamos que la letra introducida esta en la palabra
     * @param letter
     */
    public void checkLetter(String letter){

        char letterIntroduced = letter.charAt(0);
        boolean checkletter = false;

        for(int i = 0; i<mWord.length(); i++){
            if(mWord.charAt(i) == letterIntroduced){
                checkletter = true;
                aciertos++;
                showLettersAtIndex(i, letterIntroduced);
            }
        }

        if(!checkletter){
            letterFailed(letter);
        }

        if(aciertos == mWord.length()){
            finish();
        }
    }

    /**
     * Limpia la pantalla cuando hemos ganado
     */
    public void clearScreen(){
        //reiniciamos las letras fallidas
        TextView failsLettersView = (TextView) findViewById(R.id.failsLetter);
        failsLettersView.setText("");

        //reiniciamos contadores
        nFails=0;
        aciertos=0;

        //reiniciamos las letras acertadas
        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutLetters);

        for( int i = 0; i < layoutLetters.getChildCount(); i++){
            TextView currentTextView = (TextView) layoutLetters.getChildAt(i);
            currentTextView.setText("_");
        }

        //reiniciamos la imagen
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.hangdroid_0);
    }

    /**
     * Indica letras que hemos fallado
     * @param letter
     */
    public void letterFailed(String letter){
        nFails++;
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView failsLettersView = (TextView) findViewById(R.id.failsLetter);
        String failsLetters = failsLettersView.getText().toString();

        failsLettersView.setText(failsLetters + letter);

        switch (nFails){
            case 1:
                imageView.setImageResource(R.drawable.hangdroid_1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.hangdroid_2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.hangdroid_3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.hangdroid_4);
                break;
            case 5:
                imageView.setImageResource(R.drawable.hangdroid_5);
                break;
            case 6:
                Intent gameOver = new Intent(this, GameOverActivity.class);
                gameOver.putExtra("POINTS", points);
                startActivity(gameOver);
        }
    }

    /**
     * Escribe las letras en pantalla
     * @param position, posicion de la letra que hay que escribir
     * @param letter, letra a escribir
     */
    public void showLettersAtIndex(int position, char letter){

        Log.d("Prueba", "Entra");

        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);

        TextView textView = (TextView) layoutLetter.getChildAt(position);

        textView.setText(Character.toString(letter));
    }

    public void createTextView(String word){

        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutLetters);

        for(int i = 0; i<word.length(); i++){
            TextView myTextView = (TextView) getLayoutInflater().inflate(R.layout.textview,null);
            layoutLetters.addView(myTextView);
        }
    }
}
