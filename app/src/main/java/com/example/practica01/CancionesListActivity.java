package com.example.practica01;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CancionesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canciones_list);

        CancionesHelper dbHelper = new CancionesHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(
                CancionesContract.CancionTab.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
        
        List lisCanciones = new ArrayList<>();
        while (cursor.moveToNext()){
            String cancion =" "+ cursor.getString(cursor.getColumnIndexOrThrow(CancionesContract.CancionTab._ID))+" "+
            cursor.getString(cursor.getColumnIndexOrThrow(CancionesContract.CancionTab.COLUMN_TITULO))+" -"+ 
            cursor.getString(cursor.getColumnIndexOrThrow(CancionesContract.CancionTab.COLUMN_ARTISTA));
            lisCanciones.add(cancion);
        }

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                lisCanciones
        );
        ListView listt_can = (ListView) findViewById(R.id.listv_Canciones);
        listt_can.setAdapter(arrayAdapter);

    }
}