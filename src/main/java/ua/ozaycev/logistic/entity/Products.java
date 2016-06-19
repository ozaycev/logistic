package ua.ozaycev.logistic.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="products", schema="cash")
@NamedQueries({
	@NamedQuery(
			name = "Products.findAll",
			query = "FROM Products AS product ORDER BY product.id"),
	@NamedQuery(
			name = "Products.findByID",
			query = "FROM Products AS product WHERE product.id = :id"),
	@NamedQuery(
			name = "Products.findByArticul",
			query = "FROM Products AS product WHERE product.articul like :articul"),
	@NamedQuery(
			name = "Products.findByName",
			query = "FROM Products AS product WHERE product.name like :name"),
	@NamedQuery(
				name = "Products.findByIdCategory",
				query = "FROM Products AS product WHERE product.category.id = :id")
	})
public class Products implements Serializable{

	private static final long serialVersionUID = -6531119571542427771L;

	private long id;
	private String name;
	private String articul;
	private ProductCategory category;

	public Products(){
		
	}
	
	public Products(String name){
		this.name = name;
	}

	public Products(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Products(String name, String articul) {
		super();

		this.name = name;
		this.articul = articul;
	}
	
	public Products(String name, String articul, ProductCategory category) {
		super();

		this.name = name;
		this.articul = articul;
		this.category = category;
	}
	
	public Products(long id, String name, String articul) {
		super();
		this.id = id;
		this.name = name;
		this.articul = articul;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="name", length=250, nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="articul", length=15)
	public String getArticul() {
		return articul;
	}

	public void setArticul(String articul) {
		this.articul = articul;
	}
		
	@ManyToOne(cascade=CascadeType.DETACH, fetch=FetchType.LAZY)
	@JoinColumn(name="category", referencedColumnName="id")
	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

}
