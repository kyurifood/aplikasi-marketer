package pusat.android.makananbekuenak.com.aplikasi_marketer;

/**
 * Created by chitoz on 4/21/16.
 */
public class ItemEntry_Order {

    private String kd_produk = "";
    private String nama_produk = "";
    private Double price = 0.00;
    private int jumlah = 0;
    private Double ext = 0.00;
    private boolean selected;

    public ItemEntry_Order(String kd_produk, String nama_produk, Double price){
        super();
        this.kd_produk = kd_produk;
        this.nama_produk = nama_produk;
        this.price = price;
    }

    public String getKd_produk() {
        return kd_produk;
    }

    public void setKd_produk(String kd_produk) {
        this.kd_produk = kd_produk;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Double getExt() {
        return ext;
    }

    public void setExt(Double ext) {
        this.ext = ext;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
