package shoesShop.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="Bill_Detail")
public class Bill_Detail {
	@Id
	@Column (name ="Id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name ="Amount")
	private Integer amount;
	
	@Column (name ="Size_Product")
	private Integer size_Product;
	
	@Column (name ="Sum_Price")
	private Double sum_Price;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Bill", nullable = false)
    private Bill bill;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Product")
	private Product product;
	
	
	

	public Bill_Detail() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Bill_Detail(Integer id, Integer amount, Integer size_Product, Double sum_Price, Bill bill, Product product) {
		super();
		this.id = id;
		this.amount = amount;
		this.size_Product = size_Product;
		this.sum_Price = sum_Price;
		this.bill = bill;
		this.product = product;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public Integer getAmount() {
		return amount;
	}




	public void setAmount(Integer amount) {
		this.amount = amount;
	}




	public Integer getSize_Product() {
		return size_Product;
	}




	public void setSize_Product(Integer size_Product) {
		this.size_Product = size_Product;
	}




	public Double getSum_Price() {
		return sum_Price;
	}




	public void setSum_Price(Double sum_Price) {
		this.sum_Price = sum_Price;
	}




	public Bill getBill() {
		return bill;
	}




	public void setBill(Bill bill) {
		this.bill = bill;
	}




	public Product getProduct() {
		return product;
	}




	public void setProduct(Product product) {
		this.product = product;
	}

	
	
	
	
}