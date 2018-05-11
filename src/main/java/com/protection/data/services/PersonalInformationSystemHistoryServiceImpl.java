package com.protection.data.services;

import com.protection.data.DAO.PersonalInformationSystemHistoryDAO;
import com.protection.data.models.PersonalinformationsystemEntity;
import com.protection.data.models.PersonalinformationsystemhistoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("PersonalInformationSystemHistoryService")
@Transactional
public class PersonalInformationSystemHistoryServiceImpl implements PersonalInformationSystemHistoryService {

    @Autowired
    PersonalInformationSystemHistoryDAO historyDAO;

    @Override
    public PersonalinformationsystemhistoryEntity findById(int id) {
        return historyDAO.findById(id);
    }

    @Override
    public PersonalinformationsystemhistoryEntity FindByTitle(String title) {
        return historyDAO.FindByTitle(title);
    }

    @Override
    public List<PersonalinformationsystemhistoryEntity> findAllPersonalInformationSystemHistories() {
        return historyDAO.findAllPersonalInformationSystemHistories();
    }

    @Override
    public List<PersonalinformationsystemhistoryEntity> findPersonalInformationSystemHistories(PersonalinformationsystemEntity personalinformationsystem) {
        return historyDAO.findPersonalInformationSystemHistories(personalinformationsystem);
    }

    @Override
    public void saveHistory(PersonalinformationsystemEntity personalinformationsystem, PersonalinformationsystemhistoryEntity personalinformationsystemhistory) {
        historyDAO.saveHistory(personalinformationsystem, personalinformationsystemhistory);
    }
}
