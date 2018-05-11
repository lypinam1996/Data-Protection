package com.protection.data.services;

import com.protection.data.DAO.CryptoProtectionDAO;
import com.protection.data.models.TypeofcryptoprotectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("CryptoProtectionService")
@Transactional
public class CryptoProtectionServiceImpl implements CryptoProtectionService{

    @Autowired
    CryptoProtectionDAO subject;


    @Override
    public List<TypeofcryptoprotectionEntity> findAllSubjects() {
        return subject.findAllStatuses();
    }
}
