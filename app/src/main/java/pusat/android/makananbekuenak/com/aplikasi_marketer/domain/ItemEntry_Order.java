package pusat.android.makananbekuenak.com.aplikasi_marketer.domain;

import java.text.DecimalFormat;

/**
 * Created by chitoz on 4/21/16.
 */

public class ItemEntry_Order {

    private String Kode;
    private String Nama;
    private int jumlah = 0;
    private DecimalFormat harga;
    private boolean cek;
    private int price;
    private int satuan;
    private String regional;
    private  String distributor;

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public int getSatuan() {
        return satuan;
    }

    public void setSatuan(int satuan) {
        this.satuan = satuan;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isCek() {
        return cek;
    }

    public void setCek(boolean cek) {
        this.cek = cek;
    }

    public DecimalFormat getHarga() {
        return harga;
    }

    public void setHarga(DecimalFormat harga) {
        this.harga = harga;
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
