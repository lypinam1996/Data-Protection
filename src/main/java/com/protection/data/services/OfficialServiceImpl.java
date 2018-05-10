package com.protection.data.services;

import com.protection.data.DAO.OfficialDAO;
import com.protection.data.models.OfficialEntity;
import com.protection.data.models.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("OfficialService")
@Transactional
public class OfficialServiceImpl implements OfficialService{

    @Autowired
    OfficialDAO official;

    @Override
    public OfficialEntity findById(int id) {
        return official.findById(id);
    }

    @Override
    public OfficialEntity FindByTitle(String title) {
        return official.FindByTitle(title);
    }

    @Override
    public List<OfficialEntity> findAllOfficials() {
        return official.findAllOfficials();
    }
    @Override
    public List<OfficialEntity> findOfficials(UsersEntity user) {
        return official.findOfficials(user);
    }
    @Override
    public void saveOfficial(OfficialEntity official1){
        official.saveOfficial(official1);
    }

    @Override
    public void updateOfficial(OfficialEntity official1) {
        official.updateOfficial(official1);
    }

    @Override
    public void deleteUser(int id) {
        official.deleteUser(id);
    }

    @Override
    public int findMaxOfficial() {
        return official.findMaxOfficial();
    }


}
