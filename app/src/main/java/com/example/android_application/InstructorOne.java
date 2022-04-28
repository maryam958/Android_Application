package com.example.android_application;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_application.MyService;

public class InstructorOne extends AppCompatActivity implements View.OnClickListener{
    Button play;
    Button stop;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_one);
        play=findViewById(R.id.play);
        stop=findViewById(R.id.stop);
        play.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play:
                startService(new Intent(this, MyService.class));
                break;

            case R.id.stop:
                stopService(new Intent(this,MyService.class));
                break;
        }
    }
}
