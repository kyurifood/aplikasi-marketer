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

public class Entry_Order extends Activity {

    Spinner sp;

    Button cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_order);
        sp = (Spinner)
                findViewById(R.id.spinner);

        cart = (Button)findViewById(R.id.btn_ok);


        //untuk membuat list regional
        List<String> item = new ArrayList<String>();
        item.add("----Pilih Regional----");
        item.add("Pilihan 1");
        item.add("Pilihan 2");
        item.add("Pilihan 3");
        item.add("Pilihan 4");
        item.add("Pilihan 5");
        item.add("Pilihan 6");
        item.add("Pilihan 7");
        item.add("Pilihan 8");
        item.add("Pilihan 9");

        //membuat adapter list regional
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (Entry_Order.this,android.R.layout.simple_spinner_dropdown_item, item);

        //menentukan model adapter
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //menentukan adapter pada spinner sp
        sp.setAdapter(adapter);

        //button cek
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Entry_Order2.class);
                startActivity(intent);
            }
        });
    }
}
