package ua.ozaycev.logistic.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="sale", schema="cash")
public class Sales{

	private long id;
	private Date date;
	private Set<TableSales> tableSales = new LinkedHashSet<TableSales>();
	
	public Sales() {

	}
	
	public Sales(long id, Date date, Set<TableSales> tableSales) {
		super();
		this.id = id;
		this.date = date;
		this.tableSales = tableSales;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date", length=100, nullable=false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(mappedBy="idSales", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	@Column(name="id_sales", nullable=false)
	public Set<TableSales> getTableSales() {
		return tableSales;
	}

	public void setTableSales(Set<TableSales> tableSales) {
		this.tableSales = tableSales;
	}

	public void addTableSales(TableSales tableSales){
		
		tableSales.setIdSales(this);
		this.tableSales.add(tableSales);
		
	}
	
}
