package com.protection.data.services;

import com.protection.data.DAO.CategoryOfSubjectDAO;
import com.protection.data.models.CategoryofsubjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("CategoryOfSubjectService")
@Transactional
public class CategoryOfSubjectServiceImpl implements CategoryOfSubjectService {

    @Autowired
    private CategoryOfSubjectDAO categoryOfSubjectDAO;

    @Override
    public List<CategoryofsubjectEntity> findAll() {
        return categoryOfSubjectDAO.findAll();
    }
}
