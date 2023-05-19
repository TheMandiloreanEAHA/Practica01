package com.example.practica01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
//--------------------------------- Botones de Selección -------------------\\
public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //Obtiene el intent que llama a esta actividad
        Intent intent = getIntent();
        String usuario = intent.getStringExtra("usuario");
        //Crea un objeto textView para poder cambiar su texto desde su ID
        TextView txt_bienvenida = findViewById(R.id.tv_apodo);

        //Recuperar valor del SharedPref
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String apodo = sh.getString("apodo", "");
        txt_bienvenida.setText("Bienvenido "+ apodo);

    }
    public void iniciarActCanciones(View view){
        Intent intent = new Intent(this, Activity_Canciones.class);
        startActivity(intent);
    }

    public void iniciarActPeliculas(View view){
        Intent intent = new Intent(this, PeliculasActivity.class);
        startActivity(intent);
    }
}

    //Recuperar valor del SharedPref
    //SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
    //String apodo = sh.getString("apodo", "");
    //txt_bienvenida.setText("Bienvenido "+ apodo);