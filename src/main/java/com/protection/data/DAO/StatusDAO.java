package com.protection.data.DAO;
import com.protection.data.models.StatusesEntity;

import java.util.List;

public interface StatusDAO {
    StatusesEntity findById(int id);
    StatusesEntity FindByLogin(String title);
    List<StatusesEntity> findAllStatuses();
}
