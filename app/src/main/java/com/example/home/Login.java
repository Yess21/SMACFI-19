package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    Button btnLogin;
    EditText txtUsuario, txtContrasena;
    String usuario, contrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtContrasena = (EditText) findViewById(R.id.txtContrasena);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = txtUsuario.getText().toString();
                contrasena = txtContrasena.getText().toString();
                if (!usuario.isEmpty() && !contrasena.isEmpty()) { //Si no esta vacio
                    validarUsuario("http://192.168.1.70/api_usuarios/Usuario.php");
                } else {
                    Toast.makeText(Login.this, "Faltan datos", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void validarUsuario(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            //En caso de exito, que pasará cuando obtienes la respuesta
            public void onResponse(String response) {
                if(!response.isEmpty()) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Datos incorrectos", Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() { //Si no se procesa la petición o existe otro error
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, error.toString(), Toast.LENGTH_SHORT).show();

            }

        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>(); //Upcasting, Downcasting
                parametros.put("usuario", txtUsuario.getText().toString());
                parametros.put("contrasena", txtContrasena.getText().toString());
                return parametros; //Paramétros que la API solicita para devolver una respuesta
            }
        };

        //Para procesar las peticiones desde la app
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}