package com.example.android_application;




import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registeration extends AppCompatActivity implements View.OnClickListener{

    EditText fName;
    EditText lName;
    EditText uname;
    EditText mail;
    EditText pass;
    Button Reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_registeration );

        fName=(EditText) findViewById( R.id.FirstName );
        lName=(EditText) findViewById( R.id.LastName );
        uname=(EditText) findViewById( R.id.Username );
        mail=(EditText) findViewById( R.id.Email );
        pass=(EditText) findViewById( R.id.password );
        Reg=(Button) findViewById(R.id.regButton );
        Reg.setOnClickListener( this );

    }


    @Override
    public void onClick(View view) {
        String text = mail.getText().toString();
        mail.setText(text);


        if(fName.getText().length()==0){
            Toast.makeText( getApplicationContext(),
                    "Please Enter your First Name", Toast.LENGTH_SHORT ).show();

        }
        else if(lName.getText().length()==0){
            Toast.makeText( getApplicationContext(),
                    "Please Enter your Last Name", Toast.LENGTH_SHORT ).show();

        }
        else if(uname.getText().length()==0){
            Toast.makeText( getApplicationContext(),
                    "Please Enter Username", Toast.LENGTH_SHORT ).show();

        }
        else if(mail.getText().length()==0){
            Toast.makeText( getApplicationContext(),
                    "Please Enter your Email", Toast.LENGTH_SHORT ).show();}
        else if(!EMAIL_ADDRESS_PATTERN.matcher(text).matches()) {
            Toast.makeText( getApplicationContext(),
                    "Invalid Email", Toast.LENGTH_SHORT ).show();
        }
        else if(pass.getText().length()==0){
            Toast.makeText( getApplicationContext(),
                    "Please Enter Password", Toast.LENGTH_SHORT ).show();

        }

        else{
            Toast.makeText( getApplicationContext(),
                    "Successful Registration", Toast.LENGTH_SHORT ).show();
            Intent intent = new Intent( this, MainActivity2.class );
            startActivity( intent );
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




    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp=getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit=sp.edit();
        myEdit.putString("First Name",fName.getText().toString());
        myEdit.putString("Last Name",lName.getText().toString());
        myEdit.putString("Username",uname.getText().toString());
        myEdit.putString("Email",mail.getText().toString());
        myEdit.putString("Password",pass.getText().toString());
        myEdit.apply();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp=getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String s1=sp.getString( "First Name"," " );
        String s2=sp.getString("Last Name"," " );
        String s3=sp.getString( "Username"," " );
        String s4=sp.getString("Email"," " );
        String s5=sp.getString( "Password"," " );

        fName.setText(s1);
        lName.setText(s2);
        uname.setText(s3);
        mail.setText(s4);
        pass.setText(s5);

    }
}




