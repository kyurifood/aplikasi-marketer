package pusat.android.makananbekuenak.com.aplikasi_marketer.domain;

/**
 * Created by rnl on 4/20/16.
 */

public class Item_pesanan {
    private String no_order;
    private String tanggal_pesan;
    private String nama;
    private String bank;
    private String nominal;
    private boolean selected;
    private boolean button;

    public String getNo_order() {
        return no_order;
    }

    public void setNo_order(String no_order) {
        this.no_order = no_order;
    }

    public String getTanggal_pesan() {
        return tanggal_pesan;
    }

    public void setTanggal_pesan(String tanggal_pesan) {
        this.tanggal_pesan = tanggal_pesan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isButton() {
        return button;
    }

    public void setButton(boolean button) {
        this.button = button;
    }
}
