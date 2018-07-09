package com.protection.data.services;

import com.protection.data.DAO.SpecialistDAO;
import com.protection.data.models.QuantityEntity;
import com.protection.data.models.SpecialistsEntity;
import com.protection.data.models.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("SpecialistService")
@Transactional
public class SpecialistServiceImpl implements SpecialistService {

    @Autowired
    SpecialistDAO specialist;




    @Override
    public SpecialistsEntity findById(int id) {
        return specialist.findById(id);
    }

    @Override
    public SpecialistsEntity FindByTitle(String title) {
        return specialist.FindByTitle(title);
    }

    @Override
    public List<SpecialistsEntity> findAllSpecialist() {
        return specialist.findAllSpecialist();
    }

    @Override
    public List<SpecialistsEntity> findSpecialist(UsersEntity user, QuantityEntity id) {
        return specialist.findSpecialist(user,id);
    }

    @Override
    public void saveSpecialist(SpecialistsEntity specialist1) {
        specialist.saveSpecialist(specialist1);
    }

    @Override
    public void deleteSpecialist(int id) {
        specialist.deleteSpecialist(id);
    }

    @Override
    public int findMaxSpecials() {
        return specialist.findMaxSpecials();
    }

    @Override
    public List<SpecialistsEntity> findSpecialist(QuantityEntity id) {
        return specialist.findSpecialist(id);
    }
}
