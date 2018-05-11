package com.protection.data.services;

import com.protection.data.DAO.StateInformationHistoryDAO;
import com.protection.data.models.StateinformationsystehistoryEntity;
import com.protection.data.models.StateinformationsystemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("StateInformationSystemService")
@Transactional
public class StateInformationServiceImpl implements StateInformationHistoryService {

    @Autowired
    private StateInformationHistoryDAO historyDAO;

    @Override
    public StateinformationsystehistoryEntity findById(int id) {
        return historyDAO.findById(id);
    }

    @Override
    public StateinformationsystehistoryEntity FindByTitle(String title) {
        return historyDAO.FindByTitle(title);
    }

    @Override
    public List<StateinformationsystehistoryEntity> findAllStateInformationHistories() {
        return historyDAO.findAllStateInformationHistories();
    }

    @Override
    public List<StateinformationsystehistoryEntity> findStateInformationHistories(StateinformationsystemEntity stateinformationsystem) {
        return historyDAO.findStateInformationHistories(stateinformationsystem);
    }

    @Override
    public void saveStateInformationHistory(StateinformationsystemEntity stateinformationsystem, StateinformationsystehistoryEntity stateinformationsystehistory) {
        historyDAO.saveStateInformationHistory(stateinformationsystem, stateinformationsystehistory);
    }
}
