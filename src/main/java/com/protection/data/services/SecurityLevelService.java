package com.protection.data.services;

import com.protection.data.models.SecuritylevelEntity;

import java.util.List;

public interface SecurityLevelService {
    List<SecuritylevelEntity> findAll();
}
