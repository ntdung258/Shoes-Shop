package shoesShop.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="Type")
public class Type {
	@Id
	@Column (name ="Id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name ="Name")
	private String name;
	
	@Column (name ="Size_Min")
	private Integer size_Min;
	
	@Column (name ="Size_Max")
	private Integer size_Max;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "type", cascade = CascadeType.ALL)
	private Image_Type image_Type;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "type")
    private Set<Product> product;
	
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Type(Integer id, String name, Integer size_Min, Integer size_Max, Image_Type image_Type,
			Set<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.size_Min = size_Min;
		this.size_Max = size_Max;
		this.image_Type = image_Type;
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


	public Integer getSize_Min() {
		return size_Min;
	}


	public void setSize_Min(Integer size_Min) {
		this.size_Min = size_Min;
	}


	public Integer getSize_Max() {
		return size_Max;
	}


	public void setSize_Max(Integer size_Max) {
		this.size_Max = size_Max;
	}


	public Image_Type getImage_Type() {
		return image_Type;
	}


	public void setImage_Type(Image_Type image_Type) {
		this.image_Type = image_Type;
	}


	public Set<Product> getProduct() {
		return product;
	}


	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	
}
