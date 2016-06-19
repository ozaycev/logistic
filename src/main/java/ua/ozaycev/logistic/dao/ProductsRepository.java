package ua.ozaycev.logistic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ozaycev.logistic.entity.Products;

import java.util.List;

/**
 * Created by Ozaycev on 29.05.2016.
 */

public interface ProductsRepository extends JpaRepository<Products, Long> {

    List<Products> findByName(String name);

    List<Products> findByIdCategory(long id);

    List<Products> findByArticul(String articul);
}