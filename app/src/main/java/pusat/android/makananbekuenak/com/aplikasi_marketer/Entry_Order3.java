package pusat.android.makananbekuenak.com.aplikasi_marketer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Entry_Order3 extends AppCompatActivity {

    String get_custom, get_nama, get_alamat, get_kode, get_propinsi, get_kabupaten, get_kacamatan, get_kelurahan, get_bank;
    String var_custom, var_nama, var_alamat, var_kode;
    EditText customer, nama_penerima, alamat, kodepos, propinsi, kabupaten, kecamatan, kelurahan, bank;
    Button editPembeli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_order_3_3);

        getSupportActionBar().setTitle("Entri Order");

        customer = (EditText) findViewById(R.id.txt_namacost);
        nama_penerima = (EditText) findViewById(R.id.txt_namapenerima);
        alamat = (EditText) findViewById(R.id.txt_alamat);
        kodepos = (EditText) findViewById(R.id.txt_kodepos);
        propinsi = (EditText) findViewById(R.id.txt_provinsi);
        kabupaten = (EditText) findViewById(R.id.txt_kabupaten);
        kecamatan = (EditText) findViewById(R.id.txt_kecamatan);
        kelurahan = (EditText) findViewById(R.id.txt_kelurahan);
        bank = (EditText) findViewById(R.id.txt_bank);

        editPembeli = (Button) findViewById(R.id.edit_costumer);
        editPembeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPembeli();
            }
        });

        Bundle bb = getIntent().getExtras();
        get_custom = bb.getString("panggil_namacostumer");
        get_nama = bb.getString("panggil_namapenerima");
        get_alamat = bb.getString("panggil_alamat");
        get_kode = bb.getString("panggil_kodepos");
        get_propinsi = bb.getString("panggil_provinsi");
        get_kabupaten = bb.getString("panggil_kabupaten");
        get_kelurahan = bb.getString("panggil_kelurahan");
        get_kacamatan = bb.getString("panggil_kecamatan");
        get_bank = bb.getString("panggil_bank");

        customer.setText("" + get_custom);
        nama_penerima.setText("" + get_nama);
        alamat.setText("" + get_alamat);
        kodepos.setText("" + get_kode);
        propinsi.setText("" + get_propinsi);
        kabupaten.setText("" + get_kabupaten);
        kelurahan.setText("" + get_kelurahan);
        kecamatan.setText("" + get_kacamatan);
        bank.setText("" + get_bank);

    }

    public void editPembeli(){

        var_custom = customer.getText().toString();
        var_nama = nama_penerima.getText().toString();
        var_alamat = alamat.getText().toString();
        var_kode = kodepos.getText().toString();

        Intent parsing = null;
        parsing = new Intent(Entry_Order3.this, Entry_Order2.class);
        Bundle b = new Bundle();
        b.putString("panggilcustom", var_custom);
        b.putString("panggilnamapenerima", var_nama);
        b.putString("panggilalamat", var_alamat);
        b.putString("panggilkodepos", var_kode);
        parsing.putExtras(b);
        startActivity(parsing);

    }

}