package pusat.android.makananbekuenak.com.aplikasi_marketer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TampilanPribadi extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan_data_pribadi_form);
    }

    public void btn_info(View view){

        Intent panggil_class = new Intent(getApplicationContext(), EditdataPribadi.class);
        startActivity(panggil_class);
    }
}
