package com.protection.data.services;

import com.protection.data.models.StateinformationsystehistoryEntity;
import com.protection.data.models.StateinformationsystemEntity;

import java.util.List;

public interface StateInformationHistoryService {
    StateinformationsystehistoryEntity findById(int id);
    StateinformationsystehistoryEntity FindByTitle(String title);
    List findAllStateInformationHistories();
    List<StateinformationsystehistoryEntity> findStateInformationHistories(StateinformationsystemEntity stateinformationsystem);
    void saveStateInformationHistory(StateinformationsystemEntity stateinformationsystem, StateinformationsystehistoryEntity stateinformationsystehistory);

}
