package ua.ozaycev.logistic.entity;

import javax.persistence.*;

@Entity
@Table(name="company", schema="cash")
public class Company {

	private long id;
	private String naame;

	public Company(){
		
	}

	public Company(long id, String naame) {
		super();
		this.id = id;
		this.naame = naame;
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
	public String getNaame() {
		return naame;
	}

	public void setNaame(String naame) {
		this.naame = naame;
	}

}
