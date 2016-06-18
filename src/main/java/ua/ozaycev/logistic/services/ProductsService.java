package ua.ozaycev.logistic.services;

import ua.ozaycev.logistic.entity.Products;

import java.util.List;

/**
 * Created by Yulian Bulbuk on 21.05.2016.
 */
public interface ProductsService {

    public void add(String name, String country);

    public void edit(long id, String name, String country);

    public Products findById(long id);

    public List<Products> findAll();

    public List<Products> findByName(String name);
}
