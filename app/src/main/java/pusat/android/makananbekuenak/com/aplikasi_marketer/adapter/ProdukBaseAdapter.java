package pusat.android.makananbekuenak.com.aplikasi_marketer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pusat.android.makananbekuenak.com.aplikasi_marketer.R;
import pusat.android.makananbekuenak.com.aplikasi_marketer.domain.ProdukItemDetails;

public class ProdukBaseAdapter extends BaseAdapter {
	private static ArrayList<ProdukItemDetails> produkList;
	
	private Integer[] imgid = {
			R.drawable.produk,
			R.drawable.karapao1,
			R.drawable.karapao2,
			R.drawable.karapao3,
			R.drawable.produk,
			R.drawable.produk,
			R.drawable.produk
			};

	public LayoutInflater l_Inflater;

	public Context context;

	public ProdukBaseAdapter(Context context, ArrayList<ProdukItemDetails> results) {
		produkList = results;
		l_Inflater = LayoutInflater.from(context);
		this.context = context;
	}

	public int getCount() {
		return produkList.size();
	}

	public Object getItem(int position) {
		return produkList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = l_Inflater.inflate(R.layout.activity_produk, null);
			holder = new ViewHolder();
			holder.txt_itemName = (TextView) convertView.findViewById(R.id.nm_produk);
			holder.txt_itemDescription = (TextView) convertView.findViewById(R.id.desc_produk);
			holder.txt_itemPrice = (TextView) convertView.findViewById(R.id.hr_produk);
			holder.itemImage = (ImageView) convertView.findViewById(R.id.img_produk);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.txt_itemName.setText(produkList.get(position).getName());
		holder.txt_itemDescription.setText(produkList.get(position).getItemDescription());
		holder.txt_itemPrice.setText(produkList.get(position).getPrice());
		holder.itemImage.setImageResource(imgid[produkList.get(position).getImageNumber() - 1]);
		return convertView;
	}

	static class ViewHolder {
		TextView txt_itemName;
		TextView txt_itemDescription;
		TextView txt_itemPrice;
		ImageView itemImage;
	}
}
