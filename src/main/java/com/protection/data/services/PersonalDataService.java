package com.protection.data.services;

import com.protection.data.models.PersonaldataEntity;

import java.util.List;

public interface PersonalDataService {
    List<PersonaldataEntity> findAll();
}
