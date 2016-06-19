package ua.ozaycev.logistic.entity;

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
import javax.persistence.Version;

@Entity
@Table(name="product_category", schema="cash")
@NamedQueries(value = {
		@NamedQuery(
				name = "ProductCategory.findAll",
				query = "SELECT product.id as id, " +
						"product.parentProductCategory as parentProductCategory, " +
						"product.name as name  " +
						"FROM ProductCategory AS product " +
						"ORDER BY product.parentProductCategory.id"),
		@NamedQuery(
				name = "ProductCategory.findID",
				query = "FROM ProductCategory AS product WHERE product.id = ?1"),
		@NamedQuery(
				name = "ProductCategory.findName",
				query = "FROM ProductCategory AS product WHERE product.name like ?1"),
		@NamedQuery(
				name = "ProductCategory.findByIdParrent",
				query = "FROM ProductCategory AS product WHERE product.parentProductCategory.id = ?1")
})
public class ProductCategory {
	
	private long id;
	private String name;
	private ProductCategory parentProductCategory;

	public ProductCategory() {
	
	}

	public ProductCategory(String name) {
		this.name = name;
	}

	public ProductCategory(long id, String name, ProductCategory parentProductCategory) {
		super();
		this.id = id;
		this.name = name;
		this.parentProductCategory = parentProductCategory;
	}

	public ProductCategory(String name, ProductCategory parentProductCategory) {
		super();
		this.name = name;
		this.parentProductCategory = parentProductCategory;
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

	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name="parent_category", referencedColumnName="id")
	public ProductCategory getParentProductCategory() {
		return parentProductCategory;
	}

	public void setParentProductCategory(ProductCategory parentProductCategory) {
		this.parentProductCategory = parentProductCategory;
	}
}
