package com.protection.data.DAO;

import com.protection.data.models.CategoryofsubjectEntity;
import com.protection.data.models.CountsubjectsEntity;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CountSubjectsDAO")
public class CountSubjectsDAOImpl extends AbstractDAO<Integer, CountsubjectsEntity> implements CountSubjectsDAO {
    @Override
    public List<CountsubjectsEntity> findAll() {
        Criteria criteria = getSession().createCriteria(CountsubjectsEntity.class);
        return (List<CountsubjectsEntity>)criteria.list();
    }
}
