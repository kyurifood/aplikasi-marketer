package pusat.android.makananbekuenak.com.aplikasi_marketer.domain;

/**
 * Created by gilang on 04/05/16.
 */
public class Bank {
    private String id;
    private String nama;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return nama;
    }
}
