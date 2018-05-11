package com.protection.data.services;

import com.protection.data.DAO.YesNoDAO;
import com.protection.data.models.YesnoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("YesNoService")
@Transactional
public class YesNoServiceImpl implements YesNoService {

    @Autowired
    private YesNoDAO yesNoDAO;

    @Override
    public List<YesnoEntity> findAll() {
        return yesNoDAO.findAll();
    }
}
