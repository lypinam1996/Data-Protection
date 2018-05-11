package com.protection.data.DAO;

import com.protection.data.models.StateinformationsystemEntity;
import com.protection.data.models.UsersEntity;

import java.util.List;

public interface StateInformationDAO {
    void updateOfficial(StateinformationsystemEntity official);
    void deleteUser(int id);
    int findMaxOfficial();
    StateinformationsystemEntity findById(int id);
    StateinformationsystemEntity FindByTitle(String title);
    List<StateinformationsystemEntity> findAllStateInformation();
    List<StateinformationsystemEntity> findStateInformation(UsersEntity user);
    void saveStateInformation(StateinformationsystemEntity stateinformationsystem);
}
