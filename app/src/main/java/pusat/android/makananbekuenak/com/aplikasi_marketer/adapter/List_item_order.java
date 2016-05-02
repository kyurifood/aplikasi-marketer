package pusat.android.makananbekuenak.com.aplikasi_marketer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_marketer.Entry_Order;
import pusat.android.makananbekuenak.com.aplikasi_marketer.R;
import pusat.android.makananbekuenak.com.aplikasi_marketer.domain.ItemEntry_Order;

/**
 * Created by gilang on 28/04/16.
 */

public class List_item_order extends BaseAdapter {

    public Context context;
    private List<ItemEntry_Order> items;

    public List_item_order(Context context, List<ItemEntry_Order> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public ItemEntry_Order getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View orderView, ViewGroup parent) {
        if (orderView == null)
            orderView = LayoutInflater.from(context).inflate(R.layout.list_produk_layout, parent, false);

        final ItemEntry_Order item = items.get(position);

        TextView kd_produk = (TextView) orderView.findViewById(R.id.kd_produk);
        TextView nama_produk = (TextView) orderView.findViewById(R.id.nama_produk);
        TextView harga_produk = (TextView) orderView.findViewById(R.id.price);
        final TextView jumah_produk = (TextView) orderView.findViewById(R.id.jumlah);
        final Button tambah_produk = (Button) orderView.findViewById(R.id.tambahproduk);
        final Button kurang_produk = (Button) orderView.findViewById(R.id.kurang);
        final CheckBox cek = (CheckBox) orderView.findViewById(R.id.cekTotal);
        final TextView satuan = (TextView) orderView.findViewById(R.id.satuan);

        kd_produk.setText(item.getKode());
        nama_produk.setText(item.getNama());
        harga_produk.setText("Rp." + item.getPrice());


        tambah_produk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer i = Integer.valueOf(jumah_produk.getText().toString());
                i = i + 1;
                jumah_produk.setText(String.valueOf(i));
                kurang_produk.setEnabled(true);
                if (jumah_produk.getText() != jumah_produk) {
                    Integer tambah = i * item.getPrice();
                    satuan.setText(String.valueOf(tambah));
                    item.setSatuan(Integer.valueOf(tambah));
                    cek.setEnabled(true);
                } else {
                    satuan.setText(String.valueOf(""));
                }
            }
        });

        kurang_produk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer i = Integer.valueOf(jumah_produk.getText().toString());
                if (i <= 0) {
                    kurang_produk.setEnabled(false);
                    cek.setEnabled(false);
                } else {
                    i = i - 1;
                    jumah_produk.setText(String.valueOf(i));
                    if (jumah_produk.getText() != jumah_produk) {
                        Integer kurang = i * item.getPrice();
                        satuan.setText(String.valueOf(kurang));
                        item.setSatuan(Integer.valueOf(kurang));
                    } else {
                        satuan.setText(String.valueOf(""));
                    }
                }

            }
        });

        cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cek.isChecked() == true) {
                    ((Entry_Order) context).cekTotal(item);
                    kurang_produk.setEnabled(false);
                    tambah_produk.setEnabled(false);
                } else {
                    ((Entry_Order) context).uncekTotal(item);
                    kurang_produk.setEnabled(true);
                    tambah_produk.setEnabled(true);
                }
            }
        });

        return orderView;
    }
}
