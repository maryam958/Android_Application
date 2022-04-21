package com.example.android_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText email;
    EditText password;
    Button loginBtn;
    Button regBtn;
    TextView forgetPass;

    private MyReceiver mReceiver = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        email = (EditText) findViewById( R.id.username );
        password = (EditText) findViewById( R.id.pass );
        loginBtn = (Button) findViewById( R.id.login );
        forgetPass = (TextView) findViewById( R.id.forgetpass );
        regBtn = (Button) findViewById( R.id.reg );
        loginBtn.setOnClickListener( this );
        forgetPass.setOnClickListener( this );
        regBtn.setOnClickListener( this );
        //Broadcast
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        this.registerReceiver(mReceiver, filter);


    }

    @Override
    protected void onDestroy() {
        //Unregister the receiver when no longer needed/dynamic receiver
        this.unregisterReceiver(mReceiver);
        super.onDestroy();
    }


    public void GoogleBrowser(View v) {
        Intent G_Intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "http://www.google.com" ) );
        startActivity( G_Intent );
    }


    public void FacebookBrowser(View v) {
        Intent F_Intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "http://www.facebook.com" ) );
        startActivity( F_Intent );
    }


    public void TwitterBrowser(View v) {
        Intent T_Intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "http://www.twitter.com" ) );
        startActivity( T_Intent );


    }


    @Override
    public void onClick(View view) {
        //EditText is a view object while setText method takes String or CharSequence.
        // You cannot set text to view object, it doesn't make sense.
        String text = email.getText().toString();
        email.setText( text );
        switch (view.getId()) {
            case R.id.login:

                if (email.getText().length() == 0) {
                    Toast.makeText( getApplicationContext(),
                            "Please Enter your Email", Toast.LENGTH_SHORT ).show();
                } else if (!EMAIL_ADDRESS_PATTERN.matcher( text ).matches()) {
                    Toast.makeText( getApplicationContext(),
                            "Invalid Email", Toast.LENGTH_SHORT ).show();
                } else if (password.getText().length() == 0) {
                    Toast.makeText( getApplicationContext(),
                            "Please Enter your Password", Toast.LENGTH_SHORT ).show();
                } else {
                    Toast.makeText( getApplicationContext(),
                            "Login Successfully", Toast.LENGTH_SHORT ).show();
                    Intent intent = new Intent( this, MainActivity2.class );
                    startActivity( intent );

                }



                break;

            case R.id.forgetpass:
                Intent i = new Intent( this, ForgetPass.class );
                startActivity( i );
                break;
            case R.id.reg:
                Intent R = new Intent( this, Registeration.class );
                startActivity( R );
                break;

        }

    }


    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(

            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );


    //Shared Preference
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp=getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit=sp.edit();
        myEdit.putString("Email",email.getText().toString());
        myEdit.putString("Password",password.getText().toString());
        myEdit.apply();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp=getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String s1=sp.getString( "Email"," " );
        String s2=sp.getString("Password"," " );
        email.setText(s1);
        password.setText(s2);
    }





    //Custom BroadCast Receiver
/*public void broadcastIntent (View view){
        Intent intent=new Intent();
        intent.setAction( "com.MyReciver.CUSTOM_INTENT" );
        sendBroadcast(intent);

}*/


  /*  protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneModeChangeReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(airplaneModeChangeReceiver);
    }*/
}






