package pusat.android.makananbekuenak.com.aplikasi_marketer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Entry_Order3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_order_3);
        Button edit_belanja = (Button) findViewById(R.id.button_edit_belanja);
        Button edit_pembeli = (Button) findViewById(R.id.button_edit_pembeli);

        edit_belanja.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Entry_Order.class);
                startActivity(intent);
            }
        });

        edit_pembeli.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Entry_Order2.class);
                startActivity(intent);
            }
        });

    }

}