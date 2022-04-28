package com.example.android_application;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.text.PrecomputedText;
import android.util.Log;

public class SampleJobService extends JobService {
    private static final String TAG = "SampleJobservice";

    private MimicAsyncTask mimicAsyncTask;
    private JobParameters parameters;


    @Override
    public boolean onStartJob(JobParameters params) {
        this.parameters=params;
        PersistableBundle bundle = params.getExtras();
        int number=bundle.getInt("number");
        mimicAsyncTask= new MimicAsyncTask();
        mimicAsyncTask.execute(number);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.d(TAG, "onStopJob: job canceled");
        if(null != mimicAsyncTask){
            if(!mimicAsyncTask.isCancelled()){
                mimicAsyncTask.cancel(true);
            }
        }
        return false;
    }

    private class MimicAsyncTask extends AsyncTask< Integer, Integer,String> {
        protected String doInBackground(Integer... integers) {
            for (int i = 0; i < integers[0]; i++) {
                SystemClock.sleep(1000);
                publishProgress(i);
            }
            return "Job Finished!";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.d(TAG, "onProgressUpdate: i was : "+ values[0] );

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d(TAG, "onPostExecute: message"+s);
            jobFinished(parameters,true);

        }
    }

}
