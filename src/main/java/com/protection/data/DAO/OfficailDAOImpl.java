package com.protection.data.DAO;

import com.protection.data.models.OfficialEntity;
import com.protection.data.models.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("OfficialDAO")
public class OfficailDAOImpl extends AbstractDAO<Integer,OfficialEntity> implements OfficialDAO{

    @Override
    public OfficialEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(OfficialEntity.class);
        criteria.add(Restrictions.eq("id", id));
        return (OfficialEntity) criteria.uniqueResult();
    }

    @Override
    public OfficialEntity FindByTitle(String title) {
        Criteria criteria = getSession().createCriteria(OfficialEntity.class);
        criteria.add(Restrictions.eq("title", title));
        return (OfficialEntity) criteria.uniqueResult();
    }

    @Override
    public List<OfficialEntity> findAllOfficials() {
        Criteria criteria = getSession().createCriteria(OfficialEntity.class);
        return (List<OfficialEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public List<OfficialEntity> findOfficials(UsersEntity user){
        Criteria criteria = getSession().createCriteria(OfficialEntity.class);
        criteria.add(Restrictions.eq("user", user));
        return (List<OfficialEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
    @Override
    public void saveOfficial(OfficialEntity official) {
        getSession().save(official);

    }


}
