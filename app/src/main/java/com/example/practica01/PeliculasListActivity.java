package com.example.practica01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PeliculasListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas_list);

        FirebaseDatabase fdb = FirebaseDatabase.getInstance();
        DatabaseReference myRef = fdb.getReference("peliculas");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //formamos el resultado en un string
                Iterable<DataSnapshot> peliculas = dataSnapshot.getChildren();
                List listPeli = new ArrayList<>();
                for(DataSnapshot data : peliculas) {
                    Pelicula pelicula = data.getValue(Pelicula.class);
                    String info = "Titulo: " + pelicula.getTitulo() + ", Genero: " + pelicula.getGenero();
                    listPeli.add(info);
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                        getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        listPeli
                );
                ListView list_can = (ListView) findViewById(R.id.listv_peliculas);
                list_can.setAdapter(arrayAdapter);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "ERROR FIREBASE" + databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });



    }
}