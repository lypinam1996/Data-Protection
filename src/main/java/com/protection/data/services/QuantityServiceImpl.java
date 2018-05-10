package com.protection.data.services;

import com.protection.data.DAO.QuantityDAO;
import com.protection.data.models.QuantityEntity;
import com.protection.data.models.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("QuantityService")
@Transactional
public class QuantityServiceImpl implements QuantityService{

    @Autowired
    QuantityDAO quantity;


    @Override
    public QuantityEntity findById(int id) {
        return quantity.findById(id);
    }

    @Override
    public QuantityEntity FindByTitle(String title) {
        return quantity.FindByTitle(title);
    }

    @Override
    public List<QuantityEntity> findAllQuantities() {
        return quantity.findAllQuantities();
    }

    @Override
    public List<QuantityEntity> findQuantities(UsersEntity user) {
        return quantity.findQuantities(user);
    }

    @Override
    public void saveQuantity(QuantityEntity quantity1) {
        quantity.saveQuantity(quantity1);
    }

    @Override
    public void deleteQuantity(int id) {
        quantity.deleteQuantity(id);
    }

    @Override
    public int findMaxOfficial() {
        return quantity.findMaxOfficial();
    }
}
