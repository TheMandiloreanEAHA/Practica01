package com.example.practica01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;
//-------Ayuda a gestionar las consultas, como crear las bases de datos y las inserciones --------------//
public class CancionesHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "Cancionesdb.db";

    //-------------Consultas SQL--------------\\
    public static final String SQL_CRATE_CANCIONES = "CREATE TABLE " + CancionesContract.CancionTab.TABLE_NAME+
            "("+ BaseColumns._ID+" INTEGER PRIMARY KEY,"+
            CancionesContract.CancionTab.COLUMN_TITULO+" TEXT,"+
            CancionesContract.CancionTab.COLUMN_ARTISTA+" TEXT)";
    public static final String SQL_DELETE_CANCIONES = "DROP TABLE IF EXISTS "+ CancionesContract.CancionTab.TABLE_NAME;
    public CancionesHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CRATE_CANCIONES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_CANCIONES);
        onCreate(db);
    }
}
