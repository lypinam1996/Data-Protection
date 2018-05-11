package com.protection.data.services;

import com.protection.data.DAO.CountSubjectsDAO;
import com.protection.data.models.CountsubjectsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CountSubjectsService")
public class CountSubjectsServiceImpl implements CountSubjectsService {

    @Autowired
    private CountSubjectsDAO countSubjectsDAO;

    @Override
    public List<CountsubjectsEntity> findAll() {
        return countSubjectsDAO.findAll();
    }
}
