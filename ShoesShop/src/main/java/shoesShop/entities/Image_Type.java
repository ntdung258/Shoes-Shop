package shoesShop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name="Image_Type")
public class Image_Type {
	@Id
	@Column (name ="Id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name ="Link")
	private String link;
	
	@Column (name ="Id_Type")
	private Integer id_Type;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "id_Type")
	private Type type;

	
	
	public Image_Type() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Image_Type(Integer id, String link, Integer id_Type, Type type) {
		super();
		this.id = id;
		this.link = link;
		this.id_Type = id_Type;
		this.type = type;
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



	public Integer getId_Type() {
		return id_Type;
	}



	public void setId_Type(Integer id_Type) {
		this.id_Type = id_Type;
	}



	public Type getType() {
		return type;
	}



	public void setType(Type type) {
		this.type = type;
	}


	
}
	
