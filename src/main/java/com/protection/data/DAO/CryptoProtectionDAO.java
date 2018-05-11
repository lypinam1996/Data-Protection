package com.protection.data.DAO;
import com.protection.data.models.TypeofcryptoprotectionEntity;

import java.util.List;

public interface CryptoProtectionDAO {
    List<TypeofcryptoprotectionEntity> findAllStatuses();
}
