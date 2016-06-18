package ua.ozaycev.logistic.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.ozaycev.logistic.dao.ProductCategoryRepository;
import ua.ozaycev.logistic.entity.ProductCategory;
import ua.ozaycev.logistic.services.ProductCategoryService;

import java.util.List;

/**
 * Created by Ozaycev on 02.06.2016.
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    @Qualifier("productCategoryRepository")
    private ProductCategoryRepository categoryRepository;

    @Transactional
    public void add(String name, ProductCategory productCategory) {
        ProductCategory newCategory = new ProductCategory(name, productCategory);
        categoryRepository.save(newCategory);

    }

    @Transactional
    public void add(String name) {
        ProductCategory newCategory = new ProductCategory(name);
        categoryRepository.save(newCategory);
    }

    @Transactional
    public void add(ProductCategory productCategory) {
        categoryRepository.save(productCategory);
    }

    @Transactional
    public void edit(long id, String name, ProductCategory productCategory) {
        ProductCategory category = categoryRepository.findOne(id);
        if(name!=null){
            category.setName(name);
        }
        if(productCategory!=null){
            category.setParentProductCategory(productCategory);
        }
        categoryRepository.save(category);
    }

    @Transactional
    public ProductCategory findById(long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public List<ProductCategory> findByIdParrent(long idParrent) {
        return categoryRepository.findByIdParrent(idParrent);
    }

    @Transactional
    public List<ProductCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    public List<ProductCategory> findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Transactional
    public void delete(long id) {
        ProductCategory newCategory = findById(id);
        categoryRepository.delete(newCategory);
    }

}
