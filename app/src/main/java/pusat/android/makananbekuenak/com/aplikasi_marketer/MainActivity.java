package pusat.android.makananbekuenak.com.aplikasi_marketer;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_marketer.adapter.List_item_pesanan;
import pusat.android.makananbekuenak.com.aplikasi_marketer.domain.Item_pesanan;

public class MainActivity extends AppCompatActivity {

    ListView lvItem;
    List_item_pesanan adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("STATUS ORDER");

        List<Item_pesanan> items = new ArrayList<>();
        Item_pesanan item1 = new Item_pesanan();
        item1.setNo_order("001");
        item1.setTanggal_pesan("15-04-2016");
        item1.setNama("Reksin Lewo");
        item1.setBank("Mandiri");
        item1.setRegional("Bogor");
        item1.setMarketer("reka");
        item1.setDistributor("eton");
        item1.setCustomer("gilang");
        item1.setNo_hp_penerima("0975447223");
        item1.setAlamat_penerima("jongol");
        item1.setProduk("karapau");
        item1.setOngkir("12.000");
        item1.setPajak("10.000");
        item1.setNominal("20000");


        Item_pesanan item2 = new Item_pesanan();
        item2.setNo_order("002");
        item2.setTanggal_pesan("15-05-2016");
        item2.setNama("Alfandi");
        item2.setBank("Mandiri");
        item2.setRegional("jakarta");
        item2.setDistributor("ismet");
        item2.setMarketer("aldy");
        item2.setCustomer("satria");
        item2.setNo_hp_penerima("975447223");
        item2.setAlamat_penerima("gorontalo");
        item2.setProduk("karapau-A4");
        item2.setOngkir("13.000");
        item2.setPajak("12.000");
        item2.setNominal("26000");

        Item_pesanan item3 = new Item_pesanan();
        item3.setNo_order("003");
        item3.setTanggal_pesan("15-05-2016");
        item3.setNama("Angki Nusi");
        item3.setBank("Mandiri");
        item3.setRegional("gorontalo");
        item3.setDistributor("rahama");
        item3.setMarketer("afni");
        item3.setCustomer("yetri");
        item3.setNo_hp_penerima("2265347223");
        item3.setAlamat_penerima("makasar");
        item3.setProduk("kyurifoot");
        item3.setOngkir("10.000");
        item3.setPajak("9.000");
        item3.setNominal("32000");

        items.add(item1);
        items.add(item2);
        items.add(item3);


        lvItem = (ListView) findViewById(R.id.lv_item);
        adapter = new List_item_pesanan(MainActivity.this, items);
        lvItem.setAdapter(adapter);
//        lvItem.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
//            @Override
//            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
//                Item_pesanan item = (Item_pesanan) lvItem.getAdapter().getItem(position);
//                item.setSelected(checked);
//            }
//
//            @Override
//            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//                MenuInflater inflater = getMenuInflater();
//                inflater.inflate(R.menu.menu_list_item, menu);
//                mode.setTitle("Select Items");
//                return true;
//            }
//
//            @Override
//            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
//                return false;
//            }
//
//            @Override
//            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.action_submit:
//                        StringBuilder sb = new StringBuilder();
//                        for(int i = 0; i < lvItem.getAdapter().getCount(); i++){
//                            Item_pesanan x = (Item_pesanan) lvItem.getAdapter().getItem(i);
//                            if(x.isSelected()){
//                                sb.append(x.getNo_order());
//                                sb.append(", ");
//                            }
//                        }
//                        String text = sb.toString();
//                        text = text.substring(0, text.length() - 2);
//                        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
//                        mode.finish();
//                        break;
//                    default:
//                        Toast.makeText(MainActivity.this, "Clicked " + item.getTitle(),
//                                Toast.LENGTH_SHORT).show();
//                        break;
//                }
//                return true;
//            }
//
//            @Override
//            public void onDestroyActionMode(ActionMode mode) {
//                adapter.unselectAllItems();
//            }
//        });


    }
}
