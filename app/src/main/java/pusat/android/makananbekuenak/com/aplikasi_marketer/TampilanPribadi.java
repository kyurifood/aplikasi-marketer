package pusat.android.makananbekuenak.com.aplikasi_marketer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TampilanPribadi extends AppCompatActivity {

    Button edit;

    EditText txtnama, txthp, txtalamat, txtkodepos, txtemail;
    String var_nama, var_hp, var_alamat, var_kodepos, var_email = "";
    String get_nama, get_hp, get_alamat, get_kodepos, get_email = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan_data_pribadi_form);

        txtemail = (EditText) findViewById(R.id.Email);
        txtnama = (EditText) findViewById(R.id.nama);
        txthp = (EditText) findViewById(R.id.nohp);
        txtalamat = (EditText) findViewById(R.id.alamat);
        txtkodepos = (EditText) findViewById(R.id.kodepos);


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
        }
        txtnama.setText("" + get_nama);
        txthp.setText("" + get_hp);
        txtemail.setText("" + get_email);
        txtalamat.setText("" + get_alamat);
        txtkodepos.setText("" + get_kodepos);

        edit = (Button) findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                var_nama = txtnama.getText().toString();
                var_alamat = txtalamat.getText().toString();
                var_email = txtalamat.getText().toString();
                var_hp = txthp.getText().toString();
                var_kodepos = txtkodepos.getText().toString();

                Intent i = null;
                i = new Intent(TampilanPribadi.this, EditdataPribadi.class);
                Bundle b = new Bundle();
                b.putString("panggil_nama", var_nama);
                b.putString("panggil_email", var_email);
                b.putString("panggil_hp", var_hp);
                b.putString("panggil_alamat", var_alamat);
                b.putString("panggil_kodepos", var_kodepos);
                i.putExtras(b);
                startActivity(i);
            }
        });

    }
}
