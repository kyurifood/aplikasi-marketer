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

    private String[] Regional_L = { "Jakarta", "Bogor", "Bekasi", "Tanggerang", "Depok" };

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

        adapter_distributor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Distributor_L);

        adapter_distributor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_distributor.setAdapter(adapter_distributor);
        sp_distributor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    String view_regional = (String) sp_regional.getSelectedItem();
                    String view_distributor = (String) sp_distributor.getSelectedItem();

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
                } else if (position == 2) {
                    Distributor_L = new String[]{"-", "Mery", "Fikran", "Satria"};
                } else if (position == 3) {
                    Distributor_L = new String[]{"-", "yetri", "mey", "Angki"};
                } else if (position == 4) {
                    Distributor_L = new String[]{"-", "Iman", "Gilang", "Yanti"};
                } else if (position == 5) {
                    Distributor_L = new String[]{"-", "Melda", "saida", "Budi"};

                }
                adapter_distributor = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_layout, Distributor_L);
                sp_distributor.setAdapter(adapter_distributor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        List<ItemEntry_Order> items = new ArrayList<>();
        ItemEntry_Order item1 = new ItemEntry_Order();
        item1.setKode("001");
        item1.setNama("Karapao 1");
        item1.setPrice(1000);

        ItemEntry_Order item2 = new ItemEntry_Order();
        item2.setKode("002");
        item2.setNama("Karapao 2");
        item2.setPrice(2000);

        ItemEntry_Order item3 = new ItemEntry_Order();
        item3.setKode("003");
        item3.setNama("Karapao 3");
        item3.setPrice(3000);

        items.add(item1);
        items.add(item2);
        items.add(item3);

        ListOrder = (ListView) findViewById(R.id.listV_main);
        adapter = new List_item_order(Entry_Order.this, items);
        ListOrder.setAdapter(adapter);

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