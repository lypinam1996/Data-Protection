package com.protection.data.DAO;
import com.protection.data.models.SpecialistsEntity;
import com.protection.data.models.UsersEntity;

import java.util.List;

public interface SpecialistDAO {
    SpecialistsEntity findById(int id);
    SpecialistsEntity FindByTitle(String title);
    List<SpecialistsEntity> findAllSpecialist();
    List<SpecialistsEntity> findSpecialist(UsersEntity user);
    void saveSpecialist(SpecialistsEntity specialist);
    void deleteSpecialist(int id);
}
