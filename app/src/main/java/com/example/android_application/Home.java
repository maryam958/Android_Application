package com.example.android_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;




public class Home extends AppCompatActivity {
    private static  final String TAG="MainActivity";
    private static  final int DOWNLOAD_JOB_KEY=101;

    RecyclerView recyclerView;
    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutManager;
    String[] programNameList ={"java","php","Dart","Html","JavaScript","Android","Flutter","React","Npdejs"};
    String[] programDescriptionList = {"java programming for Beginners","build a php MVC ","Dart Guid for beginners",
            "Build Responsive Real-World Websites",
            "Android java Masterclass-Become an App Developer","build application using Flutter",
            "Modern react with Redux","Complete Node.js Developer Course"};
    int[] programImages={R.drawable.java,R.drawable.php,R.drawable.dart2,R.drawable.html,
            R.drawable.jascript,R.drawable.android,R.drawable.flutter,R.drawable.react,R.drawable.node};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


      /*  //ActionBar
        getSupportActionBar().setTitle( "COURSES" );
        // calling the action bar
        ActionBar actionBar = getSupportActionBar();
        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled( true );*/

        //RecyclerView
        recyclerView=findViewById(R.id.rvprogram);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        programAdapter = new programAdapter(this,programNameList,programDescriptionList,programImages);
        recyclerView.setAdapter(programAdapter);

        initJobScheduler();

    }


    private void initJobScheduler(){
        Log.d(TAG, "initJobScheduler: started ");
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            ComponentName componentName= new ComponentName(this, SampleJobService.class);
            PersistableBundle bundle = new PersistableBundle();
            bundle.putInt("number",10);
            JobInfo.Builder builder =new JobInfo.Builder(DOWNLOAD_JOB_KEY,componentName)
                    .setExtras(bundle)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                    .setPersisted(true);
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
                builder.setPeriodic(15*60*1000,30*60*1000);

            }
            else {
                builder.setPeriodic(15*60*1000);
            }

            JobScheduler scheduler =(JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
            scheduler.schedule(builder.build());


        }

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this,MainActivity.class));
                //this.finish();
                return true;
        }
        return super.onOptionsItemSelected( item );

    }



}