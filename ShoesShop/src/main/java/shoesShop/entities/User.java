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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


@Entity
@Table (name="Users")
public class User {
	@Id
	@Column (name ="Id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name ="UserName")
	@Length(min=5,message="Username must be at least 5 characters")
	private String userName;
	
	
	@Column (name ="Password")
	@Length(min=6,message="Password must be at least 6 characters")
	private String password;
	
	@Column (name ="Name")
	@NotEmpty(message="Name not be empty")
	private String name;
	
	@Column (name ="Create_Date")
	private Date create_Date;
	
	@Column (name ="Phone")
	@Length(min=10,message="Phone must be at least 10 number")
	private String phone;
		
	@Column (name ="Address")
	@NotEmpty(message="Address not be empty")
	private String address;
	
	@Column (name ="Email")
	@NotEmpty(message="Email not be empty")
	private String email;
	
	@Column (name ="Status")
	private Integer status;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Bill> bill;
	
	@ManyToMany()
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="idUser"),
								inverseJoinColumns = @JoinColumn(name="id_Role"))
	private Set<Role> role;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String userName, String password, String name, Date create_Date, String phone,
			String address, String email, Integer status, Set<Bill> bill,Set<Role> role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.create_Date = create_Date;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.status = status;
		this.bill = bill;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreate_Date() {
		return create_Date;
	}

	public void setCreate_Date(Date create_Date) {
		this.create_Date = create_Date;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<Bill> getBill() {
		return bill;
	}

	public void setBill(Set<Bill> bill) {
		this.bill = bill;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}
	

}
