package com.example.home.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.home.R;

public class Diagnosticos extends AppCompatActivity {

    Button btnagregar,btnactualizar,btneliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostcos);

        btnagregar = (Button) findViewById(R.id.btnagregar);
        btnactualizar = (Button) findViewById(R.id.btnactualizar);
        btneliminar = (Button) findViewById(R.id.btneliminar);
    }
}