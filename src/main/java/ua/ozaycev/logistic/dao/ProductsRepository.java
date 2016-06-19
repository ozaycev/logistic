package ua.ozaycev.logistic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ua.ozaycev.logistic.entity.Products;

import java.util.List;

/**
 * Created by Ozaycev on 29.05.2016.
 */

public interface ProductsRepository extends JpaRepository<Products, Long> {

    @Transactional
    List<Products> findByName(String name);

    @Transactional
    List<Products> findByIdCategory(long id);

    @Transactional
    List<Products> findByArticul(String articul);
}