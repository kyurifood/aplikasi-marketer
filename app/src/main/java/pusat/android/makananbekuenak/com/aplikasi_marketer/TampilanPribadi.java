package pusat.android.makananbekuenak.com.aplikasi_marketer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TampilanPribadi extends AppCompatActivity {

    Button edit, back;

    EditText txtnama, txthp, txtalamat, txtkodepos, txtemail, txtwa, txtpinbb, txtregion, txtprovinsi, txtkecamatan, txtkelurahan, txtrek, txtpemilik, txtcabang;
    String var_nama, var_hp, var_alamat, var_kodepos, var_email, var_wa,var_pinbb, var_region, var_provinsi, var_kecamatan, var_kelurahan,var_rek, var_pemilik, var_cabang = "";
    String get_nama, get_hp, get_alamat, get_kodepos, get_email, get_wa, get_pinbb, get_region, get_provinsi, get_kecamatan, get_kelurahan, get_rek, get_pemilik, get_cabang = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan_data_pribadi_form);

        getSupportActionBar().setTitle("Info Pribadi");

        txtemail = (EditText) findViewById(R.id.Email);
        txtnama = (EditText) findViewById(R.id.nama);
        txthp = (EditText) findViewById(R.id.nohp);
        txtalamat = (EditText) findViewById(R.id.alamat);
        txtkodepos = (EditText) findViewById(R.id.kodepos);
        txtwa = (EditText) findViewById(R.id.whatsapp);
        txtpinbb = (EditText) findViewById(R.id.pinbbm);
        txtregion = (EditText) findViewById(R.id.regiyonal);
        txtprovinsi = (EditText) findViewById(R.id.provinsi);
        txtkecamatan = (EditText) findViewById(R.id.kecamatan);
        txtkelurahan = (EditText) findViewById(R.id.kelurahan);
        txtrek = (EditText) findViewById(R.id.nomorrekening);
        txtpemilik = (EditText) findViewById(R.id.namarekening);
        txtcabang= (EditText) findViewById(R.id.namabank);



        back = (Button) findViewById(R.id.kembali1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent panggil = new Intent(getApplicationContext(), Pengaturan.class);
                startActivity(panggil);
            }
        });


        Bundle bb = getIntent().getExtras();

        if(bb != null) {

            if (bb.containsKey("panggilnama"))
                get_nama = bb.getString("panggilnama");
            if (bb.containsKey("panggilalamat"))
                get_alamat = bb.getString("panggilalamat");
            if (bb.containsKey("panggilemail"))
                get_email = bb.getString("panggilemail");
            if (bb.containsKey("panggilhp"))
                get_hp = bb.getString("panggilhp");
            if (bb.containsKey("panggilkodepos"))
                get_kodepos = bb.getString("panggilkodepos");
            if (bb.containsKey("panggilwhatsapp"))
                get_wa = bb.getString("panggilwhatsapp");
            if (bb.containsKey("panggilpinbb"))
                get_pinbb = bb.getString("panggilpinbb");
            if(bb.containsKey("panggilregional"));
            get_region = bb.getString("panggilregional");
            if(bb.containsKey("panggilprovinsi"));
            get_provinsi = bb.getString("panggilprovinsi");
            if(bb.containsKey("panggilkecamatan"));
            get_kecamatan = bb.getString("panggilkecamatan");
            if(bb.containsKey("panggilkelurahan"));
            get_kelurahan = bb.getString("panggilkelurahan");
            if (bb.containsKey("panggilrek"));
            get_rek = bb.getString("panggilrek");
            if (bb.containsKey("panggilpemilik"));
            get_pemilik = bb.getString("panggilpemilik");
            if (bb.containsKey("panggilcabang"));
            get_cabang = bb.getString("panggilcabang");


        }
        txtnama.setText("" + get_nama);
        txthp.setText("" + get_hp);
        txtemail.setText("" + get_email);
        txtalamat.setText("" + get_alamat);
        txtkodepos.setText("" + get_kodepos);
        txtwa.setText("" + get_wa);
        txtpinbb.setText("" + get_pinbb);
        txtregion.setText("" + get_region);
        txtprovinsi.setText("" + get_provinsi);
        txtkecamatan.setText("" + get_kecamatan);
        txtkelurahan.setText("" + get_kelurahan);
        txtrek.setText("" + get_rek);
        txtpemilik.setText("" + get_pemilik);
        txtcabang.setText("" + get_cabang);

        edit = (Button) findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                var_nama = txtnama.getText().toString();
                var_alamat = txtalamat.getText().toString();
                var_email = txtemail.getText().toString();
                var_hp = txthp.getText().toString();
                var_kodepos = txtkodepos.getText().toString();
                var_wa = txtwa.getText().toString();
                var_pinbb = txtpinbb.getText().toString();
                var_region = txtregion.getText().toString();
                var_provinsi = txtprovinsi.getText().toString();
                var_kecamatan = txtkecamatan.getText().toString();
                var_kelurahan = txtkelurahan.getText().toString();

                Intent i = null;
                i = new Intent(TampilanPribadi.this, EditdataPribadi.class);
                Bundle b = new Bundle();
                b.putString("panggilnama", var_nama);
                b.putString("panggilemail", var_email);
                b.putString("panggilhp", var_hp);
                b.putString("panggilalamat", var_alamat);
                b.putString("panggilkodepos", var_kodepos);
                b.putString("panggilwa", var_wa);
                b.putString("panggilpinbb", var_pinbb);
                b.putString("panggilregional", var_region);
                b.putString("panggilprovinsi", var_provinsi);
                b.putString("panggilkecamatan", var_kecamatan);
                b.putString("panggilkelurahan", var_kelurahan);
                i.putExtras(b);
                startActivity(i);
            }
        });

    }
}

