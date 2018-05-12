package com.protection.data.DAO;
import com.protection.data.models.OfficialEntity;
import com.protection.data.models.UsersEntity;

import java.util.List;

public interface OfficialDAO {
    OfficialEntity findById(int id);
    OfficialEntity FindByTitle(String title);
    List<OfficialEntity> findAllOfficials();
    List<OfficialEntity> findOfficials(UsersEntity user);
    void saveOfficial(OfficialEntity official);
    void updateOfficial(OfficialEntity official);
    void deleteUser(int id);
    int findMaxOfficial();
}