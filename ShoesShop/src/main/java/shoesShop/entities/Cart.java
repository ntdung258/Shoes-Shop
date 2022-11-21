package shoesShop.entities;

public class Cart {
	private Integer id_Product;
	private String name;
	private Integer amount;
	private Double price;
	private String	link;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Cart(Integer id_Product, String name, Integer amount, Double price, String link) {
		super();
		this.id_Product = id_Product;
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.link = link;
	}




	public Integer getId_Product() {
		return id_Product;
	}

	public void setId_Product(Integer id_Product) {
		this.id_Product = id_Product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}
	
		
	
}
