package pusat.android.makananbekuenak.com.aplikasi_marketer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Entry_Order extends Activity {

    private String[] Regional_L = { "Jakarta", "Bogor", "Bekasi", "Tanggerang", "Depok" };

    private String[] Distributor_L = {};

    Spinner sp_regional, sp_distributor;
    TextView v_distributor;
    ArrayAdapter<String> adapter_distributor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_order);
        ArrayList<ItemDetail> image_detail = GetSearchResult();

        final ListView lv1 = (ListView) findViewById(R.id.listV_main);
        lv1.setAdapter(new ItemListBaseAdapter(this, image_detail));
//        lv1.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, GetSearchResult()));
        lv1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv1.setItemChecked(0, true);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                ItemDetail obj_ItemDetail = (ItemDetail) o;
                Toast.makeText(Entry_Order.this, "Anda Memilih : " + " " + obj_ItemDetail.getNama(), Toast.LENGTH_SHORT).show();
            }
        });

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
                if(position > 0){
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

    }

    public  ArrayList<ItemDetail> GetSearchResult() {
        // TODO Auto-generated method stub
        ArrayList<ItemDetail> result = new ArrayList<ItemDetail>();

        //Beri keterangan untuk arrayitem detail
        ItemDetail item_detail = new ItemDetail();
        item_detail.setKode_produk("001");
        item_detail.setNama("Bakpao 1");
        item_detail.setPrice("Rp. 5.000");
        item_detail.setImageNumber(1);
        result.add(item_detail);

        item_detail = new ItemDetail();
        item_detail.setKode_produk("002");
        item_detail.setNama("Bakpao 2");
        item_detail.setPrice("Rp. 5.500");
        item_detail.setImageNumber(2);
        result.add(item_detail);

        item_detail = new ItemDetail();
        item_detail.setKode_produk("003");
        item_detail.setNama("Bakpao 3");
        item_detail.setPrice("Rp. 6.000");
        item_detail.setImageNumber(3);
        result.add(item_detail);

        item_detail = new ItemDetail();
        item_detail.setKode_produk("004");
        item_detail.setNama("Bakpao 4");
        item_detail.setPrice("Rp. 7.000");
        item_detail.setImageNumber(4);
        result.add(item_detail);

        item_detail = new ItemDetail();
        item_detail.setKode_produk("005");
        item_detail.setNama("Bakpao 5");
        item_detail.setPrice("Rp. 5.500");
        item_detail.setImageNumber(5);
        result.add(item_detail);

        item_detail = new ItemDetail();
        item_detail.setKode_produk("006");
        item_detail.setNama("Bakpao 5");
        item_detail.setPrice("Rp. 5.500");
        item_detail.setImageNumber(6);
        result.add(item_detail);

        item_detail = new ItemDetail();
        item_detail.setKode_produk("007");
        item_detail.setNama("Bakpao 5");
        item_detail.setPrice("Rp. 5.500");
        item_detail.setImageNumber(7);
        result.add(item_detail);

        return result;
    }
}