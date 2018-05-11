package com.protection.data.services;

import com.protection.data.DAO.PersonalDataDAO;
import com.protection.data.models.PersonaldataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("PersonalDataService")
@Transactional
public class PersonalDataServiceImpl implements PersonalDataService {
    @Autowired
    private PersonalDataDAO personalDataDAO;

    @Override
    public List<PersonaldataEntity> findAll() {
        return personalDataDAO.findAll();
    }
}
