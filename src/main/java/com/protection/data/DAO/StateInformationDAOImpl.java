package com.protection.data.DAO;

import com.protection.data.models.StateinformationsystemEntity;
import com.protection.data.models.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("StateInformationDAO")
public class StateInformationDAOImpl extends AbstractDAO<Integer, StateinformationsystemEntity> implements StateInformationDAO{
    @Override
    public  void updateOfficial(StateinformationsystemEntity stateinformation) {
        getSession().saveOrUpdate(stateinformation);
    }

    @Override
    public void deleteUser(int id) {
        Query query = getSession().createSQLQuery("DELETE from stateinformationsystem where idStateInformationSystem=:id");
        query.setInteger("id", id);
        query.executeUpdate();

    }

    @Override
    public int findMaxOfficial() {
        Query query = getSession().createSQLQuery("select idStateInformationSystem from stateinformationsystem where idStateInformationSystem>=all(select idStateInformationSystem from stateinformationsystem)");
        List<Integer> max = query.list();
        int result = max.get(0);
        return result;

    }

    @Override
    public StateinformationsystemEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(StateinformationsystemEntity.class);
        criteria.add(Restrictions.eq("idStateInformationSystem", id));
        return (StateinformationsystemEntity) criteria.uniqueResult();
    }

    @Override
    public StateinformationsystemEntity FindByTitle(String title) {
        Criteria criteria = getSession().createCriteria(StateinformationsystemEntity.class);
        criteria.add(Restrictions.eq("title", title));
        return (StateinformationsystemEntity) criteria.uniqueResult();
    }

    @Override
    public List<StateinformationsystemEntity> findAllStateInformation() {
                Criteria criteria = getSession().createCriteria(StateinformationsystemEntity.class);
        return (List<StateinformationsystemEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

    }


    @Override
    public void saveStateInformation(StateinformationsystemEntity stateinformationsystem) {

        getSession().saveOrUpdate(stateinformationsystem);
    }

    @Override
    public List<StateinformationsystemEntity> findStateInformation(UsersEntity user) {
        Criteria criteria = getSession().createCriteria(StateinformationsystemEntity.class);
        criteria.add(Restrictions.eq("user", user));
        return (List<StateinformationsystemEntity>)criteria.list();
    }


}
