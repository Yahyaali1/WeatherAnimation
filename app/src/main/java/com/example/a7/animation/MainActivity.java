package com.example.a7.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a7.animation.test.customViewRain;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //customViewRain customViewRain = findViewById(R.id.layout);
        //customViewRain.init(1000,0,5);
        //startActivity(new Intent(this,ParticalSunnyActivity.class));
    }
}
