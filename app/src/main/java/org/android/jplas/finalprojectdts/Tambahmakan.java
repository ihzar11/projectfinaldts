package org.android.jplas.finalprojectdts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.android.jplas.finalprojectdts.entity.Makanan;
import org.android.jplas.finalprojectdts.model.MakananModel;

public class Tambahmakan extends AppCompatActivity {

    private EditText edtNamaMakanan, edtKaloriMakanan;
    private Button btnHapus;

    private Makanan makananTerpilih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahmakan);

        this.edtNamaMakanan = this.findViewById(R.id.edtNamaMakanan);
        this.edtKaloriMakanan = this.findViewById(R.id.edtKaloriMakanan);
        this.btnHapus = this.findViewById(R.id.btnhapus);

        // Cek apakah ada Extra di intentnya.
        Intent intentTitipan = this.getIntent();
        int makananId = intentTitipan.getIntExtra("makananId", -1);

        // Apabila ada maka ambil data kontak dari DB sesuai dengan Id yang ada di Extra-nya Intent.
        if(makananId != -1)
        {
            // Ambil dari database..
            this.muatData(makananId);
        }

        this.sesuaikanTampilan();
    }

    private void sesuaikanTampilan()
    {
        if(this.makananTerpilih == null)
            this.btnHapus.setVisibility(View.GONE);
        else
            this.btnHapus.setVisibility(View.VISIBLE);
    }

    private void muatData(int makananId)
    {
        MakananModel mMakan = new MakananModel(this);

        Makanan m = mMakan.cariBerdasarkanId(makananId);

        this.edtNamaMakanan.setText(m.getNamaMakanan());
        this.edtKaloriMakanan.setText(m.getKaloriMakanan());

        this.makananTerpilih = m;
    }

    public void btnSimpan_onClick(View view)
    {
        // Ambil data dari komponen
        String namaMakanan = this.edtNamaMakanan.getText().toString();
        String kaloriMakanan = this.edtKaloriMakanan.getText().toString();

        // Panggil Modelnya
        MakananModel mMakan = new MakananModel(this);

        if (edtNamaMakanan.getText().toString().length() == 0 && edtKaloriMakanan.getText().toString().length() == 0)
        {
            edtNamaMakanan.setError("Isi Data Nama Makanan");
            edtKaloriMakanan.setError("Isi Data Kalori Makanan");
        }
        else if (edtNamaMakanan.getText().toString().length() != 0 && edtKaloriMakanan.getText().toString().length() == 0)
        {
            edtKaloriMakanan.setError("Isi Data Kalori Makanan");
        }
        else if (edtNamaMakanan.getText().toString().length() == 0 && edtKaloriMakanan.getText().toString().length() != 0)
        {
            edtKaloriMakanan.setError("Isi Data Kalori Makanan");
        }
        else
        {
            if(this.makananTerpilih == null)
            {
                // Masukkan ke Entity-nya
                Makanan m = new Makanan();
                m.setNamaMakanan(namaMakanan);
                m.setKaloriMakanan(kaloriMakanan);

                mMakan.tambahMakanan(m);
            }
            else
            {
                this.makananTerpilih.setNamaMakanan(namaMakanan);
                this.makananTerpilih.setKaloriMakanan(kaloriMakanan);

                mMakan.perbaruiMakanan(this.makananTerpilih);
            }

            Toast.makeText(this, "Data telah disimpan..", Toast.LENGTH_SHORT).show();
        }

    }

    public void btnKembali_onClick(View view)
    {
        this.finish();
    }

    public void btnHapus_onClick(View view)
    {
        MakananModel mMakan = new MakananModel(this);

        mMakan.hapusMakanan(this.makananTerpilih);

        this.edtNamaMakanan.setText("");
        this.edtKaloriMakanan.setText("");

        this.makananTerpilih = null;

        this.sesuaikanTampilan();

        Toast.makeText(this, "Data telah dihapus..", Toast.LENGTH_SHORT).show();
    }
}