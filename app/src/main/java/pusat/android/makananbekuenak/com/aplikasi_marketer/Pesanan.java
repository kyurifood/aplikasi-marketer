package pusat.android.makananbekuenak.com.aplikasi_marketer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by gilang on 18/04/16.
 */
public class Pesanan extends AppCompatActivity {

    private Button btn_order, btn_enrty;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_pesanan);

            getSupportActionBar().setTitle(" PESANAN");
            getSupportActionBar().setLogo(R.drawable.black_ic_trolley);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            btn_order = (Button) findViewById(R.id.sts_order);

            btn_order.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });

            btn_enrty = (Button) findViewById(R.id.entry_pesan);

            btn_enrty.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), Entry_Order.class);
                    startActivity(intent);
                }
            });
    }
}
