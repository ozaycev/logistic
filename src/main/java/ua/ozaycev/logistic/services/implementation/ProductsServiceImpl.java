package ua.ozaycev.logistic.services.implementation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.ozaycev.logistic.dao.ProductsRepository;
import ua.ozaycev.logistic.entity.ProductCategory;
import ua.ozaycev.logistic.entity.Products;
import ua.ozaycev.logistic.services.ProductsService;

import java.util.List;


/**
 * Created by Ozaycev on 21.05.2016.
 */
@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productRepository;

    @Transactional
    public void add(String name, String articul, ProductCategory productCategory) {
        Products newProduct = new Products(name,articul ,productCategory);
        productRepository.save(newProduct);

    }

    @Transactional
    public void add(String name, String articul) {
        Products newProduct = new Products(name, articul);
        productRepository.save(newProduct);
    }

    @Transactional
    public void add(Products product) {
        productRepository.save(product);
    }

    @Transactional
    public void edit(long id, String name, String articul, ProductCategory productCategory) {
        Products product = productRepository.findOne(id);
        if(name!=null){
            product.setName(name);
        }
        if(productCategory!=null){
            product.setCategory(productCategory);
        }
        productRepository.save(product);
    }

    @Transactional
    public Products findById(long id) {
        return productRepository.findOne(id);
    }

    @Override
    public List<Products> findByArticul(String articul) {
        return productRepository.findByArticul(articul);
    }

    @Transactional
    public List<Products> findByIdCategory(long idCategory) {
        return productRepository.findByIdCategory(idCategory);
    }

    @Transactional
    public List<Products> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    public List<Products> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Transactional
    public void delete(long id) {
        Products newProduct = findById(id);
        productRepository.delete(newProduct);
    }

}
