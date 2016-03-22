package pusat.android.makananbekuenak.com.aplikasi_marketer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Tambah_bank extends AppCompatActivity {
// untuk menampilkan daftar item

    String[] items = {"BRI", "BCA", "MANDIRI"};
    Spinner spin;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_bank);

        // untuk memanggil id selection dan spinner dari file xml
        spin=(Spinner)findViewById(R.id.spinner);

        // untuk menampilkan daftar item
        ArrayAdapter<String> aa=new ArrayAdapter<String>
                (this,     android.R.layout.simple_spinner_item, items);
        aa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        button = (Button) findViewById(R.id.ok);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        "Data Berhasil Disimpan", Toast.LENGTH_LONG).show();

            }
        });
    }

}
