package com.protection.data.DAO;
import com.protection.data.models.QuantityEntity;
import com.protection.data.models.SpecialistsEntity;
import com.protection.data.models.SpecialistshistoryEntity;
import com.protection.data.models.UsersEntity;

import java.util.List;

public interface SpecialistHistoryDAO {
    SpecialistshistoryEntity findById(int id);
    SpecialistshistoryEntity FindByTitle(String title);
    List<SpecialistshistoryEntity> findAllSpecialist();
    List<SpecialistshistoryEntity> findSpecialist(UsersEntity user, QuantityEntity id);
    void saveSpecialist(SpecialistsEntity official, SpecialistshistoryEntity officialhistory);
    void deleteSpecialist(int id);
    List<SpecialistshistoryEntity> findSpecialist2(UsersEntity user, SpecialistsEntity id);
    List<SpecialistshistoryEntity> findSpecialist2( SpecialistsEntity id);
}
