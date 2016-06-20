package ua.ozaycev.logistic.entity;

import javax.persistence.*;

@Entity
@Table(name="store", schema="cash")
public class Store {

	private long id;
	private String name;

	public Store(){
		
	}

	public Store(long id, String name) {
		super();
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
