package Good;
public class Goods {
		private String id;
		private String name;
		private String price;
		
	public Goods(String id, String name, String price) {
			this.id=id;
			this.name=name;
			this.price=price;
		}
	public Goods(String Id) {
		this.id=id;
	}
	public Goods(String id, String name, String price, String Id) {
		this.id=id;
		this.name=name;
		this.price=price;
		this.id=Id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price=price;
	}
	public String getid() {
		return id;
	}
	
}
