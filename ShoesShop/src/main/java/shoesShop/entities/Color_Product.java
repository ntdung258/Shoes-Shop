package shoesShop.entities;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="Color_Product")
public class Color_Product {
	@Id
	@Column (name ="Id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name ="Name")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "color_Product")
    private Set<Product> product;

	public Color_Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Color_Product(Integer id, String name, Set<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return product;
	}

	public void setProducts(Set<Product> product) {
		this.product = product;
	}
	
	
}
