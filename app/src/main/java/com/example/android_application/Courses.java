package com.example.android_application;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Courses extends AppCompatActivity implements View.OnClickListener{
    ImageView img1;
    ImageView img2;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        fab=findViewById(R.id.fab);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        fab.setOnClickListener(this);


    /*    getSupportActionBar().setTitle( "Enrollment" );
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled( true );*/

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.img1:
                Intent intent = new Intent(this,InstructorOne.class);
                this.startActivity(intent);
                break;

            case R.id.img2:
                Intent i= new Intent(this, InstructorTwo.class);
                this.startActivity(i);
                break;

            case R.id.fab:
                startActivity(new Intent(this, Profile.class));
        }

    }

   /* @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, Home.class));
                *//* this.finish();*//*
                return true;
        }
        return super.onOptionsItemSelected( item );
*/
    }