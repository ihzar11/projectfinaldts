package org.android.jplas.finalprojectdts.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "makan.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE makanan (/*0*/id INTEGER PRIMARY KEY AUTOINCREMENT, /*1*/namaMakanan VARCHAR(255), /*2*/kaloriMakanan VARCHAR(50));";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void tulisData(String sql)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(sql);
    }

    public Cursor bacaData(String sql)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor hasil = db.rawQuery(sql, null);

        return hasil;
    }
}
