package com.protection.data.services;

import com.protection.data.DAO.FinancingDAO;
import com.protection.data.models.FinancingEntity;
import com.protection.data.models.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("FinancinService")
@Transactional
public class FinancingServiceImpl implements FinancinService{

    @Autowired
    FinancingDAO financingDAO;


    @Override
    public FinancingEntity findById(int id) {
        return financingDAO.findById(id);
    }

    @Override
    public FinancingEntity FindByTitle(String title) {
        return financingDAO.FindByTitle(title);
    }

    @Override
    public List<FinancingEntity> findAllFinancing() {
        return financingDAO.findAllFinancing();
    }

    @Override
    public List<FinancingEntity> findFinancing(UsersEntity user) {
        return financingDAO.findAllFinancing();
    }

    @Override
    public void saveFinancing(FinancingEntity financingEntity) {
        financingDAO.saveFinancing(financingEntity);
    }

    @Override
    public void deleteFinancing(int id) {
        financingDAO.deleteFinancing(id);
    }

    @Override
    public int findMaxFinancing() {
        return financingDAO.findMaxFinancing();
    }
}
