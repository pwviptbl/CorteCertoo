package com.mjr.cortecerto.DB;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBSQLiteO extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "DB.db";
    public static final String TABELA = " config";
    public static final String CODIGO = "codigo";
    private static final int VERSAO = 1;
    private static final String TABLE_CREATE = "CREATE TABLE config (codigo TEXT);";


    public DBSQLiteO(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_CREATE);


        }


        @Override
        public void onUpgrade (SQLiteDatabase db,int oldVersion, int newVersion){
            db.execSQL(" DROP TABLE IF EXISTS " + TABELA);
            onCreate(db);
        }
    }
