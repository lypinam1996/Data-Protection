package com.protection.data.DAO;

import com.protection.data.models.CategoryofsubjectEntity;
import com.protection.data.models.YesnoEntity;

import java.util.List;

public interface YesNoDAO {

    List<YesnoEntity> findAll();
}
