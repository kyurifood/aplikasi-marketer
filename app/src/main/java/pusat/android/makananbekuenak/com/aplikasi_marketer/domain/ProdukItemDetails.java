package pusat.android.makananbekuenak.com.aplikasi_marketer.domain;

public class ProdukItemDetails {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getImageNumber() {
		return imageNumber;
	}
	public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
	}

	public String getS_regional() {
		return s_regional;
	}

	public void setS_regional(String s_regional) {
		this.s_regional = s_regional;
	}

	public String getS_distributor() {
		return s_distributor;
	}

	public void setS_distributor(String s_distributor) {
		this.s_distributor = s_distributor;
	}

	private String name ;
	private String itemDescription;
	private String price;
	private int imageNumber;
	private String s_regional;
	private String s_distributor;

	
}
