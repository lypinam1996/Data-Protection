package com.protection.data.services;

import com.protection.data.models.QuantityEntity;
import com.protection.data.models.UsersEntity;

import java.util.List;

public interface QuantityService {
    QuantityEntity findById(int id);
    QuantityEntity FindByTitle(String title);
    List<QuantityEntity> findAllQuantities();
    List<QuantityEntity> findQuantities(UsersEntity user);
    void saveQuantity(QuantityEntity quantity);
    void deleteQuantity(int id);
}
