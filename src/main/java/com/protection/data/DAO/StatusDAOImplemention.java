package com.protection.data.DAO;
import com.protection.data.models.StatusesEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("StatusDAO")
public class StatusDAOImplemention extends AbstractDAO<Integer,StatusesEntity> implements StatusDAO{

    @Override
    public StatusesEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(StatusesEntity.class);
        criteria.add(Restrictions.eq("id", id));
        return (StatusesEntity) criteria.uniqueResult();
    }

    @Override
    public StatusesEntity FindByLogin(String title) {
        Criteria criteria = getSession().createCriteria(StatusesEntity.class);
        criteria.add(Restrictions.eq("title", title));
        return (StatusesEntity) criteria.uniqueResult();
    }

    @Override
    public List<StatusesEntity> findAllStatuses() {
        Criteria criteria = getSession().createCriteria(StatusesEntity.class);
        return (List<StatusesEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
}
