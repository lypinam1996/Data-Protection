package com.protection.data.services;

import com.protection.data.DAO.StatusDAO;
import com.protection.data.DAO.UserDAO;
import com.protection.data.models.StatusesEntity;
import com.protection.data.models.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("UsersService")
@Transactional
public class UserServiceImplementation implements UserService {

    @Autowired
    UserDAO userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    StatusDAO statusDAO;

    @Override
    public UsersEntity findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public UsersEntity FindByLogin(String title) {
        return userDao.FindByLogin(title);
    }

    @Override
    public List<UsersEntity> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public void saveUser(UsersEntity user) {
        StatusesEntity status = statusDAO.findById(2);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(status);
        user.setControl(1);
        userDao.saveUser(user);
    }
    @Override
    public void updateUser(UsersEntity user) {
        userDao.saveUser(user);
    }


    @Override
    public List<UsersEntity> findAllUsersWhereControlEquals1() {
        return userDao.findAllUsersWhereControlEquals1();
    }

    @Override
    public void confirmRegistration(UsersEntity user) {
        userDao.confirmRegistration(user);
    }

    @Override
    public void deleteUser(int id_lock) {
        userDao.deleteUser(id_lock);
    }
}
