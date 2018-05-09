package com.protection.data.services;

import com.protection.data.DAO.OfficialHistoryDAO;
import com.protection.data.models.OfficialEntity;
import com.protection.data.models.OfficialhistoryEntity;
import com.protection.data.models.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("OfficialHistoryService")
@Transactional
public class OfficialHistoryServiceImpl implements OfficialHistoryService{

    @Autowired
    OfficialHistoryDAO official;

    @Override
    public OfficialhistoryEntity findById(int id) {
        return official.findById(id);
    }

    @Override
    public OfficialhistoryEntity FindByTitle(String title) {
        return official.FindByTitle(title);
    }

    @Override
    public List<OfficialhistoryEntity> findAllOfficials() {
        return official.findAllOfficials();
    }
    @Override
    public List<OfficialhistoryEntity> findOfficials(UsersEntity user,OfficialEntity officialEntity) {
        return official.findOfficials(user,officialEntity);
    }
    @Override
    public void saveOfficial(OfficialEntity official1,OfficialhistoryEntity officialhistory){
        official.saveOfficial(official1,officialhistory);
    }



}
