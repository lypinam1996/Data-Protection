package com.protection.data.DAO;


import com.protection.data.models.SubjectrfEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("SubjectDAO")
public class SubjectDAOImpl extends AbstractDAO<Integer,SubjectrfEntity> implements SubjectDAO{
    @Override
    public SubjectrfEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(SubjectrfEntity.class);
        criteria.add(Restrictions.eq("idSubject", id));
        return (SubjectrfEntity) criteria.uniqueResult();
    }

    @Override
    public SubjectrfEntity FindByLTitle(String title) {
        Criteria criteria = getSession().createCriteria(SubjectrfEntity.class);
        criteria.add(Restrictions.eq("title", title));
        return (SubjectrfEntity) criteria.uniqueResult();
    }

    @Override
    public List<SubjectrfEntity> findAllSubjects() {
        Criteria criteria = getSession().createCriteria(SubjectrfEntity.class);
        return (List<SubjectrfEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public void saveSubject(SubjectrfEntity subject) {
        getSession().save(subject);
    }
}
