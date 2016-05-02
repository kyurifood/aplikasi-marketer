package pusat.android.makananbekuenak.com.aplikasi_marketer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import pusat.android.makananbekuenak.com.aplikasi_marketer.adapter.ProdukBaseAdapter;
import pusat.android.makananbekuenak.com.aplikasi_marketer.domain.ProdukItemDetails;

/**
 * Created by gilang on 27/04/16.
 */

public class Produk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(" Produk");
        getSupportActionBar().setLogo(R.drawable.black_ic_shopping_bag);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        ArrayList<ProdukItemDetails> image_details = GetSearchResults();

        final ListView lv1 = (ListView) findViewById(R.id.listV_main);
        lv1.setAdapter(new ProdukBaseAdapter(Produk.this, image_details));

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                ProdukItemDetails obj_itemDetails = (ProdukItemDetails) o;
                Toast.makeText(Produk.this, "You have chosen : " + " " + obj_itemDetails.getItemDescription(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private ArrayList<ProdukItemDetails> GetSearchResults(){
        ArrayList<ProdukItemDetails> results = new ArrayList<ProdukItemDetails>();

        ProdukItemDetails item_details = new ProdukItemDetails();
        item_details.setName("001");
        item_details.setItemDescription("KARAPAO 4A");
        item_details.setPrice("Rp 310.00");
        item_details.setImageNumber(4);
        results.add(item_details);

        item_details = new ProdukItemDetails();
        item_details.setName("002");
        item_details.setItemDescription("KARAPAO 4B");
        item_details.setPrice("Rp 350.00");
        item_details.setImageNumber(2);
        results.add(item_details);

        item_details = new ProdukItemDetails();
        item_details.setName("003");
        item_details.setItemDescription("KARAPAO 6A");
        item_details.setPrice("Rp 350.00");
        item_details.setImageNumber(3);
        results.add(item_details);

        item_details = new ProdukItemDetails();
        item_details.setName("004");
        item_details.setItemDescription("KARAPAO 6B");
        item_details.setPrice("Rp 350.00");
        item_details.setImageNumber(1);
        results.add(item_details);

        return results;
    }
}