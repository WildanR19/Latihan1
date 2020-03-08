package com.wildan.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView pertanyaan;
    Button tombolnext;
    RadioGroup radioGroup;
    RadioButton pilihanA,pilihanB,pilihanC,pilihanD;
    int nomor;
    public static int hasil,benar,salah;
    String[] pertanyaan_user=new String[]{
            "1. Ibukota Negara Kesatuan Republik Indonesia adalah ?",
            "2. Presiden Pertama Negara Indonesia adalah",
            "3. Lagu Kebangsaan Republik INdonesia adalah",
            "4. Lambang Negara Kesatuan Republik Indonesia adalah",
            "5. Bendera Negara Kesatuan Republik Indoesia adalah"
    };
    String[] jawaban=new String[]{
            "Medan","Jakarta","Bandung","Surabaya",
            "Suharto","M.Yamin","Sukarno","Jokowi",
            "Maju Takgentar","Indonesia Merdeka","Indonesia Raya","Himne guru",
            "Burung ELang","Burung Nuri","Burung Kakatua","Burung Garuda",
            "Merah kuning","Merah Putih","Merah Jambu","Merah biru"
    };
    String[] jawaban_Benar=new String[]{
            "Jakarta",
            "Sukarno",
            "Indonesia Raya",
            "Burung Garuda",
            "Merah Putih"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pertanyaan=(TextView)findViewById(R.id.pertanyaan);
        radioGroup=(RadioGroup)findViewById(R.id.radiogrup);
        pilihanA=(RadioButton)findViewById(R.id.pilihanA);
        pilihanB=(RadioButton)findViewById(R.id.pilihanB);
        pilihanC=(RadioButton)findViewById(R.id.pilihanC);
        pilihanD=(RadioButton)findViewById(R.id.pilihanD);
        pertanyaan.setText(pertanyaan_user[0]);
        pilihanA.setText(jawaban[0]);
        pilihanB.setText(jawaban[1]);
        pilihanC.setText(jawaban[2]);
        pilihanD.setText(jawaban[3]);
        radioGroup.check(0);
        benar=0;
        salah=0;
        nomor=0;
    }

    public void lanjut(View view){
        if (pilihanA.isChecked()||pilihanB.isChecked()||pilihanC.isChecked()||pilihanD.isChecked()){
            //pilihan radio adalah pilihan sesuai dengan pilihan dalan radio group
            RadioButton jawaban_user=(RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
            String ambiljawaban_user=jawaban_user.getText().toString();
            radioGroup.check(0);
            if (ambiljawaban_user.equalsIgnoreCase(jawaban_Benar[nomor]))
                benar++;
            else
                salah++;
            nomor++;
            if(nomor<pertanyaan_user.length) {
                pertanyaan.setText(pertanyaan_user[nomor]);
                pilihanA.setText(jawaban[(nomor*4)+0]);
                pilihanB.setText(jawaban[(nomor*4)+1]);
                pilihanC.setText(jawaban[(nomor*4)+2]);
                pilihanD.setText(jawaban[(nomor*4)+3]);
            }else {
                hasil=benar*20;
                Bundle bundle = new Bundle();
                bundle.putString("benar", String.valueOf(benar));
                bundle.putString("salah", String.valueOf(salah));
                bundle.putString("hasil", String.valueOf(hasil));
                Intent nilaisoal=new Intent(getApplicationContext(),HasilSoal.class);
                nilaisoal.putExtras(bundle);
                startActivity(nilaisoal);
            }
        }else
        {
            Toast.makeText(getApplicationContext(),"Pilih Jawaban terlebih dahulu !",Toast.LENGTH_LONG).show();
        }
    }
}
