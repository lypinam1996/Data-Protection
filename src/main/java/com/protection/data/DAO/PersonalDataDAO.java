package com.protection.data.DAO;

import com.protection.data.models.PersonaldataEntity;

import java.util.List;

public interface PersonalDataDAO {
    List<PersonaldataEntity> findAll();
}
