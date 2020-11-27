package com.example.home.interfaces;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Auth {

    @FormUrlEncoded
    @POST("auth/local")
    Call<com.example.home.models.Auth> login(
            @Field("identifier") String email,
            @Field("password") String password
    );
}
