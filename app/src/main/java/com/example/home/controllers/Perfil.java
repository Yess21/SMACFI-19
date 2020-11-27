package com.example.home.controllers;

import androidx.appcompat.app.AppCompatActivity;
import com.example.home.R;
import com.example.home.api.Sesion;

import android.os.Bundle;
import android.widget.TextView;

public class Perfil extends AppCompatActivity {

    public TextView lblUsuario, lblNombre, lblGenero, lblCorreo, lblRol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        lblUsuario = (TextView) findViewById(R.id.lblUsuario);
        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblCorreo = (TextView) findViewById(R.id.lblCorreo);
        lblRol = (TextView) findViewById(R.id.lblRol);

        lblUsuario.setText(Sesion.get(Perfil.this).getSharedPreferences().getString(Sesion.PREF_USER_USERNAME, "null"));
        lblNombre.setText(Sesion.get(Perfil.this).getSharedPreferences().getString(Sesion.PREF_USER_NAME, "null") +
                " "+ Sesion.get(Perfil.this).getSharedPreferences().getString(Sesion.PREF_USER_SURNAME_F, "null"));
        lblCorreo.setText(Sesion.get(Perfil.this).getSharedPreferences().getString(Sesion.PREF_USER_EMAIL, "null"));
        lblRol.setText(Sesion.get(Perfil.this).getSharedPreferences().getString(Sesion.PREF_USER_ROLE, "null"));

    }
}