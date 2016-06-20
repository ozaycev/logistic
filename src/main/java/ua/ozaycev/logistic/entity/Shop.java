package ua.ozaycev.logistic.entity;

import javax.persistence.*;

@Entity
@Table(name="shops", schema="cash")
public class Shop {
	
	private long id;
	private String name;

	public Shop(){
		
	}

	public Shop(long id, String name) {
		this.id = id;
		this.name = name;
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

}
