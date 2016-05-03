package pusat.android.makananbekuenak.com.aplikasi_marketer;

import android.content.Intent;
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

    Button btn_next;

    private String[] Regional_L = { "Sulawesi", "Jawa", "Sumatera"};

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

        btn_next = (Button)findViewById(R.id.btn_next);

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
        item1.setDistributor("angki");
        item1.setRegional("");

        ItemEntry_Order item2 = new ItemEntry_Order();
        item2.setKode("002");
        item2.setNama("Karapao 2");
        item2.setPrice(2000);
        item2.setDistributor("angki");
        item2.setRegional("");

        ItemEntry_Order item3 = new ItemEntry_Order();
        item3.setKode("003");
        item3.setNama("Karapao 3");
        item3.setPrice(3000);
        item3.setDistributor("andi");
        item3.setRegional("");

        ItemEntry_Order item4 = new ItemEntry_Order();
        item4.setKode("004");
        item4.setNama("Karapao 4");
        item4.setPrice(4000);
        item4.setDistributor("andi");
        item4.setRegional("");

        ItemEntry_Order item5 = new ItemEntry_Order();
        item5.setKode("005");
        item5.setNama("Karapao 5");
        item5.setPrice(5000);
        item5.setDistributor("andi");
        item5.setRegional("");

        ItemEntry_Order item6 = new ItemEntry_Order();
        item6.setKode("006");
        item6.setNama("Karapao 6");
        item6.setPrice(6000);
        item6.setDistributor("andi");
        item6.setRegional("");

        ItemEntry_Order item7 = new ItemEntry_Order();
        item7.setKode("007");
        item7.setNama("Karapao 7");
        item7.setPrice(7000);
        item7.setDistributor("afni");
        item7.setRegional("");

        ItemEntry_Order item8 = new ItemEntry_Order();
        item8.setKode("008");
        item8.setNama("Karapao 8");
        item8.setPrice(8000);
        item8.setDistributor("aldhy");
        item8.setRegional("");

        ItemEntry_Order item9 = new ItemEntry_Order();
        item9.setKode("009");
        item9.setNama("Karapao 9");
        item9.setPrice(9000);
        item9.setDistributor("reca");
        item9.setRegional("");

        ItemEntry_Order item10 = new ItemEntry_Order();
        item10.setKode("010");
        item10.setNama("Karapao 10");
        item10.setPrice(10000);
        item10.setDistributor("reca");
        item10.setRegional("");

        ItemEntry_Order item11 = new ItemEntry_Order();
        item11.setKode("011");
        item11.setNama("Karapao 11");
        item11.setPrice(11000);
        item11.setDistributor("reca");
        item11.setRegional("");

        ItemEntry_Order item12 = new ItemEntry_Order();
        item12.setKode("012");
        item12.setNama("Karapao 12");
        item12.setPrice(12000);
        item12.setDistributor("gilang");
        item12.setRegional("");

        ItemEntry_Order item13 = new ItemEntry_Order();
        item13.setKode("0013");
        item13.setNama("Karapao 13");
        item13.setPrice(13000);
        item13.setDistributor("gilang");
        item13.setRegional("");

        ItemEntry_Order item14 = new ItemEntry_Order();
        item14.setKode("0014");
        item14.setNama("Karapao 14");
        item14.setPrice(14000);
        item14.setDistributor("merlin");
        item14.setRegional("");

        ItemEntry_Order item15 = new ItemEntry_Order();
        item15.setKode("0015");
        item15.setNama("Karapao 15");
        item15.setPrice(15000);
        item15.setDistributor("mey");
        item15.setRegional("");

        ItemEntry_Order item16 = new ItemEntry_Order();
        item16.setKode("0016");
        item16.setNama("Karapao 16");
        item16.setPrice(16000);
        item16.setDistributor("merry");
        item16.setRegional("");

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.add(item8);
        items.add(item9);
        items.add(item10);
        items.add(item11);
        items.add(item12);
        items.add(item13);
        items.add(item14);
        items.add(item15);
        items.add(item16);

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
//                    String view_regional = (String) sp_regional.getSelectedItem();
//                    String view_distributor = (String) sp_distributor.getSelectedItem();
                    adapter.getFilter().filter(sp_distributor.getSelectedItem().toString());
//                    v_distributor.setText("Pilihan " + view_regional + ". Dan " + view_distributor);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(Entry_Order.this,
                        Entry_Order2.class);
                startActivity(myIntent);
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
                    Distributor_L = new String[]{"-", "angki", "andi", "afni"};
                } else if (position == 1) {
                    Distributor_L = new String[]{"-", "aldhy", "reca", "gilang"};
                } else if (position == 2) {
                    Distributor_L = new String[]{"-", "merlin", "mey", "merry"};
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