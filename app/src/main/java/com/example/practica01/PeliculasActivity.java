package com.example.practica01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PeliculasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);
    }

    public void iniciarActListPelis(View view){
        //Apartado para obtener el texto de un plane text de Titulo
        EditText et_Pelicula = (EditText) findViewById(R.id.etxt_titulo);
        String tituloP = et_Pelicula.getText().toString();
        //Apartado para obtener el texto del spinner de Género
        Spinner sp_Genero = (Spinner) findViewById(R.id.sp_genero);
        String generoP = sp_Genero.getSelectedItem().toString();
        //Crear pelicula
        Pelicula peli = new Pelicula(tituloP, generoP);

        //-----------------Guardar en la BD de fireBase-------------------\\
        //Instacia a una referencia a la BD
        DatabaseReference miDbRef = FirebaseDatabase.getInstance().getReference().child("peliculas");
        //agregar Una pelicula - Utilizando el método push parsa que genere una nueva
        DatabaseReference nuevPeli = miDbRef.push();
        nuevPeli.setValue(peli);



        Intent intent = new Intent(this, PeliculasListActivity.class);
        startActivity(intent);
    }
}