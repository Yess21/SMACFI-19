package com.example.home.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.home.models.Auth;

public class Sesion {
    private static Sesion INSTANCE;
    public static final String PREFS_NAME = "SMACFI-19";
    public static final String PREF_USER_ID = "";
    public static final String PREF_USER_NAME = "";
    public static final String PREF_USER_SURNAME_F = "";
    public static final String PREF_USER_SURNAME_M = "";
    public static final String PREF_USER_GENDER = "";
    public static final String PREF_USER_USERNAME = "";
    public static final String PREF_USER_EMAIL = "";
    public static final String PREF_USER_PASSWORD = "";
    public static final String PREF_USER_ROLE = "";
    public static final String PREF_USER_TOKEN = "";
    private final SharedPreferences mPrefs;
    private boolean isLogged = false;

    //Patrón singletón
    public static Sesion get(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Sesion(context);
        }
        return INSTANCE;
    }

    private Sesion(Context context) {
        mPrefs = context.getApplicationContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        isLogged = !TextUtils.isEmpty(mPrefs.getString(PREF_USER_TOKEN, null));
    }

    public boolean isLoggedIn(){
        return isLogged;
    }

    public void iniciarSesion(Auth auth) {
        if (auth != null) {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putString(PREF_USER_ID, String.valueOf(auth.getUser().getId()));
            editor.putString(PREF_USER_NAME, auth.getUser().getPersona().getName());
            editor.putString(PREF_USER_SURNAME_F, auth.getUser().getPersona().getFather_surname());
            editor.putString(PREF_USER_SURNAME_M, auth.getUser().getPersona().getMother_surname());
            editor.putString(PREF_USER_GENDER, String.valueOf(auth.getUser().getPersona().isGender()));
            editor.putString(PREF_USER_USERNAME, auth.getUser().getUsername());
            editor.putString(PREF_USER_EMAIL, auth.getUser().getEmail());
            editor.putString(PREF_USER_PASSWORD, auth.getUser().getPassword());
            editor.putString(PREF_USER_ROLE, auth.getUser().getRole().getName());
            editor.putString(PREF_USER_TOKEN, auth.getJwt());
            editor.apply();

            isLogged = true;
        }
    }

    public void cerrarSesion(){
        isLogged = false;
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(PREF_USER_ID, null);
        editor.putString(PREF_USER_NAME, null);
        editor.putString(PREF_USER_SURNAME_F, null);
        editor.putString(PREF_USER_SURNAME_M, null);
        editor.putString(PREF_USER_GENDER, null);
        editor.putString(PREF_USER_USERNAME, null);
        editor.putString(PREF_USER_EMAIL, null);
        editor.putString(PREF_USER_PASSWORD, null);
        editor.putString(PREF_USER_ROLE, null);
        editor.putString(PREF_USER_TOKEN, null);
        editor.apply();
    }
}
