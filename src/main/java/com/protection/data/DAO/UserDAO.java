package com.protection.data.DAO;

import com.protection.data.models.UsersEntity;

import java.util.List;

public interface UserDAO {
    UsersEntity findById(int id);
    UsersEntity FindByLogin(String title);
    List<UsersEntity> findAllUsers();
    void saveUser(UsersEntity user);
    List<UsersEntity> findAllUsersWhereControlEquals1();
    void confirmRegistration(UsersEntity user);
    void deleteUser(int id_lock);
    List<UsersEntity> findAllUsersWhereControlEquals2();
}
