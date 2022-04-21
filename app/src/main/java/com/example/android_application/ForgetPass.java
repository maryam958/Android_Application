package com.example.android_application;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPass extends AppCompatActivity implements View.OnClickListener {

    Button back;
    Button Done;
    EditText newPass;
    EditText Confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_forget_pass );

        back = (Button) findViewById( R.id.back );
        Done = (Button) findViewById( R.id.Done );
        newPass = (EditText) findViewById( R.id.newPass );
        Confirm = (EditText) findViewById( R.id.Confirm );
        back.setOnClickListener( this );
        Done.setOnClickListener( this );

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.back):
                Intent intent = new Intent( this, MainActivity.class );
                startActivity( intent );
                break;

            case (R.id.Done):

                if (newPass.getText().toString().trim().length()==0){
                    Toast.makeText( getApplicationContext(),
                            "Please enter password", Toast.LENGTH_SHORT ).show();}
                else if (Confirm.getText().toString().length()==0){
                    Toast.makeText( getApplicationContext(),
                            "Please Confirm Password", Toast.LENGTH_SHORT ).show();}

                else if (newPass.getText().toString().equalsIgnoreCase(Confirm.getText().toString())) {
                    Intent i = new Intent( this, MainActivity2.class );
                    startActivity( i );}
                else{
                    Toast.makeText( getApplicationContext(),
                            "Passwords does not match", Toast.LENGTH_SHORT ).show();
                }

                break;

        }

    }}













