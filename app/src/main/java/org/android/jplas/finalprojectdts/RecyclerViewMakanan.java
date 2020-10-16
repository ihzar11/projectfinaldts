package org.android.jplas.finalprojectdts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.android.jplas.finalprojectdts.adapter.RVAdapter;
import org.android.jplas.finalprojectdts.adapter.RecyclerViewAdapter;
import org.android.jplas.finalprojectdts.entity.Makanan;
import org.android.jplas.finalprojectdts.model.MakananModel;

import java.util.ArrayList;

public class RecyclerViewMakanan extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lstDaftarMakanan;

    // Adapter untuk ListView
    private ArrayAdapter<String> adapterDaftarMakanan;

    // Daftar nama dalam bentuk ArrayList<String>
    private ArrayList<String> daftarNama; // Contoh: ['Adi', 'Budi', 'Cici']

    // Daftar kontak dari database
    private ArrayList<Makanan> daftarMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_makanan);

        this.lstDaftarMakanan = this.findViewById(R.id.lst_daftar_makanan);

        this.daftarNama = new ArrayList<>(); // [], Array yang belum punya isi, tetapi TIDAK null.

        this.isiDaftarNama();

        this.adapterDaftarMakanan = new ArrayAdapter<>(
                this, // Konteks/Activity yang memanggil
                android.R.layout.simple_list_item_1, // Template bawaan Android
                this.daftarNama // Dari mana datanya diambil
        );

        // Pasangkan adapter ke ListView
        this.lstDaftarMakanan.setAdapter(this.adapterDaftarMakanan);

        // Ketika list item diklik muncul toast.
        // Event Listener
        // Tentang: objek yang "mendengarkan" apa yang dialami oleh objek yang didengarkan
        this.lstDaftarMakanan.setOnItemClickListener(this);

    }

    private void isiDaftarNama()
    {
       MakananModel mMakan = new MakananModel(this);

        ArrayList<Makanan> daftarMakanan = mMakan.ambilSemuaMakanan();

        for (Makanan m : daftarMakanan)
        {
            this.daftarNama.add(m.getNamaMakanan());
        }

        // Kita simpan daftarKontaknya ke property class
        this.daftarMakanan = daftarMakanan;
    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        // Lakukan apa saja yang Anda inginkan ketika itemnya ListView diklik.
        // Ambil kontak dari array sesuai dengan posisi klik oleh user
        Makanan makananDiKlik = this.daftarMakanan.get(position);

        int makananId = makananDiKlik.getId();

        Intent i = new Intent(RecyclerViewMakanan.this, Tambahmakan.class);
        i.putExtra("makananId", makananId);
        this.startActivity(i);
    }

    public void btnKembali_onClick(View view)
    {
        this.finish();
    }

    public void btnRefresh_onClick(View view)
    {
        this.daftarMakanan.clear();

        this.daftarNama.clear();

        this.adapterDaftarMakanan.clear();

        this.isiDaftarNama();

        this.adapterDaftarMakanan.notifyDataSetChanged();

        Toast.makeText(this, "Data telah di-refresh..", Toast.LENGTH_SHORT).show();
    }

}