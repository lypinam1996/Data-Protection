package com.protection.data.DAO;

import com.protection.data.models.QuantityEntity;
import com.protection.data.models.SpecialistsEntity;
import com.protection.data.models.SpecialistshistoryEntity;
import com.protection.data.models.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Repository("SpecialistHistoryDAO")
public class SpecialistHistoyDAOImpl extends AbstractDAO<Integer,SpecialistshistoryEntity> implements SpecialistHistoryDAO{

    @Override
    public SpecialistshistoryEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(SpecialistshistoryEntity.class);
        criteria.add(Restrictions.eq("idSpecialist", id));
        return (SpecialistshistoryEntity) criteria.uniqueResult();
    }

    @Override
    public SpecialistshistoryEntity FindByTitle(String title) {
        Criteria criteria = getSession().createCriteria(SpecialistshistoryEntity.class);
        criteria.add(Restrictions.eq("title", title));
        return (SpecialistshistoryEntity) criteria.uniqueResult();
    }

    @Override
    public List<SpecialistshistoryEntity> findAllSpecialist() {
        Criteria criteria = getSession().createCriteria(SpecialistshistoryEntity.class);
        return (List<SpecialistshistoryEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
    @Override
    public List<SpecialistshistoryEntity> findSpecialist2(UsersEntity user, SpecialistsEntity id){
        Criteria criteria = getSession().createCriteria(SpecialistshistoryEntity.class);
        criteria.add(Restrictions.eq("user", user));
        criteria.add(Restrictions.eq("specialist", id));
        return (List<SpecialistshistoryEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
    @Override
    public List<SpecialistshistoryEntity> findSpecialist2( SpecialistsEntity id){
        Criteria criteria = getSession().createCriteria(SpecialistshistoryEntity.class);
        criteria.add(Restrictions.eq("specialist", id));
        return (List<SpecialistshistoryEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public List<SpecialistshistoryEntity> findSpecialist(UsersEntity user, QuantityEntity id){
        Criteria criteria = getSession().createCriteria(SpecialistshistoryEntity.class);
        criteria.add(Restrictions.eq("user", user));
        criteria.add(Restrictions.eq("quantity", id));
        return (List<SpecialistshistoryEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
    @Override
    public void saveSpecialist(SpecialistsEntity official,SpecialistshistoryEntity officialhistory) {
        Date sqldate2 = new Date(official.getBirth().getTime());
        officialhistory.setBirth(sqldate2);

        officialhistory.setEmail(official.getEmail());
        officialhistory.setInstitution(official.getInstitution());
        officialhistory.setName(official.getName());
        officialhistory.setSpecialist(official);
        officialhistory.setPatronymic(official.getPatronymic());
        officialhistory.setPhone(official.getPhone());
        officialhistory.setSpecialty(official.getSpecialty());
        officialhistory.setSurname(official.getSurname());
        officialhistory.setYear(official.getYear());
        officialhistory.setTitle(official.getTitle());
        Calendar currenttime = Calendar.getInstance();
        Date sqldate = new Date((currenttime.getTime()).getTime());
        officialhistory.setDateUpdate(sqldate);
        Date sqldate3 = new Date(official.getDateOfAppointment().getTime());
        officialhistory.setDateOfAppointment(sqldate3);

        officialhistory.setReconciliation(official.getReconciliation());
        officialhistory.setWorkExperience(official.getWorkExperience());
        officialhistory.setInstitution2(official.getInstitution2());
        officialhistory.setSpecialty2(official.getSpecialty2());
        officialhistory.setPeriodStudy3(official.getPeriodStudy());
        officialhistory.setHours3(official.getHours());
        officialhistory.setInstitution3(official.getInstitution3());
        officialhistory.setSpecialty3(official.getSpecialty3());
        officialhistory.setPeriodStudy(official.getPeriodStudy3());
        officialhistory.setHours(official.getHours3());
        officialhistory.setReconciliationDate(official.getReconciliationDate());
        officialhistory.setReconciliationNumber(official.getReconciliationNumber());

        getSession().save(officialhistory);
    }


    @Override
    public void deleteSpecialist(int id) {
        Query query = getSession().createSQLQuery("DELETE from specialists where idSpecialist=:id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
}
