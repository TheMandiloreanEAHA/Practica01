package com.example.practica01;

import android.provider.BaseColumns;

public final class CancionesContract {
    private CancionesContract(){}

    public static class CancionTab implements BaseColumns{
        public static final String TABLE_NAME = "Cancion";
        public static final String COLUMN_TITULO = "titulo";
        public static final String COLUMN_ARTISTA = "artista";

    }
}
