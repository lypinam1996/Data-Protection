package com.protection.data.DAO;

import com.protection.data.models.QuantityEntity;
import com.protection.data.models.QuantityhistoryEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Repository("QuantityHistoryDAO")
public class QuantityHistoryDAOImpl extends AbstractDAO<Integer,QuantityhistoryEntity> implements QuantityHistoryDAO{

    @Override
    public QuantityhistoryEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(QuantityhistoryEntity.class);
        criteria.add(Restrictions.eq("idQuantity", id));
        return (QuantityhistoryEntity) criteria.uniqueResult();
    }

    @Override
    public QuantityhistoryEntity FindByTitle(String title) {
        Criteria criteria = getSession().createCriteria(QuantityhistoryEntity.class);
        criteria.add(Restrictions.eq("title", title));
        return (QuantityhistoryEntity) criteria.uniqueResult();
    }

    @Override
    public List<QuantityhistoryEntity> findAllQuantities() {
        Criteria criteria = getSession().createCriteria(QuantityhistoryEntity.class);
        return (List<QuantityhistoryEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public List<QuantityhistoryEntity> findQuantities( QuantityEntity quantityEntity){
        Criteria criteria = getSession().createCriteria(QuantityhistoryEntity.class);
        criteria.add(Restrictions.eq("quantitise",quantityEntity));
        return (List<QuantityhistoryEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public void deleteQuantity(int id) {
        Query query = getSession().createSQLQuery("DELETE from quantity where idQuantity=:id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public void saveQuantity(QuantityEntity quantity,QuantityhistoryEntity quantityhistoryEntity) {
        quantityhistoryEntity.setQuantitise(quantity);
        quantityhistoryEntity.setEstablished(quantity.getEstablished());
        quantityhistoryEntity.setNonStandard(quantity.getNonStandard());
        quantityhistoryEntity.setStaff(quantity.getStaff());
        quantityhistoryEntity.setSubdivision(quantity.getSubdivision());
        Calendar currenttime = Calendar.getInstance();
        Date sqldate = new Date((currenttime.getTime()).getTime());
        quantityhistoryEntity.setDateUpdate(sqldate);
        getSession().save(quantityhistoryEntity);
    }
}
