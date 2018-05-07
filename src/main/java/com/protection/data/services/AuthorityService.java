package com.protection.data.services;

import com.protection.data.models.AuthoritiesEntity;

import java.util.List;

public interface AuthorityService {
    AuthoritiesEntity findById(int id);
    AuthoritiesEntity FindByTitle(String title);
    List<AuthoritiesEntity> findAllAuthorities();
}
