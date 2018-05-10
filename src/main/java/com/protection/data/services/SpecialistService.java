package com.protection.data.services;

import com.protection.data.models.SpecialistsEntity;
import com.protection.data.models.UsersEntity;

import java.util.List;

public interface SpecialistService {
    SpecialistsEntity findById(int id);
    SpecialistsEntity FindByTitle(String title);
    List<SpecialistsEntity> findAllSpecialist();
    List<SpecialistsEntity> findSpecialist(UsersEntity user);
    void saveSpecialist(SpecialistsEntity specialist);
    void deleteSpecialist(int id);
}
