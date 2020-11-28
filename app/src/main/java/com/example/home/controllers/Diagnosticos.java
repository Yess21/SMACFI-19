package com.example.home.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.R;
import com.example.home.api.RetrofitClient;
import com.example.home.api.Sesion;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Diagnosticos extends AppCompatActivity {

    private Button btnAgregar,btnActualizar,btnEliminar, btnBuscar;
    private TextView txtNombre, txtGrupo, txtCarrera, txtArea, txtSistema,
            txtTemperatura, txtSintomas, txtAltura, txtPeso, txtDiagnostico,
            txtObservaciones, txtFecha;
    private EditText txtMatricula;
    private String matricula;
    private com.example.home.models.Diagnosticos diagnostico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosticos);

        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        txtMatricula = (EditText) findViewById(R.id.txtMatricula);
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtGrupo = (TextView) findViewById(R.id.txtGrupo);
        txtCarrera = (TextView) findViewById(R.id.txtCarrera);
        txtArea = (TextView) findViewById(R.id.txtArea);
        txtSistema = (TextView) findViewById(R.id.txtSistema);
        txtTemperatura = (TextView) findViewById(R.id.txtTemperatura);
        txtSintomas = (TextView) findViewById(R.id.txtSintomas);
        txtAltura = (TextView) findViewById(R.id.txtAltura);
        txtPeso = (TextView) findViewById(R.id.txtPeso);
        txtDiagnostico = (TextView) findViewById(R.id.txtDiagnostico);
        txtObservaciones = (TextView) findViewById(R.id.txtObservaciones);
        txtFecha = (TextView) findViewById(R.id.txtFecha);


        btnAgregar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent Create = new Intent(Diagnosticos.this,Freporte.class);
                startActivity(Create);
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent Update = new Intent(Diagnosticos.this,Freporte.class);
                startActivity(Update);
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar();
            }
        });
    }

    public Diagnosticos() {
        diagnostico = new com.example.home.models.Diagnosticos();
    }

    public void buscar() {
        if(validar()){
            String token = "Bearer " + Sesion.get(Diagnosticos.this).getSharedPreferences().getString(Sesion.PREF_USER_TOKEN, "Null");
            Call<com.example.home.models.Diagnosticos> call = RetrofitClient.getInstance().getDiagnosticos().getDiagnostico(token, matricula);

            call.enqueue(new Callback<com.example.home.models.Diagnosticos>() {
                @Override
                public void onResponse(Call<com.example.home.models.Diagnosticos> call, Response<com.example.home.models.Diagnosticos> response) {

                    if (!response.isSuccessful()) {
                        String error = "";
                        if (response.errorBody().contentType().subtype().equals("application/json")) {
                            error = response.errorBody().toString();
                            Log.d("DiagnosticosActivity", error);
                        } else {
                            error = response.message();
                        }

                        Toast.makeText(Diagnosticos.this, error, Toast.LENGTH_LONG).show();
                    }
                    else {
                        diagnostico = response.body();
                        llenarDatos();
                    }
                }

                @Override
                public void onFailure(Call<com.example.home.models.Diagnosticos> call, Throwable t) {
                    Toast.makeText(Diagnosticos.this, "Error => "+t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void llenarDatos() {
        txtNombre.setText(diagnostico.getPersona_canalizada().getAlumno().getPersona().getName());
        txtGrupo.setText(diagnostico.getPersona_canalizada().getAlumno().getGroup());
        txtCarrera.setText(diagnostico.getPersona_canalizada().getAlumno().getEducational_program());
        txtArea.setText(diagnostico.getPersona_canalizada().getAlumno().getArea());
        txtSistema.setText(diagnostico.getPersona_canalizada().getAlumno().getSystem());
        txtTemperatura.setText(String.valueOf(diagnostico.getTemperature()));
        txtSintomas.setText(diagnostico.getSymptoms());
        txtAltura.setText(String.valueOf(diagnostico.getHeight()));
        txtPeso.setText(String.valueOf(diagnostico.getWeight()));
        txtDiagnostico.setText(diagnostico.getDiagnostic());
        txtObservaciones.setText(diagnostico.getPersona_canalizada().getObservations());
        txtFecha.setText(String.valueOf(diagnostico.getCreated_at()));
    }

    public boolean validar() {
        matricula = txtMatricula.getText().toString().trim();

        if(matricula.isEmpty()) {
            Toast.makeText(this, "La matrícula es necesaria", Toast.LENGTH_LONG).show();
        } else if(matricula.length() > 12) {
            Toast.makeText(this, "La matrícula es demasiado larga", Toast.LENGTH_LONG).show();
        } else {
            return true;
        }
        return false;
    }
}