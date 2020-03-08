package com.wildan.latihan1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "latihan";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table soal(no integer primary key, pertanyaan text, jwbbenar text);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        String sqla = "create table jawaban(jwb text);";
        Log.d("Data", "onCreate: " + sqla);
        db.execSQL(sqla);
        sql = "INSERT INTO soal (no, pertanyaan, jwbbenar) VALUES ('1', '1. Ibukota Negara Kesatuan Republik Indonesia adalah ?', 'Jakarta')," +
                "('2','2. Presiden Pertama Negara Indonesia adalah','Sukarno')," +
                "('3','3. Lagu Kebangsaan Republik INdonesia adalah','Indonesia Raya');";
        db.execSQL(sql);
        sqla = "INSERT INTO jawaban VALUES ('Medan'),('Jakarta'),('Bandung'),('Surabaya')," +
                "('Suharto'),('M.Yamin'),('Sukarno'),('Jokowi')," +
                "('Maju Takgentar'),('Indonesia Merdeka'),('Indonesia Raya'),('Himne guru')," +
                "('Burung ELang'),('Burung Nuri'),('Burung Kakatua'),('Burung Garuda')," +
                "('Merah kuning'),('Merah Putih'),('Merah Jambu'),('Merah biru');";
        db.execSQL(sqla);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }

}
