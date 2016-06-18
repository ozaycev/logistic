package ua.ozaycev.logistic.entity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name="Users.findUserByLogin", query = "SELECT u FROM Users u where u.email like :login or u.phone like :login"),
        @NamedQuery(name="Users.findByID", query = "SELECT u FROM Users u where u.id = :id")
})
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String secondname;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String password;

    public Users() {

    }

    public Users(String name, String secondname, String email, String phone, String password) {
        this.name = name;
        this.secondname = secondname;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
