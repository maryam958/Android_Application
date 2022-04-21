package com.example.android_application;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            //Get the intent action
            String intentAction = intent.getAction();
            if (intentAction != null) {
                String toastMessage = "unknown intent action";
                switch (intentAction){
                    case Intent.ACTION_POWER_CONNECTED:
                        toastMessage = "Power connected!";
                        break;
                    case Intent.ACTION_POWER_DISCONNECTED:
                        toastMessage = "Power disconnected!";
                        break;
                }
                // to display a toast message for a short time:
                Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
            }
        }
    }
