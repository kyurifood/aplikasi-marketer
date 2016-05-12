package pusat.android.makananbekuenak.com.aplikasi_marketer.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_marketer.R;
import pusat.android.makananbekuenak.com.aplikasi_marketer.domain.ProdukItemDetails;

public class ProdukBaseAdapter extends BaseAdapter implements Filterable{

	
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
	private List<ProdukItemDetails> items;
	private static List<ProdukItemDetails> produkList;

	public ProdukBaseAdapter(Context context, ArrayList<ProdukItemDetails> results) {
		produkList = results;
		l_Inflater = LayoutInflater.from(context);
		this.context = context;
		this.items = results;
	}

	public int getCount() {
		if(produkList==null)return 0;
		else return produkList.size();
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

	@Override
	public Filter getFilter() {
		return new Filter() {
			@Override
			protected FilterResults performFiltering(CharSequence constraint) {
				FilterResults filterResults = new FilterResults();
				if(constraint!=null||constraint.length()>0){
					Log.i("const:", constraint.toString());
					ArrayList<ProdukItemDetails> result = new ArrayList<>();
					String strSearch = constraint.toString().toUpperCase();
					for (ProdukItemDetails o : items){
						Log.i("const:", strSearch);
						Log.i("data:", o.getS_regional().toUpperCase());
						if(o.getS_regional().toUpperCase().contains(strSearch))
							result.add(o);
						else if(o.getS_distributor().toUpperCase().contains(strSearch))
							result.add(o);
					}

					filterResults.count=result.size();
					filterResults.values=result;

				}

				return filterResults;
			}

			@Override
			protected void publishResults(CharSequence constraint, FilterResults results) {
				produkList = (ArrayList<ProdukItemDetails>) results.values;
				notifyDataSetChanged();
			}
		};
	}
}
