package ua.ozaycev.logistic.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name="shop", schema="cash")
public class Shop {
	
	private long id;
	private String name;
	private Store store;
	private long version;
	
	public Shop(){
		
	}

	public Shop(long id, String name, Store store) {
		super();
		this.id = id;
		this.name = name;
		this.store = store;
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

	@Column(name="store")
	@NotNull
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Version
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

}
