package com.protection.data.services;

import com.protection.data.models.QuantityEntity;
import com.protection.data.models.SpecialistsEntity;
import com.protection.data.models.UsersEntity;

import java.util.List;

public interface SpecialistService {
    SpecialistsEntity findById(int id);
    SpecialistsEntity FindByTitle(String title);
    List<SpecialistsEntity> findAllSpecialist();
    List<SpecialistsEntity> findSpecialist(UsersEntity user,  QuantityEntity id);
    void saveSpecialist(SpecialistsEntity specialist);
    void deleteSpecialist(int id);
    int findMaxSpecials();
    List<SpecialistsEntity> findSpecialist( QuantityEntity id);

}
