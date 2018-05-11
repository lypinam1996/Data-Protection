package com.protection.data.DAO;

import com.protection.data.models.CategoryofsubjectEntity;
import com.protection.data.models.TypethreatEntity;

import java.util.List;

public interface TypeThreatDAO {

    List<TypethreatEntity> findAll();
}
