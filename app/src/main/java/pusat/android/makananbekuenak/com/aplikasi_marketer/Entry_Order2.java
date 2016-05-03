package pusat.android.makananbekuenak.com.aplikasi_marketer;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_marketer.adapter.ListItem;
import pusat.android.makananbekuenak.com.aplikasi_marketer.domain.Item;

public class Entry_Order2 extends AppCompatActivity {

    private String[] Provinsi_List = {"Gorontalo", "Palu", "Makasar"};
    private String[] Kabupaten_List = {};
    private String[] Kecamatan_List = {};
    private String[] Kelurahan_List = {};

    ListView lvItem;
    Spinner L_Provinsi, L_Kabupaten, L_Kecamatan, L_Kelurahan;
    ArrayAdapter<String> adapter_kabupaten, adapter_kecamatan, adapter_kelurahan;
    AlertDialog.Builder addNewItemDialogBuilder = null;
    AlertDialog addNewItemDialog = null;
    View promptsView;

    private Spinner spinnerbank;


    EditText txt_namacostumer, txt_nocostumer,txt_namapenerima, txtrek, txtpemilik, txtcabang, txt_nopenerima,txt_alamat, txt_kodepos;
    String get_namacostumer, get_nocostumer, get_namapenerima, get_nopenerima, get_alamat, get_kodepos, get_provinsi, get_kabupaten, get_kecamatan, get_kelurahan;
    String var_namacostumer, var_nocostumer, var_namapenerima, var_nopenerima, var_alamat, var_kodepos, var_provinsi, var_kabupaten, var_kecamatan, var_kelurahan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_order_2_2);

        System.out.println(Kabupaten_List);
        System.out.println(Kecamatan_List);
        System.out.println(Kelurahan_List);

        txt_namacostumer = (EditText) findViewById(R.id.nama_costumer);
        txt_nocostumer = (EditText) findViewById(R.id.no_penerima);
        txt_namapenerima = (EditText) findViewById(R.id.nama_penerima);
        txt_nopenerima = (EditText) findViewById(R.id.no_penerima);
        txt_alamat = (EditText) findViewById(R.id.alamat);
        txt_kodepos = (EditText) findViewById(R.id.kodepos);

        L_Provinsi = (Spinner) findViewById(R.id.spin_provinsi);
        L_Kabupaten = (Spinner) findViewById(R.id.spin_kabupaten);
        L_Kecamatan = (Spinner) findViewById(R.id.spin_kecamatan);
        L_Kelurahan = (Spinner) findViewById(R.id.spin_kelurahan);

        ArrayAdapter<String> adapter_provinsi = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, Provinsi_List);
        adapter_provinsi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        L_Provinsi.setAdapter(adapter_provinsi);
        L_Provinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    (Kabupaten_List) = new String[]{"-", "Gorontalo", "Gorut", "Bone Bolango"};

                } else if (position == 1) {
                    Kabupaten_List = new String[]{"-", "palu kab", "palu kab 2", "palu kab 3"};

                } else if (position == 2) {
                    Kabupaten_List = new String[]{"-", "Mak kab", "Mak kab 2", "Mak kab 3"};
                }

                adapter_kabupaten = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_layout, Kabupaten_List);
                L_Kabupaten.setAdapter(adapter_kabupaten);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adapter_kabupaten = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_layout, Kabupaten_List);
        L_Kabupaten.setAdapter(adapter_kabupaten);
        L_Kabupaten.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    Kecamatan_List = new String[]{"-", "Limboto", "Limboto Barat", "Tibawa"};

                } else if (position == 2) {
                    Kecamatan_List = new String[]{"-", "Kec Palu 1", "Keca Palu 2", "Kec Palu 3"};

                } else if (position == 3) {
                    Kecamatan_List = new String[]{"-", "Kec Makasar 1", "Kec Makasar 2", "Kec Makasar 3"};

                } else if (position == 0) {
                    Kecamatan_List = new String[]{};
                }

                adapter_kecamatan = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_layout, Kecamatan_List);
                L_Kecamatan.setAdapter(adapter_kecamatan);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adapter_kecamatan = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_layout, Kecamatan_List);
        L_Kecamatan.setAdapter(adapter_kecamatan);
        L_Kecamatan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    Kelurahan_List = new String[]{"-", "Hutuo", "Hepuhulawa", "Dutulanaa"};

                } else if (position == 2) {
                    Kelurahan_List = new String[]{"-", "Isimu", "Isimu 2", "Isimu 3"};

                } else if (position == 3) {
                    Kelurahan_List = new String[]{"-", "Kel 1", "Kel 2", "Kel 3"};

                } else if (position == 0) {
                    Kelurahan_List = new String[]{};
                }
                adapter_kelurahan = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_layout, Kelurahan_List);
                L_Kelurahan.setAdapter(adapter_kelurahan);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        lvItem = (ListView) findViewById(R.id.lv_item);
//
//        lvItem.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                v.getParent().requestDisallowInterceptTouchEvent(true);
//                return false;
//            }
//        });
//
//        Button addNewItem = (Button) findViewById(R.id.btnbank);
//        addNewItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showAddDialog();
//            }
//        });

//        Bundle b = getIntent().getExtras();
//        get_namacostumer = b.getString("panggil_namacostumer");
//        get_nocostumer = b.getString("panggil_nocostumer");
//        get_namapenerima = b.getString("panggil_namapenerima");
//        get_nopenerima = b.getString("panggil_nopenerima");
//        get_alamat = b.getString("panggil_alamat");
//        get_provinsi = b.getString("panggil_provinsi");
//        get_kabupaten = b.getString("panggil_kabupaten");
//        get_kecamatan = b.getString("panggil_kecamatan");
//        get_kelurahan = b.getString("panggil_kelurahan");
//        get_kodepos = b.getString("panggil_kodepos");

//        txt_namacostumer.setText("" + get_namacostumer);
//        txt_nocostumer.setText("" + get_nocostumer);
//        txt_namapenerima.setText("" + get_namapenerima);
//        txt_nopenerima.setText("" + get_nopenerima);
//        txt_alamat.setText("" + get_alamat);
//        txt_kodepos.setText("" + get_kodepos);

    }

//    public void showAddDialog() {
//        if (addNewItemDialogBuilder == null) {
//            addNewItemDialogBuilder = new AlertDialog.Builder(Entry_Order2.this, R.style.DialogStyle);
//        }
//
//        promptsView = LayoutInflater.from(Entry_Order2.this).inflate(R.layout.tambah_bank, null);
//
//
//        final Spinner mSpinner = (Spinner) promptsView.findViewById(R.id.spinnerbank);
//        txtrek = (EditText) promptsView.findViewById(R.id.editText);
//        txtpemilik = (EditText) promptsView.findViewById(R.id.editText2);
//        txtcabang = (EditText) promptsView.findViewById(R.id.editText3);
//        spinnerbank = (Spinner) promptsView.findViewById(R.id.spinnerbank);
//
//        mSpinner.setOnItemSelectedListener(new OnSpinnerItemClicked());
//
//
//        Button save = (Button) promptsView.findViewById(R.id.ok);
//        save.setOnClickListener(new View.OnClickListener()

//        {
//            @Override
//            public void onClick(View v) {
//                if (!hasError()) {
//                    Item item = new Item();
//                    String s = (String) (spinnerbank.getSelectedItem());
//                    item.setBank(s);
//                    item.setRekening(txtrek.getText().toString());
//                    item.setPemilik(txtpemilik.getText().toString());
//                    item.setCabang(txtcabang.getText().toString());
//
//                    if (adapter == null) {
//                        items.add(item);
//                        adapter = new ListItem(EditdataPribadi.this, items);
//                        lvItem.setAdapter(adapter);
//                    } else {
//                        adapter.addItem(item);
//                    }
//                    addNewItemDialog.dismiss();
//                }
//            }
//        });

//        Button cancel = (Button) promptsView.findViewById(R.id.cancel);
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addNewItemDialog.dismiss();
//            }
//        });
//
//        addNewItemDialogBuilder.setView(promptsView);
//        addNewItemDialogBuilder.setCancelable(false);
//        addNewItemDialog = addNewItemDialogBuilder.create();
//        addNewItemDialog.show();

    private void submitForm() {
        // Submit your form here. your form is valid
        var_namacostumer = txt_namacostumer.getText().toString();
        var_nocostumer = txt_nocostumer.getText().toString();
        var_namapenerima = txt_namapenerima.getText().toString();
        var_nopenerima = txt_nopenerima.getText().toString();
        var_alamat = txt_alamat.getText().toString();
        var_kodepos = txt_kodepos.getText().toString();
        var_provinsi = L_Provinsi.getSelectedItem().toString();
        var_kabupaten = L_Kabupaten.getSelectedItem().toString();
        var_kecamatan = L_Kecamatan.getSelectedItem().toString();
        var_kelurahan = L_Kelurahan.getSelectedItem().toString();

        Intent parsing = null;
        parsing = new Intent(Entry_Order2.this, Entry_Order3.class);
        Bundle bb = new Bundle();
        bb.putString("panggil_namacostumer", var_namacostumer);
        bb.putString("panggil_nocostumer", var_nocostumer);
        bb.putString("panggil_namapenerima", var_namapenerima);
        bb.putString("panggil_nopenerima", var_nopenerima);
        bb.putString("panggil_alamat", var_alamat);
        bb.putString("panggil_kodepos", var_kodepos);
        bb.putString("panggil_provinsi", var_provinsi);
        bb.putString("panggil_kabupaten", var_kabupaten);
        bb.putString("panggil_kecamatan", var_kecamatan);
        bb.putString("panggil_kelurahan", var_kelurahan);
        parsing.putExtras(bb);
        startActivity(parsing);
        Toast.makeText(Entry_Order2.this, "Update Data Pribadi berhasil", Toast.LENGTH_SHORT).show();
    }

    public boolean validateNamaCostumer(String namacostumer) {
        return namacostumer.length() > 0;
    }

    public boolean validateNoCostumer(String nocostumer) {
        return nocostumer.length() > 0;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.btn_next){

            String namacostumer = txt_namacostumer.getText().toString();
            String nocostumer = txt_nocostumer.getText().toString();
            String namapenerima = txt_namapenerima.getText().toString();
            String nopenerima = txt_nopenerima.getText().toString();
            String alamat = txt_alamat.getText().toString();
            String kodepos = txt_kodepos.getText().toString();



            if (!validateNamaCostumer(namacostumer)) {
                txt_namacostumer.setError("silahkan masukan nama anda");
                {
                    Toast.makeText(Entry_Order2.this, "Kesalahan dalam pengisian nama", Toast.LENGTH_SHORT).show();
                }

            } else if (!validateNoCostumer(nocostumer)) {
                txt_nocostumer.setError("silahkan masukan Nomor Anda");
                {
                    Toast.makeText(Entry_Order2.this, "Kesalahan dalam pengisian Nomor Costumer", Toast.LENGTH_SHORT).show();
                }

            } else submitForm();
            return true;
        }

        if (id == R.id.reset) {

        }

        return super.onOptionsItemSelected(item);
    }
}