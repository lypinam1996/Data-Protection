package com.protection.data.services;

import com.protection.data.models.OfficialEntity;
import com.protection.data.models.OfficialhistoryEntity;
import com.protection.data.models.UsersEntity;

import java.util.List;

public interface OfficialHistoryService {
    OfficialhistoryEntity findById(int id);
    OfficialhistoryEntity FindByTitle(String title);
    List<OfficialhistoryEntity> findAllOfficials();
    List<OfficialhistoryEntity> findOfficials(UsersEntity user,OfficialEntity officialEntity);
    void saveOfficial(OfficialEntity official, OfficialhistoryEntity officialhistory);
}
