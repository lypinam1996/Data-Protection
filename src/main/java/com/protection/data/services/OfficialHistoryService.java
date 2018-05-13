package com.protection.data.services;

import com.protection.data.models.OfficialEntity;
import com.protection.data.models.OfficialhistoryEntity;

import java.util.List;

public interface OfficialHistoryService {
    OfficialhistoryEntity findById(int id);
    OfficialhistoryEntity FindByTitle(String title);
    List<OfficialhistoryEntity> findAllOfficials();
    List<OfficialhistoryEntity> findOfficials(OfficialEntity officialEntity);
    void saveOfficial(OfficialEntity official, OfficialhistoryEntity officialhistory);
}
