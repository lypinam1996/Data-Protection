package com.protection.data.services;

import com.protection.data.models.QuantityEntity;
import com.protection.data.models.QuantityhistoryEntity;
import com.protection.data.models.UsersEntity;

import java.util.List;

public interface QuantityHistoryService {
    QuantityhistoryEntity findById(int id);
    QuantityhistoryEntity FindByTitle(String title);
    List<QuantityhistoryEntity> findAllQuantities();
    List<QuantityhistoryEntity> findQuantities(UsersEntity user, QuantityEntity quantityEntity);
    void saveQuantity(QuantityEntity quantity,QuantityhistoryEntity quantityhistoryEntity);
    void deleteQuantity(int id);
}
