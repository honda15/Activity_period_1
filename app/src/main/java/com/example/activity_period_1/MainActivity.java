package com.example.activity_period_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Timer timer;
    private Task1 task1;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = findViewById(R.id.mesg);
    }

    @Override
    protected void onStart() {
        super.onStart();
        timer = new Timer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(timer != null){
            timer.cancel();
            timer.purge();
            timer = null;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("main","restart");
//        if(timer != null){
//            timer.cancel();
//            timer.purge();
//            timer = null;
    }


    public void test1(View view){
        Log.v("main","start");
        timer.schedule(new Task1(),1*1000);
    }

    public void test2(View view) {
        task1 = new Task1();
        timer.schedule(task1,2*1000,1*1000);
    }

    public void test3(View view) {
        if(task1 != null){
            task1.cancel();
            task1 = null;
        }
    }

    public void test4(View view) {
        Intent intent = new Intent(this, second.class);
        startActivity(intent);
    }

    private class Task1 extends TimerTask{
        private int counter;

        @Override
        public void run() {
            counter++;
            message.setText(""+counter);
        }
    }
}