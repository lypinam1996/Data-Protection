package com.protection.data.DAO;

import com.protection.data.models.CategoryofsubjectEntity;
import com.protection.data.models.SecuritylevelEntity;

import java.util.List;

public interface SecurityLevelDAO {

    List<SecuritylevelEntity> findAll();
}
