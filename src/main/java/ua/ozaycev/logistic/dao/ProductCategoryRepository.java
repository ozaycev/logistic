package ua.ozaycev.logistic.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.ozaycev.logistic.entity.ProductCategory;

import java.util.List;

/**
 * Created by Ozaycev on 29.05.2016.
 */


public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    List<ProductCategory> findByName(String name);

    List<ProductCategory> findByIdParrent(long idParrent);

}
