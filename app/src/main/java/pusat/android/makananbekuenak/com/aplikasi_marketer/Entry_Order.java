package pusat.android.makananbekuenak.com.aplikasi_marketer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_marketer.adapter.List_item_order;
import pusat.android.makananbekuenak.com.aplikasi_marketer.domain.Item;
import pusat.android.makananbekuenak.com.aplikasi_marketer.domain.ItemEntry_Order;

public class Entry_Order extends AppCompatActivity {

    int tot = 0;

    private String[] Regional_L = { "Sulawesi", "Jawa"};

    private String[] Distributor_L = {};

    Spinner sp_regional, sp_distributor;
    TextView v_distributor;
    ArrayAdapter<String> adapter_distributor;

    List_item_order adapter;
    ListView ListOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_order);

        getSupportActionBar().setTitle("ENTRI PESANAN");

        System.out.println(Distributor_L);

        v_distributor = (TextView) findViewById(R.id.view_distributor);

        sp_regional = (Spinner) findViewById(R.id.spinner_regional);
        sp_distributor = (Spinner) findViewById(R.id.spinner_distributor);
        List<ItemEntry_Order> items = new ArrayList<>();
        ItemEntry_Order item1 = new ItemEntry_Order();
        item1.setKode("001");
        item1.setNama("Karapao 1");
        item1.setPrice(1000);
        item1.setDistributor("tono");
        item1.setRegional("jakarta");

        ItemEntry_Order item2 = new ItemEntry_Order();
        item2.setKode("002");
        item2.setNama("Karapao 2");
        item2.setPrice(2000);
        item2.setDistributor("toni");
        item2.setRegional("jakarta");

        ItemEntry_Order item3 = new ItemEntry_Order();
        item3.setKode("003");
        item3.setNama("Karapao 3");
        item3.setPrice(3000);
        item3.setDistributor("tino");
        item3.setRegional("jakarta");

        ItemEntry_Order item4 = new ItemEntry_Order();
        item4.setKode("004");
        item4.setNama("Karapao 4");
        item4.setPrice(4000);
        item4.setDistributor("aldy");
        item4.setRegional("jawa");

        ItemEntry_Order item5 = new ItemEntry_Order();
        item5.setKode("005");
        item5.setNama("Karapao 5");
        item5.setPrice(5000);
        item5.setDistributor("reca");
        item5.setRegional("jawa");

        ItemEntry_Order item6 = new ItemEntry_Order();
        item6.setKode("006");
        item6.setNama("Karapao 6");
        item6.setPrice(6000);
        item6.setDistributor("gilang");
        item6.setRegional("jawa");

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);

        ListOrder = (ListView) findViewById(R.id.listV_main);
        adapter = new List_item_order(Entry_Order.this, items);
        ListOrder.setAdapter(adapter);

        adapter_distributor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Distributor_L);

        adapter_distributor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_distributor.setAdapter(adapter_distributor);
        sp_distributor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    String view_regional = (String) sp_regional.getSelectedItem();
                    String view_distributor = (String) sp_distributor.getSelectedItem();
                    adapter.getFilter().filter(sp_distributor.getSelectedItem().toString());
                    v_distributor.setText("Pilihan " + view_regional + ". Dan " + view_distributor);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> adapter_regional = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, Regional_L);

        adapter_regional.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_regional.setAdapter(adapter_regional);

        sp_regional.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                v_distributor.setText("");
                if (position == 0) {
                    Distributor_L = new String[]{"-", "tono", "toni", "tino"};
                } else if (position == 1) {
                    Distributor_L = new String[]{"-", "Aldy", "Reca", "Gilang"};
                }
                adapter.getFilter().filter(Regional_L[position]);
                adapter_distributor = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_layout, Distributor_L);
                sp_distributor.setAdapter(adapter_distributor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void cekTotal(final ItemEntry_Order item){
        TextView total = (TextView) findViewById(R.id.cariTotal);
        total.setEnabled(true);
        tot  += item.getSatuan();
        total.setText("Rp." + String.valueOf(tot));
    }

    public void uncekTotal(final ItemEntry_Order item){
        TextView total = (TextView) findViewById(R.id.cariTotal);
        total.setEnabled(true);
        tot  -= item.getSatuan();
        total.setText("Rp." + String.valueOf(tot));
    }
}