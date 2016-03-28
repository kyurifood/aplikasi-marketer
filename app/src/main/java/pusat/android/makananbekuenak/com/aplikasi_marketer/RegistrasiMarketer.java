package pusat.android.makananbekuenak.com.aplikasi_marketer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegistrasiMarketer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrasi_marketer);

        Button btnbank = (Button) findViewById(R.id.btnbank);
        btnbank.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), pusat.android.makananbekuenak.com.aplikasi_marketer.Tambah_bank.class);
                startActivity(intent);
            }
        });


    }
}
