package org.android.jplas.finalprojectdts.model;

import android.content.Context;
import android.database.Cursor;

import org.android.jplas.finalprojectdts.entity.Makanan;
import org.android.jplas.finalprojectdts.helper.DBHelper;

import java.util.ArrayList;

public class MakananModel {
    private Context context;
    private DBHelper db;

    public MakananModel(Context context) {
        this.context = context;
        this.db = new DBHelper(this.context);
    }
    public void tambahMakanan(Makanan m)
    {
        String namaMakanan = m.getNamaMakanan();
        String kaloriMakanan = m.getKaloriMakanan();

        // Rangkai ke dalam SQL
        // Contoh: INSERT INTO kontak (nama, nomor_telepon) VALUES ('Yoppy', '085-123-456')
        String sql = "INSERT INTO makanan (namaMakanan, kaloriMakanan) VALUES ('" + namaMakanan + "', '" + kaloriMakanan + "')";

        // Langsung lempar ke dbHelper
        this.db.tulisData(sql);
    }

    public void hapusMakanan(Makanan m)
    {
        // Buat SQL untuk hapus
        String sql = "DELETE FROM makanan WHERE id = '" + m.getId() + "'";

        // Panggil db.tulisData(sql)
        db.tulisData(sql);
    }

    public void perbaruiMakanan(Makanan m)
    {
        int id = m.getId();
        String namaMakanan = m.getNamaMakanan();
        String kaloriMakanan = m.getKaloriMakanan();

        // Buat SQL untuk update
        String sql = "UPDATE makanan SET namaMakanan = '" + namaMakanan + "', kaloriMakanan = '" + kaloriMakanan + "' WHERE id = '" + id + "'";

        // Tulis ke DB
        db.tulisData(sql);
    }

    public ArrayList<Makanan> ambilSemuaMakanan()
    {
        String sql = "SELECT * FROM makanan";

        Cursor c = this.db.bacaData(sql);

        // Ubah cursor menjadi ArrayList
        ArrayList<Makanan> hasil = new ArrayList<>();

        if(c.getCount() < 1)
            return hasil;

        c.moveToFirst(); // Pasang di baris ke-1

        do {
            // Mengambil data dari kolom-kolom di tabel sesuai URUTANNYA.
            // Urutannya --> Db Helper saat kita membuat tabel kontak
            int id = c.getInt(0); // Kolom ke-0 INTEGER
            String namaMakanan = c.getString(1); // Kolom ke-1 VARCHAR
            String kaloriMakanan = c.getString(2); // Kolom ke-2 VARCHAR

            Makanan m = new Makanan();
            m.setId(id);
            m.setNamaMakanan(namaMakanan);
            m.setKaloriMakanan(kaloriMakanan);

            // Setiap kontak yang didapat dimasukkan ke ArrayList hasil;
            hasil.add(m);
        }
        while(c.moveToNext());

        return hasil;
    }

    // untuk mencari kontak berdasarkan ID
    public Makanan cariBerdasarkanId(int id)
    {
        String sql = "SELECT * FROM makanan WHERE id = '" + id + "'";

        Cursor c = this.db.bacaData(sql);

        if(c.getCount() > 0)
        {
            c.moveToFirst();

            String namaMakanan = c.getString(1);
            String kaloriMakanan = c.getString(2);

            Makanan m = new Makanan();
            m.setId(id);
            m.setNamaMakanan(namaMakanan);
            m.setKaloriMakanan(kaloriMakanan);

            return m;
        }

        return null;
    }
}
