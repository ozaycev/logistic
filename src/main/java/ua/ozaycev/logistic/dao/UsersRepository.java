package ua.ozaycev.logistic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ua.ozaycev.logistic.entity.ProductCategory;
import ua.ozaycev.logistic.entity.Users;

import java.util.List;

/**
 * Created by Ozaycev on 04.06.2016.
 */
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Transactional
    Users findUserByLogin(String login);

     @Transactional
     Users findByID(long id);

}
