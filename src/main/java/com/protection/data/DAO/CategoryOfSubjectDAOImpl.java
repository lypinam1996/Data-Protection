package com.protection.data.DAO;

import com.protection.data.models.CategoryofsubjectEntity;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CategoryOfSubjectDAO")
public class CategoryOfSubjectDAOImpl extends AbstractDAO<Integer, CategoryofsubjectEntity> implements  CategoryOfSubjectDAO {
    @Override
    public List<CategoryofsubjectEntity> findAll() {
        Criteria criteria = getSession().createCriteria(CategoryofsubjectEntity.class);
        return (List<CategoryofsubjectEntity>)criteria.list();
    }
}
