package com.mjr.cortecerto.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class BancoController {



    private SQLiteDatabase db;
    private DBSQLiteO banco;
    private Context context;

    public BancoController(Context context){
        banco = new DBSQLiteO(context);
    }

    public String insereDado(String codigo){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(banco.CODIGO, codigo);

        resultado = db.insert(banco.TABELA, null, valores);
        db.close();

        if (resultado ==-1) {
            return "Erro ao inserir registro";
        }else {
        }return "Registro Inserido com sucesso" ;

    }

    public Cursor carregaDados(){
        String selectQuery = "SELECT codigo FROM config";

        db = banco.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

}