package com.protection.data.services;

import com.protection.data.DAO.FinancingHistoryDAO;
import com.protection.data.models.FinancingEntity;
import com.protection.data.models.FinancinghistoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("FinancingHistoryService")
@Transactional
public class FinancingHistoryServiceImpl implements FinancingHistoryService{

    @Autowired
    FinancingHistoryDAO financingDAO;


    @Override
    public FinancinghistoryEntity findById(int id) {
        return financingDAO.findById(id);
    }

    @Override
    public FinancinghistoryEntity FindByTitle(String title) {
        return financingDAO.FindByTitle(title);
    }

    @Override
    public List<FinancinghistoryEntity> findAllFinancing() {
        return financingDAO.findAllFinancing();
    }

    @Override
    public List<FinancinghistoryEntity> findFinancing( FinancingEntity quantityEntity) {
        return financingDAO.findFinancing(quantityEntity);
    }

    @Override
    public void saveFinancing(FinancingEntity quantity, FinancinghistoryEntity quantityhistoryEntity) {
        financingDAO.saveFinancing(quantity,quantityhistoryEntity);
    }

    @Override
    public void deleteFinancing(int id) {
        financingDAO.deleteFinancing(id);
    }
}
