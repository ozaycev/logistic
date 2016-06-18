package ua.ozaycev.logistic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.ozaycev.logistic.entity.ProductCategory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionManager;
import java.util.List;

/**
 * Created by Ozaycev on 29.05.2016.
 */

public interface ProductsRepository extends JpaRepository<ProductCategory, Long> {

//    @Autowired
//    @PersistenceContext(unitName = "Main")
//    EntityManager entityManager = null;

//   List<ProductCategory> findByName(String name);
}