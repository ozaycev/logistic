package ua.ozaycev.logistic.entity;

import javax.persistence.*;

@Entity
@Table(name="table_sales", schema="cash")
public class TableSales{

	private long id;
	private Products product;
	private double quantity;
	private double price;
	private double sum;
	private Sales idSales = new Sales();
	
	public TableSales() {

	}
	
	public TableSales(long id, long id_product, double quantity, double price, double sum, Sales idSales) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.sum = sum;
		this.idSales = idSales;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="quantity", nullable=false)
	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Column(name="price", nullable=false)
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name="sum", nullable=false)
	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="table_sales", joinColumns={@JoinColumn(referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="id_sales")})
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Sales getIdSales() {
		return idSales;
	}

	public void setIdSales(Sales idSales) {
		this.idSales = idSales;
	}

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "id_product", referencedColumnName = "id")
	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

}
