package com.example.android_application;


import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    MediaPlayer myplayer;
    /*public MyService() {
    }
*/
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this,"Service Created",Toast.LENGTH_LONG).show();
        myplayer=MediaPlayer.create(this,R.raw.mp3);
        myplayer.setLooping(false);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Toast.makeText(this,"Service Started",Toast.LENGTH_LONG).show();
        myplayer.start();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Service Stopped",Toast.LENGTH_LONG).show();
        myplayer.stop();
    }
}