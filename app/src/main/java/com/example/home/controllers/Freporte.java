package com.example.home.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.R;

import retrofit2.Call;

public class Freporte extends AppCompatActivity {

    private Button btnGuardar;
    private EditText txtMatricula, txtTemperatura, txtPeso, txtAltura,
            txtSintomas, txtObservaciones, txtDiagnostico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freporte);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        txtMatricula = (EditText) findViewById(R.id.txtMatricula);
        txtTemperatura = (EditText) findViewById(R.id.txtTemperatura);
        txtSintomas = (EditText) findViewById(R.id.txtSintomas);
        txtAltura = (EditText) findViewById(R.id.txtAltura);
        txtPeso = (EditText) findViewById(R.id.txtPeso);
        txtDiagnostico = (EditText) findViewById(R.id.txtDiagnostico);
        txtObservaciones = (EditText) findViewById(R.id.txtObservaciones);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void guardar() {
        if(validar()) {
            //Call<>
        }
    }

    private boolean validar() {
        if(txtTemperatura.getText().toString().isEmpty()){
            Toast.makeText(this, "La temperatura es obligatoria", Toast.LENGTH_LONG).show();
            return false;
        } else{
            return true;
        }
    }
}