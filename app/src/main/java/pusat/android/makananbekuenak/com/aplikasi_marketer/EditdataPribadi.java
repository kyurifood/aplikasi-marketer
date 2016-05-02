package pusat.android.makananbekuenak.com.aplikasi_marketer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pusat.android.makananbekuenak.com.aplikasi_marketer.adapter.ListItem;
import pusat.android.makananbekuenak.com.aplikasi_marketer.EditdataPribadi.OnSpinnerItemClicked;
import pusat.android.makananbekuenak.com.aplikasi_marketer.adapter.ListItem;
import pusat.android.makananbekuenak.com.aplikasi_marketer.domain.Item;

public class EditdataPribadi extends AppCompatActivity {

    private String[] Regional_List = {"sulawesi","bogor","DkiJakarta"};
    private String[] Provinsi_List = {};
    private String[] Kecamatan_List = {};
    private String[] Kelurahan_List = {};

    ListView lvItem;
    ListItem adapter;
    Spinner L_Regional, L_Propinsi, L_Kecamatan, L_Kelurahan;
    ArrayAdapter<String> adapter_propinsi, adapter_kecamatan, adapter_kelurahan;
    AlertDialog.Builder addNewItemDialogBuilder = null;
    AlertDialog addNewItemDialog = null;
    View promptsView;

    private Spinner spinnerbank;

    EditText txtnama, txthp, txtalamat, txtkodepos, txtemail, txtrek, txtpemilik, txtcabang, txtwa, txtpinbb;
    String get_nama, get_hp, get_alamat, get_kodepos, get_email, get_rek, get_pemilik, get_cabang, get_wa, get_pinbb, get_regional, get_provinsi, get_kecamatan, get_kelurahan;
    String var_nama, var_hp, var_alamat, var_kodepos, var_email, var_rek, var_pemilik, var_cabang, var_wa, var_pinbb, var_regional, var_provinsi, var_kecamatan, var_kelurahan;

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;


    List<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editdatapribadi);

        getSupportActionBar().setTitle("Edit Data Pribadi");

        System.out.println(Provinsi_List);
        System.out.println(Kecamatan_List);
        System.out.println(Kelurahan_List);



        txtnama = (EditText) findViewById(R.id.editnama);
        txthp = (EditText) findViewById(R.id.edithp);
        txtalamat = (EditText) findViewById(R.id.editalamat);
        txtkodepos = (EditText) findViewById(R.id.editkodepos);
        txtemail = (EditText) findViewById(R.id.editemail);
        txtwa = (EditText) findViewById(R.id.editwa);
        txtpinbb = (EditText) findViewById(R.id.editbb);

        L_Regional = (Spinner) findViewById(R.id.spinregional);
        L_Kecamatan = (Spinner) findViewById(R.id.spinkec);
        L_Kelurahan = (Spinner) findViewById(R.id.spinkel);
        L_Propinsi = (Spinner) findViewById(R.id.spinprov);

        ArrayAdapter<String> adapter_regional = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, Regional_List);
        adapter_regional.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        L_Regional.setAdapter(adapter_regional);
        L_Regional.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    (Provinsi_List) = new String[]{"-", "Gorontalo", "Makassar", "Kendari"};

                }else if (position == 1){
                    Provinsi_List = new  String[]{"-","1","2","3"};
                }else if (position == 2){
                    Provinsi_List = new  String[]{"-","4","5","6"};
                }
                adapter_propinsi = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_layout, Provinsi_List);
                L_Propinsi.setAdapter(adapter_propinsi);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adapter_propinsi = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_layout, Provinsi_List);
        L_Propinsi.setAdapter(adapter_propinsi);
        L_Propinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    Kecamatan_List = new String[]{"-", "Tibawa", "Paguyama", "Tolinggula"};

                } else if (position == 2) {
                    Kecamatan_List = new String[]{"-", "makassar1", "makassar2", "Makassar3"};

                } else if (position == 3) {
                    Kecamatan_List = new String[]{"-", "Kendari1", "kendari2", "Kendari3"};

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
                    Kelurahan_List = new String[]{"-", "Tibawa kel", "Tibawa kel2", "Tibawa kel3"};

                } else if (position == 2) {
                    Kelurahan_List = new String[]{"-", "paguyaman kel1", "paguyaman kel2", "paguyaman kel3"};

                } else if (position == 3) {
                    Kelurahan_List = new String[]{"-", "Tolinggula Kel", "Tolinggula Kel2", "Tolinggula Kel3"};

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


        lvItem = (ListView) findViewById(R.id.lv_item);

        lvItem.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        Button addNewItem = (Button) findViewById(R.id.btnbank);
        addNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddDialog();
            }
        });

        Bundle b = getIntent().getExtras();
        get_nama = b.getString("panggilnama");
        get_email = b.getString("panggilemail");
        get_hp = b.getString("panggilhp");
        get_alamat = b.getString("panggilalamat");
        get_kodepos = b.getString("panggilkodepos");
        get_email = b.getString("panggilemail");
        get_wa = b.getString("panggilwa");
        get_pinbb = b.getString("panggilpinbb");
        get_regional = b.getString("panggilregional");
        get_provinsi = b.getString("panggilprovinsi");
        get_kecamatan =b.getString("panggilkecamatan");
        get_kelurahan =b.getString("panggilkecamatan");


        txtnama.setText("" + get_nama);
        txtemail.setText("" + get_email);
        txthp.setText("" + get_hp);
        txtkodepos.setText("" + get_kodepos);
        txtemail.setText("" + get_email);
        txtalamat.setText("" + get_alamat);
        txtwa.setText("" + get_wa);
        txtpinbb.setText("" + get_pinbb);

    }

    public void showAddDialog() {
        if (addNewItemDialogBuilder == null) {
            addNewItemDialogBuilder = new AlertDialog.Builder(EditdataPribadi.this, R.style.DialogStyle);
        }

        promptsView = LayoutInflater.from(EditdataPribadi.this).inflate(R.layout.tambah_bank, null);


        final Spinner mSpinner = (Spinner) promptsView.findViewById(R.id.spinnerbank);
        txtrek = (EditText) promptsView.findViewById(R.id.editText);
        txtpemilik = (EditText) promptsView.findViewById(R.id.editText2);
        txtcabang = (EditText) promptsView.findViewById(R.id.editText3);
        spinnerbank = (Spinner) promptsView.findViewById(R.id.spinnerbank);

        mSpinner.setOnItemSelectedListener(new OnSpinnerItemClicked());


        Button save = (Button) promptsView.findViewById(R.id.ok);
        save.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (!hasError()) {
                    Item item = new Item();
                    String s = (String) (spinnerbank.getSelectedItem());
                    item.setBank(s);
                    item.setRekening(txtrek.getText().toString());
                    item.setPemilik(txtpemilik.getText().toString());
                    item.setCabang(txtcabang.getText().toString());

                    if (adapter == null) {
                        items.add(item);
                        adapter = new ListItem(EditdataPribadi.this, items);
                        lvItem.setAdapter(adapter);
                    } else {
                        adapter.addItem(item);
                    }
                    addNewItemDialog.dismiss();
                }
            }
        });

        Button cancel = (Button) promptsView.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewItemDialog.dismiss();
            }
        });

        addNewItemDialogBuilder.setView(promptsView);
        addNewItemDialogBuilder.setCancelable(false);
        addNewItemDialog = addNewItemDialogBuilder.create();
        addNewItemDialog.show();
    }

    public void showEditDialog(final int position, Item item) {
        if (addNewItemDialogBuilder == null) {
            addNewItemDialogBuilder = new AlertDialog.Builder(EditdataPribadi.this, R.style.DialogStyle);        }

        promptsView = LayoutInflater.from(EditdataPribadi.this).inflate(R.layout.tambah_bank, null);

        Spinner mSpinner = (Spinner) promptsView.findViewById(R.id.spinnerbank);
        txtrek = (EditText) promptsView.findViewById(R.id.editText);
        txtrek.setText(item.getRekening());
        txtpemilik = (EditText) promptsView.findViewById(R.id.editText2);
        txtpemilik.setText(item.getPemilik());
        txtcabang = (EditText) promptsView.findViewById(R.id.editText3);
        txtcabang.setText(item.getCabang());
        spinnerbank = (Spinner) promptsView.findViewById(R.id.spinnerbank);
        String s = (String) (spinnerbank.getSelectedItem());
        item.setBank(s);

        mSpinner.setOnItemSelectedListener(new OnSpinnerItemClicked());


        Button save = (Button) promptsView.findViewById(R.id.ok);
        save.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (!hasError()) {
                    Item item = new Item();
                    String s = (String) (spinnerbank.getSelectedItem());
                    item.setBank(s);
                    item.setRekening(txtrek.getText().toString());
                    item.setPemilik(txtpemilik.getText().toString());
                    item.setCabang(txtcabang.getText().toString());

                    if (adapter == null) {
                        items.add(item);
                        adapter = new ListItem(EditdataPribadi.this, items);
                        lvItem.setAdapter(adapter);
                    } else {
                        adapter.addItem(item);
                    }
                    addNewItemDialog.dismiss();
                }
            }
        });

        Button cancel = (Button) promptsView.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewItemDialog.dismiss();
            }
        });

        addNewItemDialogBuilder.setView(promptsView);
        addNewItemDialogBuilder.setCancelable(false);
        addNewItemDialog = addNewItemDialogBuilder.create();
        addNewItemDialog.show();
    }


    private void submitForm() {
        // Submit your form here. your form is valid
        var_nama = txtnama.getText().toString();
        var_email = txtemail.getText().toString();
        var_alamat = txtalamat.getText().toString();
        var_hp = txthp.getText().toString();
        var_kodepos = txtkodepos.getText().toString();
        var_wa = txtwa.getText().toString();
        var_pinbb = txtpinbb.getText().toString();
        var_regional = L_Regional.getSelectedItem().toString();
        var_provinsi = L_Propinsi.getSelectedItem().toString();
        var_kecamatan = L_Kecamatan.getSelectedItem().toString();
        var_kelurahan = L_Kelurahan.getSelectedItem().toString();
        var_rek = txtrek.getText().toString();
        var_pemilik = txtpemilik.getText().toString();
        var_cabang = txtcabang.getText().toString();

        Intent parsing = null;
        parsing = new Intent(EditdataPribadi.this, TampilanPribadi.class);
        Bundle bb = new Bundle();
        bb.putString("panggilnama", var_nama);
        bb.putString("panggilemail", var_email);
        bb.putString("panggilhp", var_hp);
        bb.putString("panggilalamat", var_alamat);
        bb.putString("panggilkodepos", var_kodepos);
        bb.putString("panggilwhatsapp", var_wa);
        bb.putString("panggilpinbb", var_pinbb);
        bb.putString("panggilregional", var_regional);
        bb.putString("panggilprovinsi", var_provinsi);
        bb.putString("panggilkecamatan", var_kecamatan);
        bb.putString("panggilkelurahan", var_kelurahan);
        bb.putString("panggilrek", var_rek);
        bb.putString("panggilpemilik", var_pemilik);
        bb.putString("panggilcabang", var_cabang);
        parsing.putExtras(bb);
        startActivity(parsing);
        Toast.makeText(EditdataPribadi.this, "Update Data Pribadi berhasil", Toast.LENGTH_SHORT).show();

    }

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validateNama(String nama) {
        return nama.length() > 0;
    }

    public boolean validateHp(String hp) {
        return hp.length() > 0;
    }

    public boolean validateAlamat(String alamat) {
        return alamat.length() > 0;
    }

    public boolean validateKodepos(String kodepos) {
        return kodepos.length() > 0;
    }


    public boolean validateWhatApp(String WhasApp) {
        return WhasApp.length() > 0;
    }

    public boolean validatePinbbm(String PinBBM) {
        return PinBBM.length() > 0;
    }


    private boolean hasError() {
        boolean isError = false;
        if (TextUtils.isEmpty(txtrek.getText().toString())) {
            isError = true;
            txtrek.setError("This field is required");
        }
        if (TextUtils.isEmpty(txtpemilik.getText().toString())) {
            isError = true;
            txtpemilik.setError("This field is required");
        }
        if (TextUtils.isEmpty(txtcabang.getText().toString())) {
            isError = true;
            txtcabang.setError("This field is required");
        }
        return isError;
    }



    public class OnSpinnerItemClicked implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        }
        public void onNothingSelected(AdapterView parent) {
            // Do nothing.
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menuedit_info_pribadi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_pros) {

            String email = txtemail.getText().toString();
            String nama = txtnama.getText().toString();
            String hp = txthp.getText().toString();
            String alamat = txtalamat.getText().toString();
            String kodepos = txtkodepos.getText().toString();
            String editwa = txtwa.getText().toString();
            String editbb = txtpinbb.getText().toString();



            if (!validateNama(nama)) {
                txtnama.setError("silahkan masukan nama anda");
                {
                    Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian nama", Toast.LENGTH_SHORT).show();
                }
            } else if (!validateEmail(email)) {
                txtemail.setError("silahkan masukan email");
                {
                    Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian email", Toast.LENGTH_SHORT).show();
                }
            } else if (!validateHp(hp)) {
                txthp.setError("silahkan masukan nomor hand phone");
                {
                    Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian phone", Toast.LENGTH_SHORT).show();
                }
            } else if (!validateAlamat(alamat)) {
                txtalamat.setError("silahkan masukan alamat anda");
                {
                    Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian alamat", Toast.LENGTH_SHORT).show();
                }
            } else if (!validateKodepos(kodepos)) {
                txtkodepos.setError("silahkan masukan kode pos");
                {
                    Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian kode pos", Toast.LENGTH_SHORT).show();
                }
            } else if (!validateWhatApp(editwa)) {
                txtwa.setError("silahkan masukan No Whatsapp");
                {
                    Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian No Whatsapp", Toast.LENGTH_SHORT).show();
                }

            } else if (!validatePinbbm(editbb)) {
                txtwa.setError("silahkan masukan No BBM Anda");
                {
                    Toast.makeText(EditdataPribadi.this, "Kesalahan dalam pengisian No BBM", Toast.LENGTH_SHORT).show();
                }


            } else submitForm();
            return true;
        }

        if (id == R.id.reset) {

        }

        return super.onOptionsItemSelected(item);
    }

}