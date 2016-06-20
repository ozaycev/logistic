package ua.ozaycev.logistic.entity;

import com.sun.istack.internal.NotNull;
import javax.persistence.Table;

import javax.persistence.*;

@Entity
@Table(name="settings_users", schema="cash")
public class SettingsUsers{

	private int id;
	private Users user;
	private Company company;
	private Cash cash;
	private Shops shop;
	private Store store;

	public SettingsUsers() {

	}

	public SettingsUsers(Users user, Company company, Cash cash, Shops shop, Store store) {
		super();
		this.user = user;
		this.company = company;
		this.cash = cash;
		this.shop = shop;
		this.store = store;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(targetEntity = Users.class, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
	@NotNull
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@OneToOne(targetEntity = Company.class, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
	@NotNull
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@OneToOne(targetEntity = Cash.class, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
	@NotNull
	public Cash getCash() {
		return cash;
	}

	public void setCash(Cash cash) {
		this.cash = cash;
	}

	@OneToOne(targetEntity = Shops.class, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
	@NotNull
	public Shops getShop() {
		return shop;
	}

	public void setShop(Shops shop) {
		this.shop = shop;
	}

	@OneToOne(targetEntity = Store.class, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
	@NotNull
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}
