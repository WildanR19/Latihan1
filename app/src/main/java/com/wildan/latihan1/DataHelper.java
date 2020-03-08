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
        String sql = "create table soal(no integer primary key autoincrement, pertanyaan text, pilA text, pilB text, pilC text, pilD, text, jwbbenar text);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO soal (no, pertanyaan, jwbbenar) VALUES ('1. Ibukota Negara Kesatuan Republik Indonesia adalah ?', 'Medan','Jakarta','Bandung','Surabaya','Jakarta')," +
                "('2. Presiden Pertama Negara Indonesia adalah','Suharto','M.Yamin','Sukarno','Jokowi','Sukarno')," +
                "('3. Lagu Kebangsaan Republik INdonesia adalah','Maju Takgentar','Indonesia Merdeka','Indonesia Raya','Himne guru','Indonesia Raya')," +
                "('4. Lambang Negara Kesatuan Republik Indonesia adalah','Burung ELang','Burung Nuri','Burung Kakatua','Burung Garuda','Burung Garuda')," +
                "('5. Bendera Negara Kesatuan Republik Indoesia adalah','Merah kuning','Merah Putih','Merah Jambu','Merah biru','Merah Putih');";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }

}
