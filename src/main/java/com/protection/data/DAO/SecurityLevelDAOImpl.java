package com.protection.data.DAO;

import com.protection.data.models.CategoryofsubjectEntity;
import com.protection.data.models.SecuritylevelEntity;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("SecurityLevelDAO")
public class SecurityLevelDAOImpl extends AbstractDAO<Integer, SecuritylevelEntity> implements SecurityLevelDAO{
    @Override
    public List<SecuritylevelEntity> findAll() {
        Criteria criteria = getSession().createCriteria(SecuritylevelEntity.class);
        return (List<SecuritylevelEntity>)criteria.list();
    }
}
