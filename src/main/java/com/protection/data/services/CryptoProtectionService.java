package com.protection.data.services;


import com.protection.data.models.TypeofcryptoprotectionEntity;

import java.util.List;

public interface CryptoProtectionService {
    List<TypeofcryptoprotectionEntity> findAllSubjects();
}
