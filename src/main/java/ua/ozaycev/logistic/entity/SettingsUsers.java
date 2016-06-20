import com.sun.istack.internal.NotNull;
import ua.ozaycev.logistic.entity.*;

import javax.persistence.Table;

import javax.persistence.*;

@Entity
@Table(name="settings_users", schema="cash")
public class SettingsUsers{


	private Users user;
	private Company company;
	private Cash cash;
	private Shops shop;
	private Store store;
	
	public SettingsUsers(Users user, Company company, Cash cash, Shops shop, Store store) {
		super();
		this.user = user;
		this.company = company;
		this.cash = cash;
		this.shop = shop;
		this.store = store;
	}

	@NotNull
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@NotNull
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@NotNull
	public Cash getCash() {
		return cash;
	}

	public void setCash(Cash cash) {
		this.cash = cash;
	}

	@NotNull
	public Shops getShop() {
		return shop;
	}

	public void setShop(Shops shop) {
		this.shop = shop;
	}

	@NotNull
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}
