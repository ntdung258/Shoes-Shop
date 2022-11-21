package shoesShop.entities;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table (name="Product")
public class Product {
	@Id
	@Column (name ="Id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name ="Code")
	private String code;
	
	@Column (name ="Name")
	private String name;
	
	@Column (name ="Price")
	private Double price;
		
	@Column (name ="Amonut")

	private Integer amount;
	
	@Column (name ="Create_Date")
	private Date create_Date;
		
	@Column (name ="Status")
	private Integer status;
	
	@Column (name ="IsDelete")
	private boolean IsDelete;
	
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "product", cascade = CascadeType.ALL)
	private Bill_Detail bill_Detail;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private Set<Image_Product_Detail> image_Product_Details;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Type", nullable = false)
    private Type type;
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Color", nullable = false)
    private Color_Product color_Product;
    
    @Column (name ="LinkImg")
	private String linkImg;
	


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(Integer id, String code, String name, Double price, Integer amount, Date create_Date,
			Integer status,Bill_Detail bill_Detail, Set<Image_Product_Detail> image_Product_Details, Type type,
			Color_Product color_Product,String linkImg,boolean IsDelete) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.create_Date = create_Date;
		this.status = status;
		this.bill_Detail = bill_Detail;
		this.image_Product_Details = image_Product_Details;
		this.type = type;
		this.color_Product = color_Product;
		this.linkImg = linkImg;
		this.IsDelete = IsDelete;
	}


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}


	public Integer getAmount() {
		return amount;
	}



	public void setAmount(Integer amount) {
		this.amount = amount;
	}



	public Date getCreate_Date() {
		return create_Date;
	}



	public void setCreate_Date(Date create_Date) {
		this.create_Date = create_Date;
	}


	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}



	public Set<Image_Product_Detail> getImage_Product_Details() {
		return image_Product_Details;
	}



	public void setImage_Product_Details(Set<Image_Product_Detail> image_Product_Details) {
		this.image_Product_Details = image_Product_Details;
	}



	public Type getType() {
		return type;
	}



	public void setType(Type type) {
		this.type = type;
	}


	public Bill_Detail getBill_Detail() {
		return bill_Detail;
	}


	public void setBill_Detail(Bill_Detail bill_Detail) {
		this.bill_Detail = bill_Detail;
	}


	public Color_Product getColor_Product() {
		return color_Product;
	}


	public void setColor_Product(Color_Product color_Product) {
		this.color_Product = color_Product;
	}


	public String getLinkImg() {
		return linkImg;
	}


	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}


	public boolean isIsDelete() {
		return IsDelete;
	}


	public void setIsDelete(boolean isDelete) {
		IsDelete = isDelete;
	}

	
	
}
