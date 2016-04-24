package pusat.android.makananbekuenak.com.aplikasi_marketer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.text.DecimalFormat;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class Entry_Order extends AppCompatActivity {

    int minteger = 0;

    private String[] Regional_L = { "Jakarta", "Bogor", "Bekasi", "Tanggerang", "Depok" };

    private String[] Distributor_L = {};

    Spinner sp_regional, sp_distributor;
    TextView v_distributor;
    ArrayAdapter<String> adapter_distributor;
    private MyCustomAdapter dataAdapter = null;
    private Double orderTotal = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_order);

        //Generate list View from Arraylist
        displayListView();



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

    private void displayListView() {

        //Array List of row
        ArrayList<ItemEntry_Order> rowList = new ArrayList<ItemEntry_Order>();
        ItemEntry_Order row_1 = new ItemEntry_Order("A01", "Karapao 1", 10.00);
        rowList.add(row_1);
        row_1 = new ItemEntry_Order("A02", "Karapao 2", 20.00);
        rowList.add(row_1);
        row_1 = new ItemEntry_Order("A03", "Karapao 3", 30.00);
        rowList.add(row_1);
        row_1 = new ItemEntry_Order("A04", "Karapao 4", 40.00);
        rowList.add(row_1);

        //create an ArrayAdapter from the String Array
        dataAdapter = new MyCustomAdapter(this, R.layout.list_produk_layout, rowList);
        ListView listView = (ListView) findViewById(R.id.listV_main);
        listView.setAdapter(dataAdapter);
    }

    private class MyCustomAdapter extends ArrayAdapter<ItemEntry_Order> {

        private ArrayList<ItemEntry_Order> rowList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<ItemEntry_Order> rowList) {
            super(context, textViewResourceId, rowList);
            this.rowList = new ArrayList<ItemEntry_Order>();
            this.rowList.addAll(rowList);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            DecimalFormat df = new DecimalFormat("0.00##");
            ItemEntry_Order row_1 = rowList.get(position);

            if (view == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = vi.inflate(R.layout.list_produk_layout, null);
                EditText jumlah = (EditText) view.findViewById(R.id.jumlah);

                jumlah.addTextChangedListener(new MyTextWatcher(view));
                if(position % 2 == 0){
                    view.setBackgroundColor(Color.rgb(238, 233, 233));
                }
            }

            EditText jumlah = (EditText) view.findViewById(R.id.jumlah);
            jumlah.setTag(row_1);
            if(row_1.getJumlah() != 0){
                jumlah.setText(String.valueOf(row_1.getJumlah()));
            }
            else {
                jumlah.setText("");
            }

            TextView kd_produk = (TextView) view.findViewById(R.id.kd_produk);
            kd_produk.setText(row_1.getKd_produk());

            TextView nama_produk = (TextView) view.findViewById(R.id.nama_produk);
            nama_produk.setText(row_1.getNama_produk());

            TextView price = (TextView) view.findViewById(R.id.price);
            price.setText("$" + df.format(row_1.getPrice()));

            TextView ext = (TextView) view.findViewById(R.id.ext);
            if(row_1.getJumlah() != 0){
                ext.setText("$" + df.format(row_1.getExt()));
            }
            else {
                ext.setText("");
            }
            return view;
        }
    }

    private class MyTextWatcher implements TextWatcher{

        private View view;
        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //do nothing
        }
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //do nothing
        }
        public void afterTextChanged(Editable s) {
            DecimalFormat df = new DecimalFormat("0.00##");
            String jmlString = s.toString().trim();
            int jumlah = jmlString.equals("") ? 0:Integer.valueOf(jmlString);
            EditText jmlView = (EditText) view.findViewById(R.id.jumlah);
            Button Tambah = (Button) view.findViewById(R.id.tambahproduk);
            Tambah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    minteger = minteger + 1;
                    display(minteger);
                }
            });
            ItemEntry_Order row_1 = (ItemEntry_Order) jmlView.getTag();
            if(row_1.getJumlah() != jumlah) {
                Double currPrice = row_1.getExt();
                Double extPrice = jumlah * row_1.getPrice();
                Double priceDiff = Double.valueOf(df.format(extPrice - currPrice));
                row_1.setJumlah(jumlah);
                row_1.setExt(extPrice);
                TextView ext = (TextView) view.findViewById(R.id.ext);
                if(row_1.getJumlah() != 0){ext.setText("$" + df.format(row_1.getExt()));}
                else {ext.setText("");}
                if(row_1.getJumlah() != 0){jmlView.setText(String.valueOf(row_1.getJumlah()));}
                else {jmlView.setText("");}
                orderTotal += priceDiff;
                TextView cariTotal = (TextView) findViewById(R.id.cariTotal);
                cariTotal.setText(df.format(orderTotal));}
        }
        private void display(int number) {
            TextView displayInteger = (TextView) findViewById(
                    R.id.jumlah);
            displayInteger.setText("" + number);

        }
    }
}