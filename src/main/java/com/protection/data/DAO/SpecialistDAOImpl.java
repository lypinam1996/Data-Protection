package com.protection.data.DAO;

import com.protection.data.models.QuantityEntity;
import com.protection.data.models.SpecialistsEntity;
import com.protection.data.models.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("SpecialistDAO")
public class SpecialistDAOImpl extends AbstractDAO<Integer,SpecialistsEntity> implements SpecialistDAO{

    @Override
    public SpecialistsEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(SpecialistsEntity.class);
        criteria.add(Restrictions.eq("idSpecialist", id));
        return (SpecialistsEntity) criteria.uniqueResult();
    }

    @Override
    public SpecialistsEntity FindByTitle(String title) {
        Criteria criteria = getSession().createCriteria(SpecialistsEntity.class);
        criteria.add(Restrictions.eq("title", title));
        return (SpecialistsEntity) criteria.uniqueResult();
    }

    @Override
    public List<SpecialistsEntity> findAllSpecialist() {
        Criteria criteria = getSession().createCriteria(SpecialistsEntity.class);
        return (List<SpecialistsEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public List<SpecialistsEntity> findSpecialist(UsersEntity user, QuantityEntity id){
        Criteria criteria = getSession().createCriteria(SpecialistsEntity.class);
        criteria.add(Restrictions.eq("user", user));
        criteria.add(Restrictions.eq("quantity", id));
        return (List<SpecialistsEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public List<SpecialistsEntity> findSpecialist( QuantityEntity id){
        Criteria criteria = getSession().createCriteria(SpecialistsEntity.class);
        criteria.add(Restrictions.eq("quantity", id));
        return (List<SpecialistsEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
    @Override
    public void saveSpecialist(SpecialistsEntity quantity) {
        getSession().saveOrUpdate(quantity);
    }


    @Override
    public void deleteSpecialist(int id) {
        Query query = getSession().createSQLQuery("DELETE from specialists where idSpecialist=:id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public int findMaxSpecials() {
        Query query = getSession().createSQLQuery("select idSpecialist from specialists where idSpecialist>=all(select idSpecialist from specialists)");
        List<Integer> max = query.list();
        int reslt = max.get(0);
        return reslt;
    }
}
