package com.protection.data.DAO;

import com.protection.data.models.PersonalinformationsystemEntity;
import com.protection.data.models.UsersEntity;

import java.util.List;

public interface PersonalInformationDAO {
    void updatePersonal(PersonalinformationsystemEntity personal);
    void deletePersonal(int id);
    int findMaxPersonal();
    PersonalinformationsystemEntity findById(int id);
    PersonalinformationsystemEntity FindByTitle(String title);
    List<PersonalinformationsystemEntity> findAllPersonal();
    List<PersonalinformationsystemEntity> findPersonal(UsersEntity user);
    void savePersonal(PersonalinformationsystemEntity personal);
}
