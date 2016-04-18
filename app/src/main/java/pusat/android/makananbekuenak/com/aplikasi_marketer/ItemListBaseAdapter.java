package pusat.android.makananbekuenak.com.aplikasi_marketer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chitoz on 4/14/16.
 */
public class ItemListBaseAdapter extends BaseAdapter {
    private static ArrayList<ItemDetail> ItemDetailArrayList;

    //Sediakan beberapa gambar, masukkan dalam folder /res/drawable.
    //disini saya contohkan gambar dengan nama aa, ab, dst
    private Integer[]imgid = {
            R.drawable.produk,
            R.drawable.produk,
            R.drawable.produk,
            R.drawable.produk,
            R.drawable.produk,
            R.drawable.produk,
            R.drawable.produk,
            R.drawable.produk,
    };

    private LayoutInflater l_inflater;

    public ItemListBaseAdapter (Context context, ArrayList<ItemDetail> result){
        ItemDetailArrayList = result;
        l_inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return ItemDetailArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return ItemDetailArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //sebelum ketik dibawah ini, bikin dulu static class di bagian paaaaliing bawah
        //biar ga error
        ViewHolder holder;

        if (convertView == null){
            convertView = l_inflater.inflate(R.layout.list_view_image, null);
            holder = new ViewHolder();
            holder.txt_itemKode_Produk = (TextView) convertView.findViewById(R.id.kd_produk);
            holder.txt_itemNama = (TextView) convertView.findViewById(R.id.nama);
            holder.txt_itemPrice = (TextView) convertView.findViewById(R.id.price);
            holder.itemImage = (ImageView) convertView.findViewById(R.id.photo);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txt_itemKode_Produk.setText(ItemDetailArrayList.get(position).getKode_produk());
        holder.txt_itemNama.setText(ItemDetailArrayList.get(position).getNama());
        holder.txt_itemPrice.setText(ItemDetailArrayList.get(position).getPrice());
        holder.itemImage.setImageResource(imgid[ItemDetailArrayList.get(position).getImageNumber() - 1]);

        return convertView;
    }

    static class ViewHolder {
        TextView txt_itemKode_Produk;
        TextView txt_itemNama;
        TextView txt_itemPrice;
        ImageView itemImage;
    }
}
