package shoesShop.entities;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Roles")
public class Role {
	@Id
	@Column (name ="Id")
	private Integer id;
	
	@Column (name ="Name")
	private String userName;
	
	@ManyToMany(mappedBy = "role")
	private Set<User> user;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Integer id, String userName, Set<User> user) {
		super();
		this.id = id;
		this.userName = userName;
		this.user = user;
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

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	
	
	
}
