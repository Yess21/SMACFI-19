package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageView bgapp, hoja;
    LinearLayout linearLayout, linearLayoutHome, linearLayoutMenu;
    Animation animfront;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animfront = AnimationUtils.loadAnimation(this, R.anim.animfront);

        bgapp = (ImageView) findViewById(R.id.bgapp);
        hoja = (ImageView) findViewById(R.id.hoja);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        linearLayoutHome = (LinearLayout) findViewById(R.id.linearLayoutHome);
        linearLayoutMenu = (LinearLayout) findViewById(R.id.linearLayoutMenu);

        bgapp.animate().translationY(-1500).setDuration(1000).setStartDelay(400);
        hoja.animate().alpha(0).setDuration(1000).setStartDelay(400);
        linearLayout.animate().translationY(140).alpha(0).setStartDelay(400);

        linearLayoutHome.startAnimation(animfront);
        linearLayoutMenu.startAnimation(animfront);

    }
}