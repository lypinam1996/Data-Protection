package com.protection.data.services;

import com.protection.data.DAO.PersonalInformationDAO;
import com.protection.data.models.PersonalinformationsystemEntity;
import com.protection.data.models.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("PersonalService")
@Transactional
public class PersonalServiceImpl implements PersonalService {
    @Autowired
    private PersonalInformationDAO personalInformationDAO;


    @Override
    public void updatePersonal(PersonalinformationsystemEntity personal) {
        personalInformationDAO.updatePersonal(personal);
    }

    @Override
    public void deletePersonal(int id) {
        personalInformationDAO.deletePersonal(id);
    }

    @Override
    public int findMaxPersonal() {
        return personalInformationDAO.findMaxPersonal();
    }

    @Override
    public PersonalinformationsystemEntity findById(int id) {
        return personalInformationDAO.findById(id);
    }

    @Override
    public PersonalinformationsystemEntity FindByTitle(String title) {
        return personalInformationDAO.FindByTitle(title);
    }

    @Override
    public List<PersonalinformationsystemEntity> findAllPersonal() {
        return personalInformationDAO.findAllPersonal();
    }

    @Override
    public List<PersonalinformationsystemEntity> findPersonal(UsersEntity user) {
        return personalInformationDAO.findAllPersonal();
    }

    @Override
    public void savePersonal(PersonalinformationsystemEntity personal) {
personalInformationDAO.savePersonal(personal);
    }
}
