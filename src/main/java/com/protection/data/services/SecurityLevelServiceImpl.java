package com.protection.data.services;

import com.protection.data.DAO.SecurityLevelDAO;
import com.protection.data.models.SecuritylevelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("SecurityLevelService")
@Transactional
public class SecurityLevelServiceImpl implements SecurityLevelService {

    @Autowired
    private SecurityLevelDAO securityLevelDAO;

    @Override
    public List<SecuritylevelEntity> findAll() {
        return securityLevelDAO.findAll();
    }
}
