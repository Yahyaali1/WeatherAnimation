package com.example.a7.animation;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class CustomView extends RelativeLayout {
    ImageView [] clouds = new ImageView[9];
    ImageView sumOrMoon;
    private int weathericon = 3;
    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.activity_partical_sunny, this);
        findViews();
        switch (weathericon){
            case 1: //Sunny
                for(int i=0;i<9;i++){
                    clouds[i].setVisibility(GONE);
                }
                break;
            case 2: // Partly Cloudy
                for(int i=6;i<9;i++){
                    clouds[i].setVisibility(GONE);
                }
                break;
            case 3: // Mostly Cloudy and sun
                break;
            case 4: // Mostly Cloud
                sumOrMoon.setVisibility(GONE);
                break;
            case 5: //Dark cloud

                break;
        }
        animateView();
    }

    private void animateView() {
        TranslateAnimation mAnimation1 = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.01f);
        mAnimation1.setDuration(800);
        mAnimation1.setRepeatCount(-1);
        mAnimation1.setRepeatMode(Animation.REVERSE);
        mAnimation1.setInterpolator(new LinearInterpolator());

        TranslateAnimation mAnimation2 = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.01f);
        mAnimation2.setDuration(1000);
        mAnimation2.setRepeatCount(-1);
        mAnimation2.setRepeatMode(Animation.REVERSE);
        mAnimation2.setInterpolator(new LinearInterpolator());



        TranslateAnimation mAnimation3 = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.01f);
        mAnimation2.setDuration(1300);
        mAnimation2.setRepeatCount(-1);
        mAnimation2.setRepeatMode(Animation.REVERSE);
        mAnimation2.setInterpolator(new LinearInterpolator());


        for(int i=0;i<3;i++){
            clouds[i].setAnimation(mAnimation1);
        }
        for(int i=3;i<6;i++){
            clouds[i].setAnimation(mAnimation2);
        }
        for(int i=6;i<9;i++){
            clouds[i].setAnimation(mAnimation3);
        }
        Animation rotateAnimation = new RotateAnimation(0.0f, 360.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        rotateAnimation.setDuration(1500);

        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setRepeatMode(Animation.REVERSE);

        //#061324
//        Animation fadeIn = new AlphaAnimation(0, 1);
//        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
//        fadeIn.setDuration(1000);
//        fadeIn.setRepeatCount(-1);
//
//        Animation fadeOut = new AlphaAnimation(1, 0);
//        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
//        fadeOut.setStartOffset(1000);
//        fadeOut.setDuration(1000);
//        fadeOut.setRepeatCount(-1);
//
//        AnimationSet animation = new AnimationSet(false); //change to false
//        animation.addAnimation(fadeIn);
//        animation.addAnimation(fadeOut);
//        animation.addAnimation(rotateAnimation);
        sumOrMoon.setAnimation(rotateAnimation);
    }

    private void findViews() {
        this.clouds[0] = (ImageView) findViewById(R.id.iv_cloud1);
        this.clouds[1] = (ImageView) findViewById(R.id.iv_cloud2);
        this.clouds[2] = (ImageView) findViewById(R.id.iv_cloud3);
        this.clouds[3]= (ImageView) findViewById(R.id.iv_cloud4);
        this.clouds[4] = (ImageView) findViewById(R.id.iv_cloud5);
        this.clouds[5] = (ImageView) findViewById(R.id.iv_cloud6);
        this.clouds[6]= (ImageView) findViewById(R.id.iv_cloud7);
        this.clouds[7] = (ImageView) findViewById(R.id.iv_cloud8);
        this.clouds[8] = (ImageView) findViewById(R.id.iv_cloud9);
        this.sumOrMoon = findViewById(R.id.iv_sun);
    }
}
