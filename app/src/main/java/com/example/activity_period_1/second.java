package com.example.activity_period_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class second extends AppCompatActivity {

    private TextView txtshow1;
    private Button btnFinish1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtshow1 = findViewById(R.id.txt_second);
        btnFinish1= findViewById(R.id.button2);
        btnFinish1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(second.this, MainActivity.class);
                startActivity(intent);
                //       txtshow.setText("按到了!!");
                finish();
            }
        });
    }
}