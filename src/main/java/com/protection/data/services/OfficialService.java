package com.protection.data.services;

import com.protection.data.models.OfficialEntity;
import com.protection.data.models.UsersEntity;

import java.util.List;

public interface OfficialService {
    OfficialEntity findById(int id);
    List<OfficialEntity> FindByTitle(String title);
    List<OfficialEntity> findAllOfficials();
    List<OfficialEntity> findOfficials(UsersEntity user);
    void saveOfficial(OfficialEntity official);
    void updateOfficial(OfficialEntity official1);
    void deleteUser(int id);
    int findMaxOfficial();
}
