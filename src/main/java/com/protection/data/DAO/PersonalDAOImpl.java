package com.protection.data.DAO;

import com.protection.data.models.PersonalinformationsystemEntity;
import com.protection.data.models.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PersonalInformationDAO")
public class PersonalDAOImpl extends AbstractDAO<Integer, PersonalinformationsystemEntity> implements PersonalInformationDAO{
    @Override
    public  void updatePersonal(PersonalinformationsystemEntity stateinformation) {
        getSession().saveOrUpdate(stateinformation);
    }

    @Override
    public void deletePersonal(int id) {
        Query query = getSession().createSQLQuery("DELETE from stateinformationsystem where idStateInformationSystem=:id");
        query.setInteger("id", id);
        query.executeUpdate();

    }

    @Override
    public int findMaxPersonal() {
        Query query = getSession().createSQLQuery("select idStateInformationSystem from stateinformationsystem where idStateInformationSystem>=all(select idStateInformationSystem from stateinformationsystem)");
        List<Integer> max = query.list();
        int result = max.get(0);
        return result;

    }

    @Override
    public PersonalinformationsystemEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(PersonalinformationsystemEntity.class);
        criteria.add(Restrictions.eq("idPersonalInformationSystem", id));
        return (PersonalinformationsystemEntity) criteria.uniqueResult();
    }

    @Override
    public PersonalinformationsystemEntity FindByTitle(String title) {
        Criteria criteria = getSession().createCriteria(PersonalinformationsystemEntity.class);
        criteria.add(Restrictions.eq("title", title));
        return (PersonalinformationsystemEntity) criteria.uniqueResult();
    }

    @Override
    public List<PersonalinformationsystemEntity> findAllPersonal() {
                Criteria criteria = getSession().createCriteria(PersonalinformationsystemEntity.class);
        return (List<PersonalinformationsystemEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

    }


    @Override
    public void savePersonal(PersonalinformationsystemEntity stateinformationsystem) {
        getSession().saveOrUpdate(stateinformationsystem);
    }

    @Override
    public List<PersonalinformationsystemEntity> findPersonal(UsersEntity user) {
        Criteria criteria = getSession().createCriteria(PersonalinformationsystemEntity.class);
        criteria.add(Restrictions.eq("user", user));
        return (List<PersonalinformationsystemEntity>)criteria.list();
    }


}
