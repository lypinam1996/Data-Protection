package com.protection.data.services;

import com.protection.data.models.FinancingEntity;
import com.protection.data.models.UsersEntity;

import java.util.List;


public interface FinancinService{
    FinancingEntity findById(int id);
    FinancingEntity FindByTitle(String title);
    List<FinancingEntity> findAllFinancing();
    List<FinancingEntity> findFinancing(UsersEntity user);
    void saveFinancing(FinancingEntity financingEntity);
    void deleteFinancing(int id);
    int findMaxFinancing();
}
