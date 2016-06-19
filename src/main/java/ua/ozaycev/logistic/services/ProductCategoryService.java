package ua.ozaycev.logistic.services;

import ua.ozaycev.logistic.entity.ProductCategory;

import java.util.List;

/**
 * Created by Ozaycev on 21.05.2016.
 */
public interface ProductCategoryService {

    public void add(String name, ProductCategory productCategory);

    public void add(String name);

    public void add(ProductCategory productCategory);

    public void edit(long id, String name, ProductCategory productCategory);

    public ProductCategory findById(long id);

    public List<ProductCategory> findByIdParrent(long idParrent);

    public List<ProductCategory> findAll();

    public List<ProductCategory> findByName(String name);

    public void delete(long id);
}
