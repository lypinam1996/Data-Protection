package com.protection.data.DAO;

import com.protection.data.models.FinancingEntity;
import com.protection.data.models.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("FinancingDAO")
public class FinancingDAOImpl extends AbstractDAO<Integer,FinancingEntity> implements FinancingDAO{

    @Override
    public FinancingEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(FinancingEntity.class);
        criteria.add(Restrictions.eq("idFinancing", id));
        return (FinancingEntity) criteria.uniqueResult();
    }

    @Override
    public FinancingEntity FindByTitle(String title) {
        Criteria criteria = getSession().createCriteria(FinancingEntity.class);
        criteria.add(Restrictions.eq("title", title));
        return (FinancingEntity) criteria.uniqueResult();
    }

    @Override
    public List<FinancingEntity> findAllFinancing() {
        Criteria criteria = getSession().createCriteria(FinancingEntity.class);
        return (List<FinancingEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public List<FinancingEntity> findFinancing(UsersEntity user){
        Criteria criteria = getSession().createCriteria(FinancingEntity.class);
        criteria.add(Restrictions.eq("user", user));
        return (List<FinancingEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
    @Override
    public void saveFinancing(FinancingEntity quantity) {
        int thisYear = Integer.parseInt(quantity.getNosSThisYear())+Integer.parseInt(quantity.getsSThisYear())+Integer.parseInt(quantity.getPersonalInformationThisYear());
        int nextYear = Integer.parseInt(quantity.getNosSNextYear())+Integer.parseInt(quantity.getsSNextYear())+Integer.parseInt(quantity.getPersonalInformationNextYear());
        String thisYearStr = String.valueOf(thisYear);
        String nextYearStr = String.valueOf(nextYear);
        quantity.setAllNextYear(nextYearStr);
        quantity.setAllThisYear(thisYearStr);
        getSession().saveOrUpdate(quantity);
    }


    @Override
    public void deleteFinancing(int id) {
        Query query = getSession().createSQLQuery("DELETE from financing where idFinancing=:id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public int findMaxFinancing() {
        Query query = getSession().createSQLQuery("select idFinancing from financing where idFinancing>=all(select idFinancing from financing)");
        List<Integer> max = query.list();
        int reslt = max.get(0);
        return reslt;
    }

}
