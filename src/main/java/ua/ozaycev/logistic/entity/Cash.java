package ua.ozaycev.logistic.entity;

import javax.persistence.*;

@Entity
@Table(name="cash", schema="cash")
public class Cash {
	
	private long id;
	private String name;
	private Shop shop;
	private long version;
	
	public Cash(){
		
	}

	public Cash(long id, String name, Shop shop) {
		super();
		this.id = id;
		this.name = name;
		this.shop = shop;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="name", length=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="shop")
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
		
	@Version
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

}
