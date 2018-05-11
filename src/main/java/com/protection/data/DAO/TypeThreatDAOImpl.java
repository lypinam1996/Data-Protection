package com.protection.data.DAO;

import com.protection.data.models.CategoryofsubjectEntity;
import com.protection.data.models.TypethreatEntity;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("TypeThreatDAO")
public class TypeThreatDAOImpl extends AbstractDAO<Integer, TypethreatEntity> implements TypeThreatDAO {
    @Override
    public List<TypethreatEntity> findAll() {
        Criteria criteria = getSession().createCriteria(TypethreatEntity.class);
        return (List<TypethreatEntity>)criteria.list();
    }
}
