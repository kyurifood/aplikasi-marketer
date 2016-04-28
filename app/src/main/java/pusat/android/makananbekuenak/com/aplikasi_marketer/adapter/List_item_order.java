package pusat.android.makananbekuenak.com.aplikasi_marketer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

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
        Button tambah_produk = (Button) orderView.findViewById(R.id.tambahproduk);
        Button kurang_produk = (Button) orderView.findViewById(R.id.kurang);

        kd_produk.setText(item.getKode());
        nama_produk.setText(item.getNama());
//        harga_produk.setText("$" + item.getHarga());
        harga_produk.setText("$" + item.getPrice());
        jumah_produk.setText("" + item.getJumlah());

        tambah_produk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer i = Integer.valueOf(jumah_produk.getText().toString());
                i = i + 1;
                jumah_produk.setText(String.valueOf(i));

            }
        });

        kurang_produk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer i = Integer.valueOf(jumah_produk.getText().toString());
                i = i - 1;
                jumah_produk.setText(String.valueOf(i));
            }
        });

        return orderView;
    }
}
