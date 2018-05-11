package com.protection.data.DAO;

import com.protection.data.models.PersonaldataEntity;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PersonalDataDAO")
public class PersonalDataDAOImpl extends AbstractDAO<Integer, PersonaldataEntity> implements PersonalDataDAO{
    @Override
    public List<PersonaldataEntity> findAll() {
        Criteria criteria = getSession().createCriteria(PersonaldataEntity.class);
        return (List<PersonaldataEntity>)criteria.list();
    }
}
