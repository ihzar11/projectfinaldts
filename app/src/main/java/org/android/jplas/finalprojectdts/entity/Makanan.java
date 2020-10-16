package org.android.jplas.finalprojectdts.entity;

public class Makanan {
    private int id;
    private String namaMakanan;
    private String kaloriMakanan;

    public Makanan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }

    public String getKaloriMakanan() {
        return kaloriMakanan;
    }

    public void setKaloriMakanan(String kaloriMakanan) {
        this.kaloriMakanan = kaloriMakanan;
    }
}
