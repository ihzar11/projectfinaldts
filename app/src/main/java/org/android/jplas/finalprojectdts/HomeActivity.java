package org.android.jplas.finalprojectdts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button btnlihat, btntambah, btnlihatresep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnlihat = findViewById(R.id.btnlihatdata);
        btntambah = findViewById(R.id.btntambahdata);
        btnlihatresep = findViewById(R.id.btnlihatresep);

        btnlihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, RecyclerViewMakanan.class);
                startActivity(i);
            }
        });

        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, Tambahmakan.class);
                startActivity(i);
            }
        });

        btnlihatresep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, Listmakan.class);
                startActivity(i);
            }
        });
    }
}