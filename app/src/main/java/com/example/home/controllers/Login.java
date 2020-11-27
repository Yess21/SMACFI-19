package com.example.home.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.home.R;
import com.example.home.api.RetrofitClient;
import com.example.home.api.Sesion;
import com.example.home.models.Auth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private Button btnLogin;
    private EditText txtEmail, txtPassword;
    private ProgressBar pgbBarraCarga;
    private String email, password;
    private Auth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        pgbBarraCarga = (ProgressBar) findViewById(R.id.pgbBarraCarga);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pgbBarraCarga.setVisibility(View.VISIBLE);
                desactivar();
                login();
            }
        });
    }

    public Login() {
        auth = new Auth();
    }

    private void login() {
        if(validacion()) {
            request();
        } else {
            pgbBarraCarga.setVisibility(View.GONE);
            activar();
        }
    }

    public void desactivar() {
        txtEmail.setEnabled(false);
        txtPassword.setEnabled(false);
        btnLogin.setEnabled(false);
    }

    public void activar() {
        txtEmail.setEnabled(true);
        txtPassword.setEnabled(true);
        btnLogin.setEnabled(true);
    }

    private boolean validacion() {
        email = txtEmail.getText().toString();
        password = txtPassword.getText().toString();

        if (email.isEmpty()) {
            Toast.makeText(this, "El correo es obligatorio", Toast.LENGTH_LONG).show();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "El correo no es válido", Toast.LENGTH_LONG).show();
            return false;
        } else if (password.isEmpty()) {
            Toast.makeText(this, "La contraseña es obligatoria", Toast.LENGTH_LONG).show();
            return false;
        } else if (password.length() < 6) {
            Toast.makeText(this, "La contraseña debe ser mayor a 6 caracteres", Toast.LENGTH_LONG).show();
            return false;
        }  else {
            return true;
        }
    }

    private void request() {
        Call<Auth> call = RetrofitClient.getInstance().getLogin().login(email, password);

        call.enqueue(new Callback<Auth>() {
            @Override
            public void onResponse(Call<Auth> call, Response<Auth> response) {

                if (!response.isSuccessful()) {
                    String error = "";
                    if (response.errorBody().contentType().subtype().equals("application/json")) {
                        error = response.errorBody().toString();
                        Log.d("LoginActivity", error);
                    } else {
                        error = response.message();
                    }

                    pgbBarraCarga.setVisibility(View.GONE);
                    activar();
                    Toast.makeText(Login.this, error, Toast.LENGTH_LONG).show();
                }
                else {
                    pgbBarraCarga.setVisibility(View.GONE);
                    auth = response.body();
                    Sesion.get(Login.this).iniciarSesion(auth);
                    if (Sesion.get(Login.this).isLoggedIn()) {
                        startActivity(new Intent(Login.this, MainActivity.class));
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<Auth> call, Throwable t) {
                Toast.makeText(Login.this, "Error: "+t.getMessage(), Toast.LENGTH_LONG).show();
                pgbBarraCarga.setVisibility(View.GONE);
                activar();
            }
        });
    }
}