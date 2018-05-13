package com.protection.data.DAO;
import com.protection.data.models.FinancingEntity;
import com.protection.data.models.FinancinghistoryEntity;

import java.util.List;

public interface FinancingHistoryDAO {
    FinancinghistoryEntity findById(int id);
    FinancinghistoryEntity FindByTitle(String title);
    List<FinancinghistoryEntity> findAllFinancing();
    List<FinancinghistoryEntity> findFinancing( FinancingEntity quantityEntity);
    void saveFinancing(FinancingEntity quantity, FinancinghistoryEntity quantityhistoryEntity);
    void deleteFinancing(int id);
}
