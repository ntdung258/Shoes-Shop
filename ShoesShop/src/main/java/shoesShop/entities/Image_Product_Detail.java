package shoesShop.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="Image_Product_Detail")
public class Image_Product_Detail {
	@Id
	@Column (name ="Id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name ="Link")
	private String link;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Product", nullable = false)
    private Product product;

	public Image_Product_Detail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Image_Product_Detail(Integer id, String link, Product product) {
		super();
		this.id = id;
		this.link = link;
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	
}
	