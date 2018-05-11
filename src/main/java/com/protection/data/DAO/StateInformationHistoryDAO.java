package com.protection.data.DAO;

import com.protection.data.models.*;

import java.util.List;

public interface StateInformationHistoryDAO {

    StateinformationsystehistoryEntity findById(int id);
    StateinformationsystehistoryEntity FindByTitle(String title);
    List findAllStateInformationHistories();
    List<StateinformationsystehistoryEntity> findStateInformationHistories(StateinformationsystemEntity stateinformationsystem);
    void saveStateInformationHistory(StateinformationsystemEntity stateinformationsystem, StateinformationsystehistoryEntity stateinformationsystehistory);
}
