package com.wildan.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DataHelper dbhelper;
    private Cursor cursor;
    private List<Soal> soalList;
    private RadioGroup radioGroup;
    private RadioButton pilihanA,pilihanB,pilihanC,pilihanD;
    int nomor;
    public static int hasil,benar,salah;
    private TextView pertanyaan_user, jawaban, jawaban_Benar;
    int jawabanYgDiPilih[] = null;
    int jawabanYgBenar[] = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbhelper = new DataHelper(this);

        pertanyaan_user=(TextView)findViewById(R.id.pertanyaan);
        radioGroup=(RadioGroup)findViewById(R.id.radiogrup);
        pilihanA=(RadioButton)findViewById(R.id.pilihanA);
        pilihanB=(RadioButton)findViewById(R.id.pilihanB);
        pilihanC=(RadioButton)findViewById(R.id.pilihanC);
        pilihanD=(RadioButton)findViewById(R.id.pilihanD);
        radioGroup.check(0);
        benar=0;
        salah=0;
        nomor=0;

        soalList = new ArrayList<Soal>();
        soalList = dbhelper.getmSoal();

        jawabanYgDiPilih = new int[soalList.size()];
        java.util.Arrays.fill(jawabanYgDiPilih, -1);
        jawabanYgBenar = new int[soalList.size()];
        java.util.Arrays.fill(jawabanYgBenar, -1);

    }

    private void setUpSoal(int soal_soal, boolean review){
        try {
            radioGroup.clearCheck();
            Soal soal = new Soal();
            soal = soalList.get(soal_soal);
            String pertanyaan = soal.getmSoal();
            if (jawabanYgBenar[soal_soal] == -1) {
                jawabanYgBenar[soal_soal] = Integer.parseInt(soal.getmAnswer());
            }

            pertanyaan_user.setText(pertanyaan.toCharArray(), 0, pertanyaan.length());
            radioGroup.check(-1);
            String jwb_a = soal.getmOption1();
            pilihanA.setText(jwb_a.toCharArray(), 0,
                    jwb_a.length());
            String jwb_b = soal.getmOption2();
            pilihanB.setText(jwb_b.toCharArray(), 0,
                    jwb_b.length());
            String jwb_c = soal.getmOption3();
            pilihanC.setText(jwb_c.toCharArray(), 0,
                    jwb_c.length());
            String jwb_d = soal.getmOption4();
            pilihanD.setText(jwb_d.toCharArray(), 0,
                    jwb_d.length());

            Log.d("", jawabanYgDiPilih[soal_soal] + "");
            if (jawabanYgDiPilih[soal_soal] == 0)
                radioGroup.check(R.id.pilihanA);
            if (jawabanYgDiPilih[soal_soal] == 1)
                radioGroup.check(R.id.pilihanB);
            if (jawabanYgDiPilih[soal_soal] == 2)
                radioGroup.check(R.id.pilihanC);
            if (jawabanYgDiPilih[soal_soal] == 3)
                radioGroup.check(R.id.pilihanD);

        } catch (Exception e){
            Log.e(this.getClass().toString(), e.getMessage(), e.getCause());
        }
    }

}
