package com.protection.data.DAO;
import com.protection.data.models.QuantityEntity;
import com.protection.data.models.QuantityhistoryEntity;

import java.util.List;

public interface QuantityHistoryDAO {
    QuantityhistoryEntity findById(int id);
    QuantityhistoryEntity FindByTitle(String title);
    List<QuantityhistoryEntity> findAllQuantities();
    List<QuantityhistoryEntity> findQuantities( QuantityEntity quantityEntity);
    void saveQuantity(QuantityEntity quantity,QuantityhistoryEntity quantityhistoryEntity);
    void deleteQuantity(int id);
}
