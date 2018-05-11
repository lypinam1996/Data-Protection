package com.protection.data.DAO;

import com.protection.data.models.OfficialEntity;
import com.protection.data.models.PersonalinformationsystemEntity;
import com.protection.data.models.PersonalinformationsystemhistoryEntity;
import com.protection.data.models.UsersEntity;

import java.util.List;

public interface PersonalInformationSystemHistoryDAO {
    PersonalinformationsystemhistoryEntity findById(int id);

    PersonalinformationsystemhistoryEntity FindByTitle(String title);

    List<PersonalinformationsystemhistoryEntity> findAllPersonalInformationSystemHistories();

    List<PersonalinformationsystemhistoryEntity> findPersonalInformationSystemHistories(PersonalinformationsystemEntity personalinformationsystem);

    void saveHistory(PersonalinformationsystemEntity personalinformationsystem, PersonalinformationsystemhistoryEntity personalinformationsystemhistory);
//    void updateOfficial(OfficialEntity official);
//    void delete(int id);
}
