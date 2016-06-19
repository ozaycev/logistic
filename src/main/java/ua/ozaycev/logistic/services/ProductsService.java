package ua.ozaycev.logistic.services;

import ua.ozaycev.logistic.entity.ProductCategory;
import ua.ozaycev.logistic.entity.Products;

import java.util.List;

/**
 * Created by Ozaycev on 21.05.2016.
 */
public interface ProductsService {

    public void add(String name, String articul, ProductCategory productCategory);

    public void add(String name, String articul);

    public void add(Products product);

    public void edit(long id, String name, String articul, ProductCategory productCategory);

    public Products findById(long id);

    public List<Products> findByArtucul(String articul);

    public List<Products> findByIdCategory(long idCategory);

    public List<Products> findAll();

    public List<Products> findByName(String name);

    public void delete(long id);


}
