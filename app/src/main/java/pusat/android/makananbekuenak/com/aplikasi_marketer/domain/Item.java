package pusat.android.makananbekuenak.com.aplikasi_marketer.domain;

/**
 * Created by rinaldy on 06/04/16.
 */

public class Item {
    private String bank;
    private String rekening;
    private String pemilik;
    private String cabang;
    private boolean lanjut;

    public boolean isLanjut() {
        return lanjut;
    }

    public void setLanjut(boolean lanjut) {
        this.lanjut = lanjut;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getRekening() {
        return rekening;
    }

    public void setRekening(String rekening) {
        this.rekening = rekening;
    }

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }

    public String getCabang() {
        return cabang;
    }

    public void setCabang(String cabang) {
        this.cabang = cabang;
    }
}
