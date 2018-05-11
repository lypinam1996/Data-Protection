package com.protection.data.DAO;

import com.protection.data.models.CategoryofsubjectEntity;
import com.protection.data.models.YesnoEntity;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("YesNoDAO")
public class YesNoDAOImpl extends AbstractDAO<Integer, YesnoEntity> implements YesNoDAO {
    @Override
    public List<YesnoEntity> findAll() {
        Criteria criteria = getSession().createCriteria(YesnoEntity.class);
        return (List<YesnoEntity>)criteria.list();
    }
}
