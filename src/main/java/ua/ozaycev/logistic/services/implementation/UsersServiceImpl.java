package ua.ozaycev.logistic.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.ozaycev.logistic.dao.UsersRepository;
import ua.ozaycev.logistic.entity.Users;
import ua.ozaycev.logistic.services.UsersService;


import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ozaycev on 04.06.2016.
 */
@Service("usersDetailsService")
public class UsersServiceImpl implements UsersService, UserDetailsService {

    @Autowired
    private UsersRepository usersDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = null;
        try {
            users = usersDao.findUserByLogin(username);
        } catch (NoResultException e) {
            return  null;
        }
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new User(String.valueOf(users.getId()), users.getPassword(),authorityList);
    }

    @Override
    public void add(Users users) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        usersDao.save(users);
    }

    @Override
    public Users findByID(int id) {
        return usersDao.findByID(id);
    }
}
