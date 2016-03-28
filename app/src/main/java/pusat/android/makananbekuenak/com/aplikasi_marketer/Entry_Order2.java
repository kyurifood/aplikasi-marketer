package pusat.android.makananbekuenak.com.aplikasi_marketer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Entry_Order2 extends Activity {

    Spinner prov, kec, kel, bank;

    Button proses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_order_2);
        prov = (Spinner)
                findViewById(R.id.spinner2);
        kec = (Spinner)
                findViewById(R.id.spinner3);
        kel = (Spinner)
                findViewById(R.id.spinner4);
        bank = (Spinner)
                findViewById(R.id.spinner5);

        proses = (Button)findViewById(R.id.btn_proses);

        //untuk membuat list provinsi/kabupaten
        List<String> item = new ArrayList<String>();
        item.add("---Pilih Kota---");
        item.add("Gorontalo");
        item.add("Palu");
        item.add("Manado");
        item.add("Makassar");
        item.add("Jakarta");
        item.add("Surabaya");
        item.add("Bali");
        item.add("Ambon");

        //untuk membuat list kecamatan
        List<String> item2 = new ArrayList<String>();
        item2.add("---Pilih Kecamatan---");
        item2.add("Kecamatan 1");
        item2.add("Kecamatan 2");
        item2.add("Kecamatan 3");
        item2.add("Kecamatan 4");
        item2.add("Kecamatan 5");
        item2.add("Kecamatan 6");
        item2.add("Kecamatan 7");
        item2.add("Kecamatan 8");

        //untuk membuat list kelurahan
        List<String> item3 = new ArrayList<String>();
        item3.add("---Pilih Kelurahan---");
        item3.add("Kelurahan 1");
        item3.add("Kelurahan 2");
        item3.add("Kelurahan 3");
        item3.add("Kelurahan 4");
        item3.add("Kelurahan 5");
        item3.add("Kelurahan 6");
        item3.add("Kelurahan 7");
        item3.add("Kelurahan 8");

        //untuk membuat list bank
        List<String> item4 = new ArrayList<String>();
        item4.add("Pilih...");
        item4.add("BRI");
        item4.add("MUAMALAT");
        item4.add("BCA");
        item4.add("BNI");

        //membuat adapter list provinsi/kabupaten
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (Entry_Order2.this,android.R.layout.simple_spinner_dropdown_item, item);

        //menentukan model adapter
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //membuat adapter list kecamatan
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                (Entry_Order2.this,android.R.layout.simple_spinner_dropdown_item, item2);

        //menentukan model adapter2
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //membuat adapter list kelurahan
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>
                (Entry_Order2.this,android.R.layout.simple_spinner_dropdown_item, item3);

        //menentukan model adapter2
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //membuat adapter list kelurahan
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>
                (Entry_Order2.this,android.R.layout.simple_spinner_dropdown_item, item4);

        //menentukan model adapter2
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //menentukan adapter, adapter2, adapter3, adapter4 pada spinner prov kec kel bank
        prov.setAdapter(adapter);
        kec.setAdapter(adapter2);
        kel.setAdapter(adapter3);
        bank.setAdapter(adapter4);

        proses.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Entry_Order3.class);
                startActivity(intent);
            }
        });
    }
}
