package ua.ozaycev.logistic.services;


import ua.ozaycev.logistic.entity.Users;

/**
 * Created by Yulian Bulbuk on 04.06.2016.
 */
public interface UsersService {

    public void add(Users users);

    public Users findByID(int id);
}
