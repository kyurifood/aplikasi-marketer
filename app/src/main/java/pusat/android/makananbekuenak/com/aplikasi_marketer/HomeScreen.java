package pusat.android.makananbekuenak.com.aplikasi_marketer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import pusat.android.makananbekuenak.com.aplikasi_marketer.Pengaturan;

public class HomeScreen extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
<<<<<<< HEAD:app/src/main/java/pusat/android/makananbekuenak/com/aplikasi_marketer/HomeScreen.java




    }

    //--Pengaturan--
    public void btn_pengaturan(View v) {

        Intent panggil_class = new Intent(this, pusat.android.makananbekuenak.com.aplikasi_marketer.Pengaturan.class);
        startActivity(panggil_class);
    }

    //--Laporan--
    public void btn_laporan(View v) {

        Intent panggil_class = new Intent(this, pusat.android.makananbekuenak.com.aplikasi_marketer.Laporan.class);
        startActivity(panggil_class);
=======
        Button pengaturan = (Button) findViewById(R.id.pengaturan);
        Button pesananan = (Button) findViewById(R.id.pesanan);

        pengaturan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pengaturan.class);
                startActivity(intent);
            }
        });

        pesananan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Entry_Order.class);
                startActivity(intent);
            }
        });

>>>>>>> ca7cd99725aa269d82d601a27e801c34301e8e84:app/src/main/java/pusat/android/makananbekuenak/com/aplikasi_marketer/HomeScreen.java
    }

}