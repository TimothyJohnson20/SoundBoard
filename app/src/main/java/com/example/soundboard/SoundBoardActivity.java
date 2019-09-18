package com.example.soundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SoundBoardActivity extends AppCompatActivity {

    public Button buttonA;
    public Button buttonB;
    public Button buttonC;

    private SoundPool soundPool;
    private int soundID;
    boolean loaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soundboard);
        wireWidgets();
        setListeners();

        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int i, int i1) {
                loaded = true;
            }
        });
    }
    public void setListeners(){
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loaded){
                    soundPool.play(soundPool.load(getApplicationContext(), R.raw.scalea, 1), 1, 1, 1, 0, 1);

                }
            }
        });
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loaded){
                    soundPool.play(soundID, 1, 1, 1, 0, 1);
                }
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loaded){
                    soundPool.play(soundID, 1, 1, 1, 0, 1);
                }
            }
        });
    }

    public void wireWidgets(){
        buttonA = findViewById(R.id.button_soundboard_a);
        buttonB = findViewById(R.id.button_soundboard_b);
        buttonC = findViewById(R.id.button_soundboard_c);
        buttonA.setText(R.string.buttonA);
        buttonB.setText(R.string.buttonB);
        buttonC.setText(R.string.buttonC);
    }


}
