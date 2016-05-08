package pusat.android.makananbekuenak.com.aplikasi_marketer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_marketer.ui.EditdataPribadi;
import pusat.android.makananbekuenak.com.aplikasi_marketer.ui.Entry_Order2;
import pusat.android.makananbekuenak.com.aplikasi_marketer.R;
import pusat.android.makananbekuenak.com.aplikasi_marketer.ui.RegistrasiMarketer;
import pusat.android.makananbekuenak.com.aplikasi_marketer.domain.Item;

/**
 * Created by rinaldy on 06/04/16.
 */
public class ListItem extends BaseAdapter {
    private Context context;
    private List<Item> items;
    private String flag;


    public ListItem(Context context, List<Item> items, String flag) {
        this.context = context;
        this.items = items;
        this.flag = flag;
    }

    @Override
    public int getCount() {
        if(items == null)
            return -1;
        else
            return items.size();
    }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent ) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);

        final Item item = items.get(position);

        TextView bank = (TextView)convertView.findViewById(R.id.list_item_bank);
        TextView rekening = (TextView)convertView.findViewById(R.id.list_item_rekening);
        TextView pemilik = (TextView)convertView.findViewById(R.id.list_item_nama);
        TextView cabang = (TextView)convertView.findViewById(R.id.list_item_cabang);


        bank.setText(item.getBank());
        rekening.setText(item.getRekening());
        pemilik.setText(item.getPemilik());
        cabang.setText(item.getCabang());

        Button delete = (Button)convertView.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                deleteItem(position);
            }
        });


        Button edit = (Button) convertView.findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag.equals("1")){
                    ((RegistrasiMarketer) context).showEditDialog(position, item);
                }else if (flag.equals("2")){
                    ((Entry_Order2) context).TambahBankEdit(position, item);
                }else {
                    ((EditdataPribadi) context).showEditDialog(position, item);
                }
            }
        });

        return convertView;
    }

    public void addItem(Item item){
        items.add(item);
        notifyDataSetChanged();
    }

    public void deleteItem(int position){
        items.remove(position);
        notifyDataSetChanged();
    }

    public void editItem(int position, Item item){
        items.set(position, item);
        notifyDataSetChanged();
    }

}
