package com.example.practica01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
//------------------------------------LOGIN Inicial ----------------------------------\\
public class MainActivity extends AppCompatActivity {
    //Se crea el usuario y contraseña por default
    String user = "erick16";
    String pass = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void iniciarAct(View view){
        //Apartado para obtener el texto de un plane text de usuario
        EditText et_usuario = (EditText) findViewById(R.id.pt_usuario);
        String usuario = et_usuario.getText().toString();
        //Apartado para obtener el texto de un plane text de password
        EditText et_pwsd = (EditText) findViewById(R.id.pass_contrasenia);
        String pwsd = et_pwsd.getText().toString();
        //Apartado para obtener el texto de un plane text de apodo
        EditText et_apodo = (EditText) findViewById(R.id.pt_apodo);
        String apodo = et_apodo.getText().toString();
        //Guardar apodo en Shared preferences
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sh.edit(); //Se crea un editor del SH pref
        editor.putString("apodo", apodo);
        editor.putString("usuario", usuario);
        editor.commit(); //Se tiene que hacer siempre que se hcae un cambio en el editor


        //Crea la comparacion
        if(usuario.equals(user)  && pwsd.equals(pass)){
            //Se crea el Intent para mandar a llar a la otra activity
            Intent intent = new Intent(this, Activity2.class);
            intent.putExtra("usuario", usuario);
            startActivity(intent);

        }else if(usuario.equals(user)  && !pwsd.equals(pass)){
            Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
        }else if(!usuario.equals(user)  && pwsd.equals(pass)){
            Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();
        }else if(!usuario.equals(user)  && !pwsd.equals(pass)){
            Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_SHORT).show();
        }


    }
}