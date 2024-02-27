package com.example.facebookfake;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageViewSplash);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                gotoLoginScreen();
                // or
//                gotoHomeScreen();
                finish();
            }
        }, 3000);
        showAnimation();
    }

    void gotoLoginScreen() {
        Intent i = new Intent(MainActivity.this, SignInActivity.class);
        startActivity(i);
    }

    void gotoHomeScreen() {
        Intent i = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(i);
    }

    void showAnimation() {
        Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate_move_down);
        imageView.startAnimation(animation);
    }
}