package com.protection.data.services;

import com.protection.data.DAO.SpecialistHistoryDAO;
import com.protection.data.models.SpecialistsEntity;
import com.protection.data.models.SpecialistshistoryEntity;
import com.protection.data.models.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("SpecialistHistotyService")
@Transactional
public class SpecialistHistoryServiceImpl implements SpecialistHistotyService {

    @Autowired
    SpecialistHistoryDAO specialist;


    @Override
    public SpecialistshistoryEntity findById(int id) {
        return specialist.findById(id);
    }

    @Override
    public SpecialistshistoryEntity FindByTitle(String title) {
        return specialist.FindByTitle(title);
    }

    @Override
    public List<SpecialistshistoryEntity> findAllSpecialist() {
        return specialist.findAllSpecialist();
    }


    @Override
    public void saveSpecialist(SpecialistsEntity official1, SpecialistshistoryEntity officialhistory) {
        specialist.saveSpecialist(official1,officialhistory);
    }

    @Override
    public void deleteSpecialist(int id) {
        specialist.deleteSpecialist(id);
    }

    @Override
    public List<SpecialistshistoryEntity> findSpecialist2(UsersEntity user, SpecialistsEntity id) {
        return specialist.findSpecialist2(user,id);
    }

    @Override
    public List<SpecialistshistoryEntity> findSpecialist2(SpecialistsEntity id) {
        return specialist.findSpecialist2(id);
    }

}
