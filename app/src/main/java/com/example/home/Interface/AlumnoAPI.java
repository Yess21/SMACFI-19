package com.example.home.Interface;

import com.example.home.model.Alumno;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlumnoAPI {

    @GET("personas")
    Call<List<Alumno>> getAlumnos();

}
