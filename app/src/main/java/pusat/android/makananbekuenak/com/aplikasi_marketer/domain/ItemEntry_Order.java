package pusat.android.makananbekuenak.com.aplikasi_marketer.domain;

import java.text.DecimalFormat;

/**
 * Created by chitoz on 4/21/16.
 */
public class ItemEntry_Order {

    private String Kode;
    private String Nama;
    private int jumlah = 0;
    private Double satuan = 0.00;
    private Double price = 0.00;
    private DecimalFormat harga;

    public DecimalFormat getHarga() {
        return harga;
    }

    public void setHarga(DecimalFormat harga) {
        this.harga = harga;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSatuan() {
        return satuan;
    }

    public void setSatuan(Double satuan) {
        this.satuan = satuan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getKode() {
        return Kode;
    }

    public void setKode(String kode) {
        Kode = kode;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }
}
