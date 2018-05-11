package com.protection.data.DAO;

import com.protection.data.models.CategoryofsubjectEntity;
import com.protection.data.models.CountsubjectsEntity;

import java.util.List;

public interface CountSubjectsDAO {

    List<CountsubjectsEntity> findAll();
}
