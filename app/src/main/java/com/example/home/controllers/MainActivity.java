package com.example.home.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.home.R;
import com.example.home.api.Sesion;

public class MainActivity extends AppCompatActivity {

    private ImageView bgapp, hoja, ImgReportes, ImgGel, ImgAlum,ImgCanal,ImgDiag, ImgUsuario;
    private LinearLayout linearLayout, linearLayoutHome, linearLayoutMenu;
    private Animation animfront;
    private Button btnCerrarSesion;

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
        btnCerrarSesion = (Button) findViewById(R.id.btnCerrarSesion);

        btnCerrarSesion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Sesion.get(MainActivity.this).cerrarSesion();
                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });

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
                //Intent IntAlum = new Intent(MainActivity.this,Alumnos.class);
                //startActivity(IntAlum);
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

        ImgDiag = (ImageView) findViewById(R.id.ImgDiagnosticos);
        ImgDiag.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent IntDiag = new Intent(MainActivity.this, Diagnosticos.class);
                startActivity(IntDiag);
            }
        });

        ImgUsuario = (ImageView) findViewById(R.id.ImgUsuario);
        ImgUsuario.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent IntPerfil = new Intent(MainActivity.this, Perfil.class);
                startActivity(IntPerfil);
            }
        });
    }
}