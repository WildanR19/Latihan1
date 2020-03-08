package com.wildan.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataHelper dbhelper;
    Cursor cursor;
    TextView pertanyaan;
    Button tombolnext;
    RadioGroup radioGroup;
    RadioButton pilihanA,pilihanB,pilihanC,pilihanD;
    int nomor;
    public static int hasil,benar,salah;
    TextView pertanyaan_user, jawaban, jawaban_Benar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbhelper = new DataHelper(this);
        pertanyaan=(TextView)findViewById(R.id.pertanyaan);
        radioGroup=(RadioGroup)findViewById(R.id.radiogrup);
        pilihanA=(RadioButton)findViewById(R.id.pilihanA);
        pilihanB=(RadioButton)findViewById(R.id.pilihanB);
        pilihanC=(RadioButton)findViewById(R.id.pilihanC);
        pilihanD=(RadioButton)findViewById(R.id.pilihanD);


        radioGroup.check(0);
        benar=0;
        salah=0;
        nomor=0;
    }

    public void lanjut(View view){

    }
}
