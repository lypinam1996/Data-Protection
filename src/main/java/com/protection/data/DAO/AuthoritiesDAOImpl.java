package com.protection.data.DAO;


import com.protection.data.models.AuthoritiesEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AuthorityDAO")
public class AuthoritiesDAOImpl extends AbstractDAO<Integer,AuthoritiesEntity> implements AuthorityDAO{

    @Override
    public AuthoritiesEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(AuthoritiesEntity.class);
        criteria.add(Restrictions.eq("idAuthorities", id));
        return (AuthoritiesEntity) criteria.uniqueResult();
    }

    @Override
    public AuthoritiesEntity FindByTitle(String title) {
        Criteria criteria = getSession().createCriteria(AuthoritiesEntity.class);
        criteria.add(Restrictions.eq("title", title));
        return (AuthoritiesEntity) criteria.uniqueResult();
    }

    @Override
    public List<AuthoritiesEntity> findAllAuthorities() {
        Criteria criteria = getSession().createCriteria(AuthoritiesEntity.class);
        return (List<AuthoritiesEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

}
