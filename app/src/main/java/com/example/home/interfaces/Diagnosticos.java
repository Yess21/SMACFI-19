package com.example.home.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface Diagnosticos {

    @GET("diagnosticos/alumnos/{enrollment}")
    Call<com.example.home.models.Diagnosticos> getDiagnostico(
            @Header("Authorization") String token,
            @Path("enrollment") String enrollment
    );
}
