package com.wildan.latihan1;

import android.content.Context;
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

    private final String CREATE_TABLE_QUERY = "CREATE TABLE " + latihan.TabelSoal.TABLE_NAME +
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
        insertSoal();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_QUERY);
        onCreate(db);
    }

    private void setUpSoal(){
        mSoalList = new ArrayList<>();

        mSoalList.add(new Soal("1. Ibukota Negara Kesatuan Republik Indonesia adalah ?","Medan","Jakarta","Bandung","Surabaya","Jakarta"));
    }

}
