package org.android.jplas.finalprojectdts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.android.jplas.finalprojectdts.adapter.RecyclerViewAdapter;

import java.util.ArrayList;

public class Listmakan extends AppCompatActivity {

    private ArrayList<String> fotoMakanan = new ArrayList<>();
    private ArrayList<String> namaMakanan = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listmakan);

        getDataFromInternet();
    }

    private void prosesRecyclerViewAdapter()
    {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(fotoMakanan, namaMakanan, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDataFromInternet()
    {
        namaMakanan.add("Mie kocok bandung");
        fotoMakanan.add("https://makananoleholeh.com/wp-content/uploads/2018/10/Mie-kocok-bandung.jpg");

        namaMakanan.add("Ayam betutu Bali");
        fotoMakanan.add("https://makananoleholeh.com/wp-content/uploads/2018/10/ayam-betutu-bali.jpg");

        namaMakanan.add("Papeda irian jaya");
        fotoMakanan.add("https://makananoleholeh.com/wp-content/uploads/2018/10/Papeda-irian-jaya.jpg");

        prosesRecyclerViewAdapter();
    }
}