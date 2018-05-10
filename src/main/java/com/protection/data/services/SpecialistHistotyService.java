package com.protection.data.services;

import com.protection.data.models.SpecialistsEntity;
import com.protection.data.models.SpecialistshistoryEntity;
import com.protection.data.models.UsersEntity;

import java.util.List;

public interface SpecialistHistotyService {
    SpecialistshistoryEntity findById(int id);
    SpecialistshistoryEntity FindByTitle(String title);
    List<SpecialistshistoryEntity> findAllSpecialist();
    void saveSpecialist(SpecialistsEntity official, SpecialistshistoryEntity officialhistory);
    void deleteSpecialist(int id);
    List<SpecialistshistoryEntity> findSpecialist2(UsersEntity user, SpecialistsEntity id);
}
