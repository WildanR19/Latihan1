package com.wildan.latihan1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import com.wildan.latihan1.latihan.TabelSoal;

import java.util.ArrayList;
import java.util.List;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "latihan";
    private static final int DB_VERSION = 8;

    private final String CREATE_TABLE_QUERY = "CREATE TABLE " + TabelSoal.TABLE_NAME +
            "(" +
            TabelSoal._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TabelSoal.COLUMN_SOAL + " TEXT, " +
            TabelSoal.COLUMN_OPTION1 + " TEXT, " +
            TabelSoal.COLUMN_OPTION2 + " TEXT, " +
            TabelSoal.COLUMN_OPTION3 + " TEXT, " +
            TabelSoal.COLUMN_OPTION4 + " TEXT, " +
            TabelSoal.COLUMN_ANSWER + " TEXT " +
            ")";

    private final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TabelSoal.TABLE_NAME;
    public DataHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    private SQLiteDatabase db;
    private List<Soal> mSoalList;

    private Bundle categoryIntentBundle;

    public DataHelper(Context context, Bundle bundle) {
        super(context, DB_NAME, null, DB_VERSION);
        this.categoryIntentBundle = bundle;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL(CREATE_TABLE_QUERY);

        setUpSoal();
        //insertSoal();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_QUERY);
        onCreate(db);
    }

    private void setUpSoal(){
        mSoalList = new ArrayList<>();

        mSoalList.add(new Soal("1. Ibukota Negara Kesatuan Republik Indonesia adalah ?","Medan","Jakarta","Bandung","Surabaya","Jakarta"));
        mSoalList.add(new Soal("2. Presiden Pertama Negara Indonesia adalah","Suharto","M.Yamin","Sukarno","Jokowi","Sukarno"));
        mSoalList.add(new Soal("3. Lagu Kebangsaan Republik INdonesia adalah","Maju Takgentar","Indonesia Merdeka","Indonesia Raya","Himne guru","Indonesia Raya"));
        mSoalList.add(new Soal("4. Lambang Negara Kesatuan Republik Indonesia adalah","Burung ELang","Burung Nuri","Burung Kakatua","Burung Garuda","Burung Garuda"));
        mSoalList.add(new Soal("5. Bendera Negara Kesatuan Republik Indoesia adalah","Merah kuning","Merah Putih","Merah Jambu","Merah biru","Merah Putih"));
    }

    public List<Soal> getmSoal(){
        List<Soal> listSoal = new ArrayList<Soal>();
        String query = "select * from "+ TabelSoal.TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Soal s = new Soal();
                s.setmSoal(cursor.getString(1));
                s.setmOption1(cursor.getString(2));
                s.setmOption2(cursor.getString(3));
                s.setmOption3(cursor.getString(4));
                s.setmOption4(cursor.getString(5));
                s.setmAnswer(cursor.getString(6));
                listSoal.add(s);
            }while(cursor.moveToNext());
        }

        return listSoal;
    }

    //tambahan untuk insert soal
    private void insertSoal(){
        for(Soal q : mSoalList) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(TabelSoal.COLUMN_SOAL, q.getmSoal());
            contentValues.put(TabelSoal.COLUMN_OPTION1, q.getmOption1());
            contentValues.put(TabelSoal.COLUMN_OPTION2, q.getmOption2());
            contentValues.put(TabelSoal.COLUMN_OPTION3, q.getmOption3());
            contentValues.put(TabelSoal.COLUMN_OPTION4, q.getmOption4());
            contentValues.put(TabelSoal.COLUMN_ANSWER, q.getmAnswer());
            db.insert(TabelSoal.TABLE_NAME, null, contentValues);
        }
    }


}
