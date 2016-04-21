package pusat.android.makananbekuenak.com.aplikasi_marketer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TampilanPribadi extends AppCompatActivity {

    String var_nama, var_email, var_noHp, var_WA, var_BB, var_regional, var_alamat, var_kodePos;
    String get_nama,get_alamat,get_email,get_noHp,get_kodePos,get_WA,get_BB = "";
    TextView t_name, t_email, t_noHp, t_WA, t_BB, t_regional, t_alamat, t_kodePos;
    Button tombol_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan_data_pribadi);

        tombol_edit = (Button) findViewById(R.id.btn_editData);
        t_name = (TextView) findViewById(R.id.nama);
        t_email = (TextView) findViewById(R.id.email);
        t_noHp = (TextView) findViewById(R.id.nohp);
        t_WA= (TextView) findViewById(R.id.whatsapp);
        t_BB = (TextView) findViewById(R.id.pin_bbm);
        t_regional = (TextView) findViewById(R.id.regional);
        t_alamat = (TextView) findViewById(R.id.alamata);
        t_kodePos = (TextView) findViewById(R.id.kodepos);


        Bundle bb = getIntent().getExtras();
        if(bb.getString("panggilnama") != null)
            get_nama = bb.getString("panggilnama");

        if (bb.getString("panggilalamat") != null)
        get_alamat = bb.getString("panggilalamat");

        if (bb.getString("panggilemail") != null)
            get_email = bb.getString("panggilemail");

        if(bb.getString("panggilhp") != null)
            get_noHp = bb.getString("panggilhp");

        if(bb.getString("panggilkodepos") != null)
            get_kodePos = bb.getString("panggilkodepos");

        if(bb.getString("panggilWA") != null)
            get_WA = bb.getString("panggilWA");

        if(bb.getString("panggilBB") != null)
            get_BB = bb.getString("panggilBB");


        t_WA.setText(get_WA);
        t_BB.setText(get_BB);
        t_alamat.setText(get_alamat);
        t_email.setText(get_email);
        t_noHp.setText(get_noHp);
        t_kodePos.setText(get_kodePos);
        t_name.setText(get_nama);

        tombol_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                var_nama = t_name.getText().toString();
                var_email = t_email.getText().toString();
                var_noHp = t_noHp.getText().toString();
                var_WA = t_WA.getText().toString();
                var_BB = t_BB.getText().toString();
                var_regional = t_regional.getText().toString();
                var_alamat = t_alamat.getText().toString();
                var_kodePos = t_kodePos.getText().toString();


                Intent panggil = null;
                panggil = new Intent(TampilanPribadi.this, EditdataPribadi.class);
                Bundle b = new Bundle();
                b.putString("panggil_nama",var_nama);
                b.putString("panggil_email", var_email);
                b.putString("panggil_hp", var_noHp);
                b.putString("panggil_WA", var_WA);
                b.putString("panggil_BB", var_BB);
                b.putString("panggil_regional", var_regional);
                b.putString("panggil_alamat", var_alamat);
                b.putString("panggil_kodePos", var_kodePos);
                panggil.putExtras(b);
                startActivity(panggil);
            }

        });
    }
}
