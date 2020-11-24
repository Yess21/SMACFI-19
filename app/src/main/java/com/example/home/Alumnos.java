package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.Interface.AlumnoAPI;
import com.example.home.model.Alumno;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Alumnos extends AppCompatActivity {

    public TextView nombreAlumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);

        nombreAlumno = (TextView) findViewById(R.id.nombre);
        getAlumnos();
    }

    private void getAlumnos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://smacfi-19.herokuapp.com/admin/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AlumnoAPI alumnoAPI = retrofit.create(AlumnoAPI.class);
        Call<List<Alumno>> call = alumnoAPI.getAlumnos();
        call.enqueue(new Callback<List<Alumno>>() {
            @Override
            public void onResponse(Call<List<Alumno>> call, Response<List<Alumno>> response) {

                if(!response.isSuccessful()) {
                    Toast.makeText(Alumnos.this, "Codigo"+response.code(), Toast.LENGTH_LONG).show();
                    return;
                    }

                List<Alumno> alumnoList = response.body();

                for(Alumno alumno: alumnoList){
                    String nombre = "", genero = "", imss = "", status = "", codigo =""  ;
                    nombre += "name" + alumno.getName();
                    nombre += "father_surname" + alumno.getFather_surname();
                    nombre += "mother_surname" + alumno.getMother_surname();
                    genero += "gender" + alumno.isGender();
                    imss += "no_imss" + alumno.getNo_imss();
                    status += "status" + alumno.isStatus();
                    codigo += "barcode" + alumno.getBarcode();
                    nombreAlumno.append(nombre);

                }

            }

            @Override
            public void onFailure(Call<List<Alumno>> call, Throwable t) {
                Toast.makeText(Alumnos.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }


}