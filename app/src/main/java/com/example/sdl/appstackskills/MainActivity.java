package com.example.sdl.appstackskills;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText EdTeName, EdTePassword, EdTeInput;
    TextView TeViSomeText, TeViResult;
    ImageView ImViKats, yui, cc, cc2, rick, fox;
    boolean rickOut = true;

/////////////////////   ANIMATIONS 1 FADE and translation *****

    public void fade(View n){
        yui = (ImageView)findViewById(R.id.imGirl1);
        cc = (ImageView)findViewById(R.id.imGirl2);

        if(cc.getAlpha() == 0f){
            //yui.animate().alpha(0f).setDuration(2000);
            cc.animate().alpha(1f).setDuration(3000);
            yui.animate().translationX(-1000f).setDuration(2000);
        }else{
            cc.animate().alpha(0f).setDuration(2000);
            //yui.animate().alpha(1f).setDuration(3000);
            yui.animate().translationX(0f).setDuration(3000);
        }


    }
/////////////////////   CONVERTER *****

    public void convert(View v2){
        EdTeInput = (EditText) findViewById(R.id.editTextInput);
        double inputValue = 0.0;
        inputValue = Double.parseDouble(EdTeInput.getText().toString());
        double result = 0.0;
        result = (inputValue * 7.2920);

        TeViResult = (TextView)findViewById(R.id.textViewResult);

        TeViResult.setText("Q. " + result);

        Toast.makeText(getApplicationContext(), "Q. " + result, Toast.LENGTH_LONG).show();

    }// end of  convert


/////////////////////   CHECK LOG INFO *****

    public void checkLogin(View v1){
        EdTeName = (EditText) findViewById(R.id.editTextUserName);
        EdTePassword = (EditText) findViewById(R.id.editTextPassword);

        Log.i("Welcome user: ", EdTeName.getText().toString());
        Log.i("This is your Password: ", EdTePassword.getText().toString());

        TeViSomeText = (TextView) findViewById(R.id.textViewSomeMessage);
        TeViSomeText.setText("Welcome user: " + EdTeName.getText().toString() + "\n" +
                "This is your password: " + "\n" + EdTePassword.getText().toString());

        Toast.makeText(getApplicationContext(), "Welcome " + EdTeName.getText().toString(), Toast.LENGTH_SHORT).show();
    }//end of checkLogin


/////////////////////   SWITCH CAT *****
    boolean switchK = true;

    public void changeKat(View v2){
        ImViKats = (ImageView) findViewById(R.id.imageViewKat);
        if(switchK){
            ImViKats.setImageResource(R.drawable.kat2);
            switchK =false;
        } else {
            ImViKats.setImageResource(R.drawable.kat1);
            switchK =true;
        }

    }//end of changeKat


    /////////////////////   ANIMATIONS 2 *****

    public void callRick(View n){

        if(rickOut){
            rick.animate().translationX(-210f).rotation(1440f).setDuration(1000);
            rickOut = false;
        } else {
            rick.animate().translationX(-1100f).setDuration(1000);
            rickOut = true;
        }
    }// callRick end

    public void rollingRick(View n){
        if(rick.getRotation() == 1440) {
            rick.animate().rotation(-1440f).setDuration(2000);

        }
    }// rollingRick end

    public void growth(View n){
        fox = (ImageView) findViewById(R.id.imFox);
        fox.animate().scaleX(0.25f).scaleY(0.25f);
    }


/////// ON CREATE /////// ON CREATE /////// ON CREATE /////// ON CREATE /////// ON CREATE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //imRick ya tiene una ubicacion en el layout pero aca indicamos su nueva posicion que tomara de
// inmediato al formar el onCreate ''Esto no es una animacion como las otras''
        rick = (ImageView) findViewById(R.id.imRick);
        rick.setTranslationX(-1100f);
        rickOut = true;
        //fox = (ImageView) findViewById(R.id.imFox);
        //fox.setScaleX(0.25f);
        //fox.setScaleY(0.25f);



///*-*-*-*-*-*-* TIMER TESTS *-*-*-*-*-*-* TIMER TESTS *-*-*-*-*-*-* TIMER TESTS
/*   TIMER WITH HANDLER (better for prolonged use )
        final Handler myHandler = new Handler();
        Runnable myRun = new Runnable() {
            @Override
            public void run() {
// here the code to run every defined interval, here 2 seconds
                myHandler.postDelayed(this, 2000);
                Log.i("Runable 'myRun' has RUN", " 2 seconds must have passed,,");
            }
        };
        myHandler.post(myRun);
*/////////

/// //TIMER WITH CountDownTimer
// this CountDownTimer object is destroyed when finis, works fine for temporary uses (for continue use better use the Handler)

        final int totalTime = 5000;
        final int timeInterval =1000;

        new CountDownTimer(totalTime, timeInterval){

            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("actual second ", String.valueOf(((totalTime-millisUntilFinished)/timeInterval)+1));
                Log.i("seconds until finish ", String.valueOf(millisUntilFinished/timeInterval));
            }

            @Override
            public void onFinish() {
                Log.i("we reach the totalTime ", String.valueOf(totalTime/timeInterval));
            }
        }.start();//CountDownTimer end




    }// end of onCreate

}//end of the MainActivity
















