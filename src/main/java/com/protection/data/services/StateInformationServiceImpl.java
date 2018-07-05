package com.protection.data.services;

import com.protection.data.DAO.StateInformationDAO;
import com.protection.data.models.StateinformationsystemEntity;
import com.protection.data.models.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("StateInformationService")
@Transactional
public class StateInformationServiceImpl implements StateInformationService {

@Autowired
private StateInformationDAO stateInformationDAO;

@Override
public void updateOfficial(StateinformationsystemEntity official) {
        stateInformationDAO.updateOfficial(official);
        }

@Override
public void deleteUser(int id) {
        stateInformationDAO.deleteUser(id);
        }

@Override
public int findMaxOfficial() {
        return stateInformationDAO.findMaxOfficial();
        }

@Override
public StateinformationsystemEntity findById(int id) {
        return stateInformationDAO.findById(id);
        }

@Override
public StateinformationsystemEntity FindByTitle(String title) {
        return stateInformationDAO.FindByTitle(title);
        }

@Override
public List<StateinformationsystemEntity> findAllStateInformation() {
        return stateInformationDAO.findAllStateInformation();
        }

    @Override
    public List<StateinformationsystemEntity> findStateInformation(UsersEntity user) {
        return stateInformationDAO.findStateInformation(user);
    }


    @Override
public void saveStateInformation(StateinformationsystemEntity stateinformationsystem) {
        stateInformationDAO.saveStateInformation(stateinformationsystem);
        }


}

