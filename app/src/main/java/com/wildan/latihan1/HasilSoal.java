package com.wildan.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HasilSoal extends AppCompatActivity {

    TextView bnr, slh, nilai;
    Button ulang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_soal);

        bnr = findViewById(R.id.jwbbnr);
        slh = findViewById(R.id.jwbslh);
        nilai = findViewById(R.id.nilai);
        ulang = findViewById(R.id.ulang);

        Bundle bundle = getIntent().getExtras();
        bnr.setText(bundle.getString("benar"));
        slh.setText(bundle.getString("salah"));
        nilai.setText(bundle.getString("hasil"));
    }

    public void ulang (View view){
        Intent i = new Intent(HasilSoal.this, MainActivity.class);
        startActivity(i);
    }
}
