package com.protection.data.DAO;

import com.protection.data.models.AuthoritiesEntity;

import java.util.List;

public interface AuthorityDAO {
    AuthoritiesEntity findById(int id);
    AuthoritiesEntity FindByTitle(String title);
    List<AuthoritiesEntity> findAllAuthorities();
}
