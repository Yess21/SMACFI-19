package com.example.home.interfaces;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Diagnosticos {

    @GET("diagnosticos/alumnos/{enrollment}")
    Call<com.example.home.models.Diagnosticos> getDiagnostico(
            @Header("Authorization") String token,
            @Path("enrollment") String enrollment
    );

    @FormUrlEncoded
    @POST("diagnosticos")
    Call<com.example.home.models.Diagnosticos> postDiagnostico(
            @Header("Authorization") String token,
            @Field("symptoms") String symptoms,
            @Field("temperature") String temperature,
            @Field("diagnostic") String diagnostic,
            @Field("weight") String weight,
            @Field("height") String height,
            @Field("persona_canalizada") int persona_canalizada,
            @Field("status") int status,
            @Field("published_at") String published_at
    );
}
