package com.protection.data.services;

import com.protection.data.DAO.AuthorityDAO;
import com.protection.data.models.AuthoritiesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("AuthorityService")
@Transactional
public class AuthorityServiceImpl implements AuthorityService{

    @Autowired
    AuthorityDAO authority;

    @Override
    public AuthoritiesEntity findById(int id) {
        return authority.findById(id);
    }

    @Override
    public AuthoritiesEntity FindByTitle(String title) {
        return authority.FindByTitle(title);
    }

    @Override
    public List<AuthoritiesEntity> findAllAuthorities() {
        return authority.findAllAuthorities();
    }

}
