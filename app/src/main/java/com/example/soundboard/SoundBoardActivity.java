package com.example.soundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.soundboard.R;

import java.lang.reflect.Array;

public class SoundBoardActivity extends AppCompatActivity {

    public Button buttonA;
    public Button buttonB;
    public Button buttonC;
    public Button buttonD;
    public Button buttonE;
    public Button buttonF;
    public Button buttonG;

    private SoundPool soundPool;

    private int[] sounds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soundboard);
        wireWidgets();
        setListeners();
        soundArray();
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

    }
    public void setListeners(){
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sounds[0], 1, 1, 1, 0,   1);
            }
        });
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sounds[1], 1, 1, 1, 0,   1);
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sounds[2], 1, 1, 1, 0,   1);
            }
        });
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sounds[3], 1, 1, 1, 0,   1);
            }
        });
        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sounds[4], 1, 1, 1, 0,   1);
            }
        });
        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sounds[5], 1, 1, 1, 0,   1);
            }
        });
        buttonG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sounds[6], 1, 1, 1, 0,   1);
            }
        });
    }

    private void soundArray(){
        sounds = new int[7];
        sounds[0] = soundPool.load(getApplicationContext(), R.raw.scalea, 1);
        sounds[1] = soundPool.load(getApplicationContext(), R.raw.scaleb, 1);
        sounds[2] = soundPool.load(getApplicationContext(), R.raw.scalec, 1);
        sounds[3] = soundPool.load(getApplicationContext(), R.raw.scaled, 1);
        sounds[4] = soundPool.load(getApplicationContext(), R.raw.scalee, 1);
        sounds[5] = soundPool.load(getApplicationContext(), R.raw.scalef, 1);
        sounds[6] = soundPool.load(getApplicationContext(), R.raw.scaleg, 1);
    }


    public void wireWidgets(){
        buttonA = findViewById(R.id.button_soundboard_a);
        buttonB = findViewById(R.id.button_soundboard_b);
        buttonC = findViewById(R.id.button_soundboard_c);
        buttonD = findViewById(R.id.button_soundboard_d);
        buttonE = findViewById(R.id.button_soundboard_e);
        buttonF = findViewById(R.id.button_soundboard_f);
        buttonG = findViewById(R.id.button_soundboard_g);
    }


}
