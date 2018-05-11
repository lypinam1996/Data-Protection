package com.protection.data.services;

import com.protection.data.models.PersonalinformationsystemEntity;
import com.protection.data.models.PersonalinformationsystemhistoryEntity;

import java.util.List;

public interface PersonalInformationSystemHistoryService {
    PersonalinformationsystemhistoryEntity findById(int id);

    PersonalinformationsystemhistoryEntity FindByTitle(String title);

    List<PersonalinformationsystemhistoryEntity> findAllPersonalInformationSystemHistories();

    List<PersonalinformationsystemhistoryEntity> findPersonalInformationSystemHistories(PersonalinformationsystemEntity personalinformationsystem);

    void saveHistory(PersonalinformationsystemEntity personalinformationsystem, PersonalinformationsystemhistoryEntity personalinformationsystemhistory);

}
