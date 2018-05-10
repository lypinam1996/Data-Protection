package com.protection.data.services;

import com.protection.data.DAO.QuantityHistoryDAO;
import com.protection.data.models.QuantityEntity;
import com.protection.data.models.QuantityhistoryEntity;
import com.protection.data.models.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("QuantityHistoryService")
@Transactional
public class QuantityHistoryServiceImpl implements QuantityHistoryService{

    @Autowired
    QuantityHistoryDAO quantity;


    @Override
    public QuantityhistoryEntity findById(int id) {
        return quantity.findById(id);
    }

    @Override
    public QuantityhistoryEntity FindByTitle(String title) {
        return quantity.FindByTitle(title);
    }

    @Override
    public List<QuantityhistoryEntity> findAllQuantities() {
        return quantity.findAllQuantities();
    }

    @Override
    public List<QuantityhistoryEntity> findQuantities(UsersEntity user, QuantityEntity quantityEntity) {
        return quantity.findQuantities(user,quantityEntity);
    }

    @Override
    public void saveQuantity(QuantityEntity quantity1,QuantityhistoryEntity quantityhistoryEntity) {
        quantity.saveQuantity(quantity1,quantityhistoryEntity);
    }

    @Override
    public void deleteQuantity(int id) {
        quantity.deleteQuantity(id);
    }
}
