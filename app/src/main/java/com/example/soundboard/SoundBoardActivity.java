package com.example.soundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SoundBoardActivity extends AppCompatActivity implements View.OnClickListener {

    public Button buttonA;
    public Button buttonB;
    public Button buttonC;
    public Button buttonD;
    public Button buttonE;
    public Button buttonF;
    public Button buttonG;
    public Button buttonASharp;
    public Button buttonCSharp;
    public Button buttonDSharp;
    public Button buttonFSharp;
    public Button buttonGSharp;
    private Button buttonNext;
    private Button buttonBack;
    private Button scale;
    private TextView pitch;
    private SoundPool soundPool;
    private double rateChange = 1;
    private int octave;
    private int[] sounds;
    private int[] soundsscale;
    private Button furElise;
    private Button megalovania;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soundboard);
        wireWidgets();
        setListeners();
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundArray();
        pitch.setText("1");
        octave = 1;
        scaleArray();
    }
    public void setListeners(){
        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        buttonE.setOnClickListener(this);
        buttonF.setOnClickListener(this);
        buttonG.setOnClickListener(this);
        buttonASharp.setOnClickListener(this);
        buttonCSharp.setOnClickListener(this);
        buttonDSharp.setOnClickListener(this);
        buttonFSharp.setOnClickListener(this);
        buttonGSharp.setOnClickListener(this);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rateChange = (rateChange + .8);
                octave++;
                pitch.setText(octave + "");
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rateChange = (rateChange - .8);
                octave--;
                pitch.setText(octave + "");
            }
        });
        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playScale();
            }
        });
        furElise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playFurElise();
            }
        });
        megalovania.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playMegalovania();
            }
        });
    }

    private void playScale(){
        for(int i = 0; i < 12; i++){
            soundPool.play(soundsscale[i], 1, 1, 1, 0, (float) rateChange);
            delay(300);
                }

        }
    private void delay(int millis){
        try{
            Thread.sleep(millis);
        }
        catch (InterruptedException e1){
            e1.printStackTrace();
        }
    }

    private void soundArray(){
        sounds = new int[12];
        sounds[0] = soundPool.load(getApplicationContext(), R.raw.scalea, 1);
        sounds[1] = soundPool.load(getApplicationContext(), R.raw.scaleb, 1);
        sounds[2] = soundPool.load(getApplicationContext(), R.raw.scalec, 1);
        sounds[3] = soundPool.load(getApplicationContext(), R.raw.scaled, 1);
        sounds[4] = soundPool.load(getApplicationContext(), R.raw.scalee, 1);
        sounds[5] = soundPool.load(getApplicationContext(), R.raw.scalef, 1);
        sounds[6] = soundPool.load(getApplicationContext(), R.raw.scaleg, 1);
        sounds[7] = soundPool.load(getApplicationContext(), R.raw.scalebb, 1);
        sounds[8] = soundPool.load(getApplicationContext(), R.raw.scalecs, 1);
        sounds[9] = soundPool.load(getApplicationContext(), R.raw.scaleds, 1);
        sounds[10] = soundPool.load(getApplicationContext(), R.raw.scalefs, 1);
        sounds[11] = soundPool.load(getApplicationContext(), R.raw.scalegs, 1);
    }
    private void scaleArray(){
        soundsscale = new int[12];
        soundsscale[0] = soundPool.load(getApplicationContext(), R.raw.scalea, 1);          //  A       0
        soundsscale[1] = soundPool.load(getApplicationContext(), R.raw.scalebb, 1);         //  A#      1
        soundsscale[2] = soundPool.load(getApplicationContext(), R.raw.scaleb, 1);          //  B       2
        soundsscale[3] = soundPool.load(getApplicationContext(), R.raw.scalec, 1);          //  C       3
        soundsscale[4] = soundPool.load(getApplicationContext(), R.raw.scalecs, 1);         //  C#      4
        soundsscale[5] = soundPool.load(getApplicationContext(), R.raw.scaled, 1);          //  D       5
        soundsscale[6] = soundPool.load(getApplicationContext(), R.raw.scaleds, 1);         //  D#      6
        soundsscale[7] = soundPool.load(getApplicationContext(), R.raw.scalee, 1);          //  E       7
        soundsscale[8] = soundPool.load(getApplicationContext(), R.raw.scalef, 1);          //  F       8
        soundsscale[9] = soundPool.load(getApplicationContext(), R.raw.scalefs, 1);         //  F#      9
        soundsscale[10] = soundPool.load(getApplicationContext(), R.raw.scaleg, 1);         //  G       10
        soundsscale[11] = soundPool.load(getApplicationContext(), R.raw.scalegs, 1);        //  G#      11
    }

    private void playFurElise(){
        int[] furElise = {7, 6, 7, 6, 7, 2, 5, 3, 0, 3, 7, 0, 3, 7, 0, 2, 3, 7, 6, 7, 6, 7, 2, 5, 3, 0, 3, 7, 0, 3, 7, 3, 2, 0, 2, 3, 5, 7, 10, 8, 7, 5, 7
        , 7, 5, 3, 7, 5, 3, 7, 7, 6, 7, 6, 7, 7, 5, 3, 0, 3, 7, 0, 2, 7, 0, 2, 3, 7, 6, 7, 6, 7, 2, 5, 3, 0, 3, 7, 0, 2, 7, 3, 2, 0};
        int length = furElise.length;
        for(int i = 0; i < length; i++){
            soundPool.play(soundsscale[furElise[i]], 1, 1, 1, 0, (float)rateChange);
            delay(200);
        }
    }
    private void playMegalovania(){
        int[] megalovania = {5, 0, 11, 10, 8, 5, 8, 10, 3, 3};
        int length = megalovania.length;
        for(int c = 0; c < 5; c++){
            for(int i = 0; i < length; i ++){
                soundPool.play(soundsscale[megalovania[i]], 1, 1, 1, 0, (float)rateChange);
                delay(200);
            }
            rateChange = rateChange + .8;
        }

    }

    public void wireWidgets(){
        buttonA = findViewById(R.id.button_soundboard_a);
        buttonB = findViewById(R.id.button_soundboard_b);
        buttonC = findViewById(R.id.button_soundboard_c);
        buttonD = findViewById(R.id.button_soundboard_d);
        buttonE = findViewById(R.id.button_soundboard_e);
        buttonF = findViewById(R.id.button_soundboard_f);
        buttonG = findViewById(R.id.button_soundboard_g);
        buttonASharp = findViewById(R.id.button_soundboard_as);
        buttonCSharp = findViewById(R.id.button_soundboard_cs);
        buttonDSharp = findViewById(R.id.button_soundboard_ds);
        buttonFSharp = findViewById(R.id.button_soundboard_fs);
        buttonGSharp = findViewById(R.id.button_soundboard_gs);
        buttonNext = findViewById(R.id.button_soundboard_next);
        buttonBack = findViewById(R.id.button_soundboard_back);
        pitch = findViewById(R.id.textView_main_pitch);
        scale = findViewById(R.id.button_soundboard_scale);
        furElise = findViewById(R.id.button_soundboard_furElise);
        megalovania = findViewById(R.id.button_soundboard_megalovania);
    }

    @Override
    public void onClick(View view) {
        int index = -1;
        switch(view.getId()){
            case R.id.button_soundboard_a:
                index = 0;
                break;
            case R.id.button_soundboard_b:
                index = 1;
                break;
            case R.id.button_soundboard_c:
                index = 2;
                break;
            case R.id.button_soundboard_d:
                index = 3;
                break;
            case R.id.button_soundboard_e:
                index = 4;
                break;
            case R.id.button_soundboard_f:
                index = 5;
                break;
            case R.id.button_soundboard_g:
                index = 6;
                break;
            case R.id.button_soundboard_as:
                index = 7;
                break;
            case R.id.button_soundboard_cs:
                index = 8;
                break;
            case R.id.button_soundboard_ds:
                index = 9;
                break;
            case R.id.button_soundboard_fs:
                index = 10;
                break;
            case R.id.button_soundboard_gs:
                index = 11;
                break;
        }
        soundPool.play(sounds[index], 1, 1 ,1, 0, (float)rateChange);

    }
}