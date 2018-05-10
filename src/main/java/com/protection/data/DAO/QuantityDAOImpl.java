package com.protection.data.DAO;

import com.protection.data.models.QuantityEntity;
import com.protection.data.models.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("QuantityDAO")
public class QuantityDAOImpl extends AbstractDAO<Integer,QuantityEntity> implements QuantityDAO{

    @Override
    public QuantityEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(QuantityEntity.class);
        criteria.add(Restrictions.eq("idQuantity", id));
        return (QuantityEntity) criteria.uniqueResult();
    }

    @Override
    public QuantityEntity FindByTitle(String title) {
        Criteria criteria = getSession().createCriteria(QuantityEntity.class);
        criteria.add(Restrictions.eq("title", title));
        return (QuantityEntity) criteria.uniqueResult();
    }

    @Override
    public List<QuantityEntity> findAllQuantities() {
        Criteria criteria = getSession().createCriteria(QuantityEntity.class);
        return (List<QuantityEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public List<QuantityEntity> findQuantities(UsersEntity user){
        Criteria criteria = getSession().createCriteria(QuantityEntity.class);
        criteria.add(Restrictions.eq("user", user));
        return (List<QuantityEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
    @Override
    public void saveQuantity(QuantityEntity quantity) {
        getSession().saveOrUpdate(quantity);
    }


    @Override
    public void deleteQuantity(int id) {
        Query query = getSession().createSQLQuery("DELETE from quantity where idQuantity=:id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
}
