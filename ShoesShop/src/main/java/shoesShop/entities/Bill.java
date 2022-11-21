package shoesShop.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="Bill")
public class Bill {
	@Id
	@Column (name ="Id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name ="Total_Price")
	private Double total_Price;	
	
	@Column (name ="Create_Date")
	private Date create_Date;
	
	@Column (name ="RecipientName")
	private String recipientName;
	
	@Column (name ="DeliAddress")
	private String deliAddress;
	
	@Column (name ="Phone")
	private String phone;
	
	@Column (name ="Note")
	private String note;
	
	@Column (name ="Status")
	private Integer status;

	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "bill")
    private Set<Bill_Detail> bill_Details;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_User",  updatable = false)
    private User user;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(Integer id, Double total_Price, Date create_Date, String recipientName, String deliAddress,
			String phone, String note,Set<Bill_Detail> bill_Details, User user,Integer status) {
		super();
		this.id = id;
		this.total_Price = total_Price;
		this.create_Date = create_Date;
		this.recipientName = recipientName;
		this.deliAddress = deliAddress;
		this.phone = phone;
		this.note = note;
		this.bill_Details = bill_Details;
		this.user = user;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTotal_Price() {
		return total_Price;
	}

	public void setTotal_Price(Double total_Price) {
		this.total_Price = total_Price;
	}

	public Date getCreate_Date() {
		return create_Date;
	}

	public void setCreate_Date(Date create_Date) {
		this.create_Date = create_Date;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getDeliAddress() {
		return deliAddress;
	}

	public void setDeliAddress(String deliAddress) {
		this.deliAddress = deliAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	public Set<Bill_Detail> getBill_Details() {
		return bill_Details;
	}

	public void setBill_Details(Set<Bill_Detail> bill_Details) {
		this.bill_Details = bill_Details;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	
	
}
