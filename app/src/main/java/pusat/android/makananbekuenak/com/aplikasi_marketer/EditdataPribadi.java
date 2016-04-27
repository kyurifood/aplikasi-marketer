package pusat.android.makananbekuenak.com.aplikasi_marketer;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pusat.android.makananbekuenak.com.aplikasi_marketer.domain.Item;
import pusat.android.makananbekuenak.com.aplikasi_marketer.adapter.ListItem;


public class EditdataPribadi extends AppCompatActivity {

    ListView lvItem;
    ListItem adapter;

    AlertDialog.Builder addNewItemDialogBuilder = null;
    AlertDialog addNewItemDialog = null;
    View promptsView;
    TextInputLayout lbrek;

    private Spinner spinnerbank;

    EditText txtnama, txthp, txtalamat, txtkodepos, txtemail, txtrek, txtpemilik, txtcabang;
    String get_nama, get_hp, get_alamat, get_kodepos, get_email, get_rek, get_pemilik, get_cabang;
    String var_nama, var_hp, var_alamat, var_kodepos, var_email, var_rek,var_pemilik, var_cabang;

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;


    List<Item> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editdatapribadi);

        getSupportActionBar().setTitle("EDIT DATA PRIBADI");


        txtemail = (EditText) findViewById(R.id.editemail);
        txtnama = (EditText) findViewById(R.id.editnama);
        txthp = (EditText) findViewById(R.id.edithp);
        txtalamat = (EditText) findViewById(R.id.editalamat);
        txtkodepos = (EditText) findViewById(R.id.editkodepos);
        Spinner mSpinner= (Spinner)findViewById(R.id.spinregional);
        Spinner pSpinner= (Spinner)findViewById(R.id.spinprov);
        Spinner kSpinner= (Spinner)findViewById(R.id.spinkec);
        Spinner lSpinner= (Spinner)findViewById(R.id.spinkel);

        mSpinner.setOnItemSelectedListener(new OnSpinnerItemClicked());
        pSpinner.setOnItemSelectedListener(new OnSpinnerItemClicked());
        kSpinner.setOnItemSelectedListener(new OnSpinnerItemClicked());
        lSpinner.setOnItemSelectedListener(new OnSpinnerItemClicked());

        lvItem = (ListView) findViewById(R.id.lv_item);
//        ViewGroup.LayoutParams listViewParams = (ViewGroup.LayoutParams) lvItem.getLayoutParams();
//        listViewParams.height = 360;
//        lvItem.requestLayout();

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
        get_nama = b.getString("panggil_nama");
        get_email = b.getString("panggil_email");
        get_hp = b.getString("panggil_hp");
        get_alamat = b.getString("panggil_alamat");
        get_kodepos = b.getString("panggil_kodepos");

        txtnama.setText("" + get_nama);
        txtemail.setText("" + get_email);
        txthp.setText(""+ get_hp);
        txtkodepos.setText(""+ get_kodepos);
        txtalamat.setText("" + get_alamat);

    }

    public void showAddDialog() {
        if (addNewItemDialogBuilder == null) {
            addNewItemDialogBuilder = new AlertDialog.Builder(EditdataPribadi.this, R.style.DialogStyle);
        }

        promptsView = LayoutInflater.from(EditdataPribadi.this).inflate(R.layout.tambah_bank, null);


        final Spinner mSpinner= (Spinner) promptsView.findViewById(R.id.spinnerbank);
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
            addNewItemDialogBuilder = new AlertDialog.Builder(EditdataPribadi.this, R.style.DialogStyle);
        }

        promptsView = LayoutInflater.from(EditdataPribadi.this).inflate(R.layout.tambah_bank, null);

        Spinner mSpinner= (Spinner) promptsView.findViewById(R.id.spinnerbank);
        txtrek = (EditText) promptsView.findViewById(R.id.editText);
        txtrek.setText(item.getRekening());
        txtpemilik = (EditText) promptsView.findViewById(R.id.editText2);
        txtpemilik.setText(item.getPemilik());
        txtcabang = (EditText) promptsView.findViewById(R.id.editText3);
        txtcabang.setText(item.getCabang());
        spinnerbank = (Spinner) promptsView.findViewById(R.id.spinnerbank);
        String s = (String)(spinnerbank.getSelectedItem());
        item.setBank(s);

        mSpinner.setOnItemSelectedListener(new OnSpinnerItemClicked());


        Button save = (Button) promptsView.findViewById(R.id.ok);
        save.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                if (!hasError()) {
                    Item newitem = new Item();
                    String s = (String)(spinnerbank.getSelectedItem());
                    newitem.setBank(s);
                    newitem.setRekening(txtrek.getText().toString());
                    newitem.setPemilik(txtpemilik.getText().toString());
                    newitem.setCabang(txtcabang.getText().toString());

                    adapter.editItem(position, newitem);
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

        Intent parsing = null;
        parsing = new Intent(EditdataPribadi.this, TampilanPribadi.class);
        Bundle bb = new Bundle();
        bb.putString("panggilnama", var_nama);
        bb.putString("panggilemail", var_email);
        bb.putString("panggilhp", var_hp);
        bb.putString("panggilalamat", var_alamat);
        bb.putString("panggilkodepos", var_kodepos);
        parsing.putExtras(bb);
        startActivity(parsing);
        Toast.makeText(EditdataPribadi.this, "Update Data Pribadi berhasil", Toast.LENGTH_SHORT).show();

    }

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validasiPass(String pass) {
        return pass.length() > 4;
    }
    //    public boolean validasiCPass(String cpass) {
//        return cpass.length() > 0;
//    }
    public boolean validateKode(String kode) {
        return kode.length() > 0;
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

    private boolean hasError(){
        boolean isError = false;
        if(TextUtils.isEmpty(txtrek.getText().toString())){
            isError = true;
            txtrek.setError("This field is required");
        }
        if(TextUtils.isEmpty(txtpemilik.getText().toString())){
            isError = true;
            txtpemilik.setError("This field is required");
        }
        if(TextUtils.isEmpty(txtcabang.getText().toString())){
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
            }else if (!validateHp(hp)) {
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

            } else submitForm();
            return true;
        }

        if (id == R.id.reset){

        }


        return super.onOptionsItemSelected(item);
    }

}
