package com.example.a7.animation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Random;

public class CustomView extends RelativeLayout {
    ImageView [] clouds = new ImageView[9];
    ImageView sumOrMoon, clearMoon;
    RelativeLayout backgroud;
    private Random r = new Random(123456789L);
    private int viewWidth;
    private int viewHeight;
    int amount=1000, size=0, speed=0;
    private int weathericon = 32;
    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        attrs.getAttributeValue("android","layout_width");
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
            case 3: // Partly Cloudy
                for(int i=6;i<9;i++){
                    clouds[i].setVisibility(GONE);
                }
                break;
            case 4|6: // Mostly Cloudy and sun
                break;
            case 7: // Mostly Cloud
                sumOrMoon.setVisibility(GONE);
                break;
            case 8: //Dark cloud
                backgroud.setBackgroundColor(getResources().getColor(R.color.background_dark));
                sumOrMoon.setVisibility(GONE);
                for(int i=0;i<9;i++){
                    if (clouds[i].getTag().toString().equals("1"))
                        clouds[i].setImageResource(R.drawable.ic_cloud_circle_night_big_light);
                    else
                        clouds[i].setImageResource(R.drawable.ic_cloud_circle_night_big_dark);
                    if (i==0||i==2||i==8){
                        if (clouds[i].getTag().toString().equals("1"))
                            clouds[i].setImageResource(R.drawable.ic_cloud_circle_night_light);
                        else
                            clouds[i].setImageResource(R.drawable.ic_cloud_circle_night_dark);
                    }
                }
                break;
            case 12:
                sumOrMoon.setVisibility(GONE);
                amount = 800;
                makeRain();
                break;
            case 13:
                amount = 500;
                makeRain();
                break;
            case 14:
                for(int i=6;i<9;i++){
                    clouds[i].setVisibility(GONE);
                }
                amount = 500;
                makeRain();
                break;
            case 15:
                backgroud.setBackgroundColor(getResources().getColor(R.color.background_dark));
                sumOrMoon.setVisibility(GONE);
                for(int i=0;i<9;i++){
                    if (clouds[i].getTag().toString().equals("1"))
                        clouds[i].setImageResource(R.drawable.ic_cloud_circle_night_big_light);
                    else
                        clouds[i].setImageResource(R.drawable.ic_cloud_circle_night_big_dark);
                    if (i==0||i==2||i==8){
                        if (clouds[i].getTag().toString().equals("1"))
                            clouds[i].setImageResource(R.drawable.ic_cloud_circle_night_light);
                        else
                            clouds[i].setImageResource(R.drawable.ic_cloud_circle_night_dark);
                    }
                }
                amount = 1200;
                makeRain();
                break;
            case 32:
                amount = 5;
                makeWind();
                break;
                default:
                    backgroud.setBackgroundColor( getResources().getColor(R.color.background_dark));
                    sumOrMoon.setImageResource(R.drawable.ic_moon_circle);
                    for(int i=0;i<9;i++){
                        if (clouds[i].getTag().toString().equals("1"))
                            clouds[i].setImageResource(R.drawable.ic_cloud_circle_night_big_light);
                        else
                            clouds[i].setImageResource(R.drawable.ic_cloud_circle_night_big_dark);
                        if (i==0||i==2||i==8){
                            if (clouds[i].getTag().toString().equals("1"))
                                clouds[i].setImageResource(R.drawable.ic_cloud_circle_night_light);
                            else
                                clouds[i].setImageResource(R.drawable.ic_cloud_circle_night_dark);
                        }
                    }
                    break;
        }
        switch (weathericon) {
            case 33: //Clear Night
                for (int i = 0; i < 9; i++) {
                    clouds[i].setVisibility(GONE);
                }
                sumOrMoon.setVisibility(GONE);
                clearMoon.setVisibility(VISIBLE);
                clearMoonAnimation();
                break;
            case 35|36: // Partly Cloudy
                for (int i = 6; i < 9; i++) {
                    clouds[i].setVisibility(GONE);
                }
                break;
            case 38: // Mostly Cloudy and sun
                break;
            case 40: // Mostly Cloud
                sumOrMoon.setVisibility(GONE);
                break;
        }
        animateView();
    }

    private void animateView() {
        TranslateAnimation mAnimation1 = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.03f);
        mAnimation1.setDuration(800);
        mAnimation1.setRepeatCount(-1);
        mAnimation1.setRepeatMode(Animation.REVERSE);
        mAnimation1.setInterpolator(new LinearInterpolator());

        TranslateAnimation mAnimation2 = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.03f);
        mAnimation2.setDuration(1000);
        mAnimation2.setRepeatCount(-1);
        mAnimation2.setRepeatMode(Animation.REVERSE);
        mAnimation2.setInterpolator(new LinearInterpolator());



        TranslateAnimation mAnimation3 = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.03f);
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
        sumOrMoon.setAnimation(rotateAnimation);
    }

    private void findViews() {
        this.clouds[0] = findViewById(R.id.iv_cloud1);
        this.clouds[1] = findViewById(R.id.iv_cloud2);
        this.clouds[2] = findViewById(R.id.iv_cloud3);
        this.clouds[3] = findViewById(R.id.iv_cloud4);
        this.clouds[4] = findViewById(R.id.iv_cloud5);
        this.clouds[5] = findViewById(R.id.iv_cloud6);
        this.clouds[6] = findViewById(R.id.iv_cloud7);
        this.clouds[7] = findViewById(R.id.iv_cloud8);
        this.clouds[8] = findViewById(R.id.iv_cloud9);
        this.sumOrMoon = findViewById(R.id.iv_sun);
        this.clearMoon = findViewById(R.id.iv_clear_moon);
        this.backgroud = findViewById(R.id.rl_background);
    }
    public void clearMoonAnimation(){
        Animation rotateAnimation = new RotateAnimation(0.0f, 360.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        rotateAnimation.setDuration(25000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setRepeatMode(Animation.RESTART);

        clearMoon.setAnimation(rotateAnimation);
    }
    public void makeWind(){
        int width =  Resources.getSystem().getDisplayMetrics().widthPixels;
        int height =  Resources.getSystem().getDisplayMetrics().heightPixels;
        int unit=1;
        for ( int i =0;i<amount;i++){
            float i2 = r.nextFloat()*(1f + -1f);
            Log.d("Tested", String.valueOf(i2));
            AnimationSet animation = new AnimationSet(false); //change to false
            TranslateAnimation mAnimation2 = new TranslateAnimation(
                    TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                    TranslateAnimation.RELATIVE_TO_PARENT, 1f,
                    TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                    TranslateAnimation.RELATIVE_TO_PARENT, i2);
            mAnimation2.setDuration(2300+unit);
            mAnimation2.setRepeatCount(-1);
            mAnimation2.setRepeatMode(Animation.RESTART);
            mAnimation2.setInterpolator(new LinearInterpolator());
            animation.addAnimation(mAnimation2);
            int i1 = r.nextInt(height - 0 + 1)+0;
            final ImageView imageView = new ImageView(this.getContext());
            imageView.setImageResource(R.drawable.ic_drop);
            imageView.setX(0);
            imageView.setY(i1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(25, 50);
            imageView.setLayoutParams(layoutParams);
            imageView.setAnimation(animation);
            this.addView(imageView);
            unit=unit+50;
        }
    }
    public void makeRain(){
        int width =  Resources.getSystem().getDisplayMetrics().widthPixels;
        int height =  Resources.getSystem().getDisplayMetrics().heightPixels;
        int unit=1;
        for ( int i =0;i<amount;i++){
            Animation fadeOut = new AlphaAnimation(1, 0);
            fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
            fadeOut.setStartOffset(1000);
            fadeOut.setDuration(1000+unit);
            fadeOut.setRepeatMode(2);
            fadeOut.setRepeatCount(-1);
            AnimationSet animation = new AnimationSet(false); //change to false
            animation.addAnimation(fadeOut);
            TranslateAnimation mAnimation2 = new TranslateAnimation(
                    TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                    TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                    TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                    TranslateAnimation.RELATIVE_TO_PARENT, 1f);
            mAnimation2.setDuration(2300+unit);
            mAnimation2.setRepeatCount(-1);
            mAnimation2.setRepeatMode(Animation.RESTART);
            mAnimation2.setInterpolator(new LinearInterpolator());
            animation.addAnimation(mAnimation2);
            int i1 = r.nextInt(width - 0 + 1)+0;
            int i2 = r.nextInt(height - 0 + 1);
            ImageView imageView = new ImageView(this.getContext());
            imageView.setImageResource(R.drawable.ic_drop);
            imageView.setX(i1);
            imageView.setY(i2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(25, 50);
            imageView.setLayoutParams(layoutParams);
            imageView.setAnimation(animation);
            this.addView(imageView);
            unit=unit+50;
        }
    }
    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld){
        super.onSizeChanged(xNew, yNew, xOld, yOld);
        viewWidth = xNew;
        viewHeight = yNew;
        //init();
    }
}
