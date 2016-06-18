package ua.ozaycev.logistic.services.implementation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.ozaycev.logistic.dao.ProductsRepository;
import ua.ozaycev.logistic.entity.Products;
import ua.ozaycev.logistic.services.ProductsService;

import java.util.List;


/**
 * Created by Yulian Bulbuk on 21.05.2016.
 */
@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    @Qualifier("productsRepository")
    private ProductsRepository productsRepository;

    @Transactional
    public void add(String name, String country) {

    }

    @Transactional
    public void edit(long id, String name, String country) {

    }

    @Transactional
    public Products findById(long id) {
        return null;
    }

    @Transactional
    public List<Products> findAll() {
        return null;
    }

    @Transactional
    public List<Products> findByName(String name) {
        return null;
    }

//
//
//    @Transactional
//    public void add(String name, String country) {
//        Author author = new Author(name, country);
//        authorDao.add(author);
//    }
//
//    @Transactional
//    public void edit(int id, String name, String country) {
//        Author author = authorDao.findById(id);
//        if(name!=null){
//            author.setName(name);
//        }
//        if(country!=null){
//            author.setCountry(country);
//        }
//        authorDao.edit(author);
//    }
//
//    @Transactional
//    public Author findById(int id) {
//        return authorDao.findById(id);
//    }
//
//    @Transactional
//    public List<Author> findAll() {
//        return authorDao.findAll();
//    }
//
//    @Transactional
//    public List<Author> findByName(String name) {
//        return authorDao.findByName(name);
//    }
}
