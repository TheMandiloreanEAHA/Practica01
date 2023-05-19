package com.example.practica01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Canciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canciones);
    }

    public void guardarCancion(View view ){
        //Apartado para obtener el texto de un plane text de cancion
        EditText et_Cancion = (EditText) findViewById(R.id.pt_NomSong);
        String cancion = et_Cancion.getText().toString();
        //Apartado para obtener el texto de un plane text del Artista
        EditText et_Artista = (EditText) findViewById(R.id.pt_NomArtist);
        String artista = et_Artista.getText().toString();

        CancionesHelper dbHelper = new CancionesHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(CancionesContract.CancionTab.COLUMN_TITULO,cancion);
        valores.put(CancionesContract.CancionTab.COLUMN_ARTISTA, artista);

        /*------------Clase martes 25/03/23 ---------------------*/
        long idNewC = db.insert(CancionesContract.CancionTab.TABLE_NAME, null, valores);
        String idC = Long.toString(idNewC);
        Toast.makeText(getApplicationContext(), "Cancion Guarada Exitosamente: "+idC, Toast.LENGTH_SHORT).show();

        Intent intent2 = new Intent(this, CancionesListActivity.class);
        startActivity(intent2);

    }
}