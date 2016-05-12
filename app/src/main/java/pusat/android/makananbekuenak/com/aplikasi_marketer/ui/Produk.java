package pusat.android.makananbekuenak.com.aplikasi_marketer.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import pusat.android.makananbekuenak.com.aplikasi_marketer.R;
import pusat.android.makananbekuenak.com.aplikasi_marketer.adapter.List_item_order;
import pusat.android.makananbekuenak.com.aplikasi_marketer.adapter.ProdukBaseAdapter;
import pusat.android.makananbekuenak.com.aplikasi_marketer.domain.ProdukItemDetails;

/**
 * Created by gilang on 27/04/16.
 */

public class Produk extends AppCompatActivity {

    private String[] Regional_List = { "Sulawesi", "Jawa", "Sumatera"};

    private String[] Distributor_List = {};

    Spinner regional, distributor;
    ProdukBaseAdapter adapter;
    ArrayAdapter<String> adapter_distributor;
    ListView ListOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(" Produk");
        getSupportActionBar().setLogo(R.drawable.black_ic_shopping_bag);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        System.out.println(Distributor_List);

        regional = (Spinner) findViewById(R.id.sp_reg);
        distributor = (Spinner) findViewById(R.id.sp_dis);

        ArrayList<ProdukItemDetails> image_details = GetSearchResults();

        ListOrder = (ListView) findViewById(R.id.listV_main);
        adapter = new ProdukBaseAdapter(Produk.this, image_details);
        ListOrder.setAdapter(adapter);

        ArrayAdapter<String> adapter_regional = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, Regional_List);

        adapter_regional.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        regional.setAdapter(adapter_regional);
        regional.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Distributor_List = new String[]{"-", "angki", "andi", "afni"};
                } else if (position == 1) {
                    Distributor_List = new String[]{"-", "aldhy", "reca", "gilang"};
                } else if (position == 2) {
                    Distributor_List = new String[]{"-", "merlin", "mey", "merry"};
                }
                adapter.getFilter().filter(Regional_List[position]);
                adapter_distributor = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_layout, Distributor_List);
                distributor.setAdapter(adapter_distributor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adapter_distributor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Distributor_List);

        adapter_distributor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distributor.setAdapter(adapter_distributor);
        distributor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    adapter.getFilter().filter(distributor.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
        item_details.setS_distributor("angki");
        item_details.setS_regional("");
        results.add(item_details);

        item_details = new ProdukItemDetails();
        item_details.setName("002");
        item_details.setItemDescription("KARAPAO 4B");
        item_details.setPrice("Rp 350.00");
        item_details.setImageNumber(2);
        item_details.setS_distributor("angki");
        item_details.setS_regional("");
        results.add(item_details);

        item_details = new ProdukItemDetails();
        item_details.setName("003");
        item_details.setItemDescription("KARAPAO 6A");
        item_details.setPrice("Rp 350.00");
        item_details.setImageNumber(3);
        item_details.setS_distributor("angki");
        item_details.setS_regional("");
        results.add(item_details);

        item_details = new ProdukItemDetails();
        item_details.setName("004");
        item_details.setItemDescription("KARAPAO 6B");
        item_details.setPrice("Rp 350.00");
        item_details.setImageNumber(1);
        item_details.setS_distributor("angki");
        item_details.setS_regional("");
        results.add(item_details);

        item_details = new ProdukItemDetails();
        item_details.setName("004");
        item_details.setItemDescription("KARAPAO 6B");
        item_details.setPrice("Rp 350.00");
        item_details.setImageNumber(1);
        item_details.setS_distributor("andi");
        item_details.setS_regional("");
        results.add(item_details);

        item_details = new ProdukItemDetails();
        item_details.setName("004");
        item_details.setItemDescription("KARAPAO 6B");
        item_details.setPrice("Rp 350.00");
        item_details.setImageNumber(2);
        item_details.setS_distributor("andi");
        item_details.setS_regional("");
        results.add(item_details);

        item_details = new ProdukItemDetails();
        item_details.setName("004");
        item_details.setItemDescription("KARAPAO 6B");
        item_details.setPrice("Rp 350.00");
        item_details.setImageNumber(3);
        item_details.setS_distributor("andi");
        item_details.setS_regional("");
        results.add(item_details);

        item_details = new ProdukItemDetails();
        item_details.setName("004");
        item_details.setItemDescription("KARAPAO 6B");
        item_details.setPrice("Rp 350.00");
        item_details.setImageNumber(4);
        item_details.setS_distributor("afni");
        item_details.setS_regional("");
        results.add(item_details);

        return results;
    }
}