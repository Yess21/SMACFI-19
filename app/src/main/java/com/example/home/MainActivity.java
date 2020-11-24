package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageView bgapp, hoja, ImgReportes, ImgGel, ImgAlum,ImgCanal,ImgDiag;
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

        ImgGel = (ImageView) findViewById(R.id.ImgGel);
        ImgGel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent IntGel = new Intent(MainActivity.this,GelAntibacterial.class);
                startActivity(IntGel);
            }
        });

        ImgAlum = (ImageView) findViewById(R.id.ImgAlum);
        ImgAlum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent IntAlum = new Intent(MainActivity.this,Alumnos.class);
                startActivity(IntAlum);
            }
        });

        ImgReportes = (ImageView) findViewById(R.id.ImgReportes);
        ImgReportes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent IntRepor = new Intent(MainActivity.this,Freporte.class);
                startActivity(IntRepor);
            }
        });

        ImgCanal = (ImageView) findViewById(R.id.ImgCanal);
        ImgCanal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent IntCanal = new Intent(MainActivity.this,Canalizacion.class);
                startActivity(IntCanal);
            }
        });

        ImgDiag = (ImageView) findViewById(R.id.ImgDiag);
        ImgDiag.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent IntDiag = new Intent(MainActivity.this,historial.class);
                startActivity(IntDiag);
            }
        });


    }
}