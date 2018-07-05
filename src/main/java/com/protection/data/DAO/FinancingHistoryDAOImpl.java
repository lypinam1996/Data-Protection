package com.protection.data.DAO;

import com.protection.data.models.FinancingEntity;
import com.protection.data.models.FinancinghistoryEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Repository("FinancingHistoryDAO")
public class FinancingHistoryDAOImpl extends AbstractDAO<Integer,FinancinghistoryEntity> implements FinancingHistoryDAO{

    @Override
    public FinancinghistoryEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(FinancinghistoryEntity.class);
        criteria.add(Restrictions.eq("idFinancing", id));
        return (FinancinghistoryEntity) criteria.uniqueResult();
    }

    @Override
    public FinancinghistoryEntity FindByTitle(String title) {
        Criteria criteria = getSession().createCriteria(FinancinghistoryEntity.class);
        criteria.add(Restrictions.eq("title", title));
        return (FinancinghistoryEntity) criteria.uniqueResult();
    }

    @Override
    public List<FinancinghistoryEntity> findAllFinancing() {
        Criteria criteria = getSession().createCriteria(FinancinghistoryEntity.class);
        return (List<FinancinghistoryEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public List<FinancinghistoryEntity> findFinancing(FinancingEntity quantityEntity){
        Criteria criteria = getSession().createCriteria(FinancinghistoryEntity.class);
        criteria.add(Restrictions.eq("financingByIdFinancing",quantityEntity));
        return (List<FinancinghistoryEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public void deleteFinancing(int id) {
        Query query = getSession().createSQLQuery("DELETE from financing where idFinancing=:id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public void saveFinancing(FinancingEntity quantity,FinancinghistoryEntity quantityhistoryEntity) {
        quantityhistoryEntity.setAllNextYear(quantity.getAllNextYear());
        quantityhistoryEntity.setAllThisYear(quantity.getAllThisYear());
        quantityhistoryEntity.setNosSNextYear(quantity.getNosSNextYear());
        quantityhistoryEntity.setNosSThisYear(quantity.getNosSThisYear());
        quantityhistoryEntity.setFinancingByIdFinancing(quantity);
        quantityhistoryEntity.setPersonalInformationNextYear(quantity.getPersonalInformationNextYear());
        quantityhistoryEntity.setPersonalInformationThisYear(quantity.getPersonalInformationThisYear());
        quantityhistoryEntity.setsSNextYear(quantity.getsSNextYear());
        quantityhistoryEntity.setsSThisYear(quantity.getsSThisYear());
        Calendar currenttime = Calendar.getInstance();
        Date sqldate = new Date((currenttime.getTime()).getTime());
        quantityhistoryEntity.setUpdateDate(sqldate);
        getSession().save(quantityhistoryEntity);
    }
}
