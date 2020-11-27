package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Diagnosticos extends AppCompatActivity {

    Button btnagregar,btnactualizar,btneliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostcos);

        btnagregar = (Button) findViewById(R.id.btnagregar);
        btnagregar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent Create = new Intent(Diagnosticos.this,Freporte.class);
                startActivity(Create);
            }
        });

        btnactualizar = (Button) findViewById(R.id.btnactualizar);
        btnactualizar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent Update = new Intent(Diagnosticos.this,Freporte.class);
                startActivity(Update);
            }
        });

        btneliminar = (Button) findViewById(R.id.btneliminar);
    }
}