package com.protection.data.DAO;

import com.protection.data.models.OfficialEntity;
import com.protection.data.models.OfficialhistoryEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Repository("OfficialHistoryDAO")
public class OfficailHistoryDAOImpl extends AbstractDAO<Integer,OfficialhistoryEntity> implements OfficialHistoryDAO{

    @Override
    public OfficialhistoryEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(OfficialhistoryEntity.class);
        criteria.add(Restrictions.eq("idOfficial", id));
        return (OfficialhistoryEntity) criteria.uniqueResult();
    }

    @Override
    public OfficialhistoryEntity FindByTitle(String title) {
        Criteria criteria = getSession().createCriteria(OfficialhistoryEntity.class);
        criteria.add(Restrictions.eq("title", title));
        return (OfficialhistoryEntity) criteria.uniqueResult();
    }

    @Override
    public List<OfficialhistoryEntity> findAllOfficials() {
        Criteria criteria = getSession().createCriteria(OfficialhistoryEntity.class);
        return (List<OfficialhistoryEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public List<OfficialhistoryEntity> findOfficials(OfficialEntity officialEntity){
        Criteria criteria = getSession().createCriteria(OfficialhistoryEntity.class);
        criteria.add(Restrictions.eq("officials",officialEntity));
        return (List<OfficialhistoryEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
    @Override
    public void saveOfficial(OfficialEntity official,OfficialhistoryEntity officialhistory) {
        Timestamp sqldate2 = new Timestamp(official.getBirth().getTime());
        officialhistory.setBirth(sqldate2);
        officialhistory.setEmail(official.getEmail());
        officialhistory.setInstitution(official.getInstitution());
        officialhistory.setName(official.getName());
        officialhistory.setOfficials(official);
        officialhistory.setPatronymic(official.getPatronymic());
        officialhistory.setPhone(official.getPhone());
        officialhistory.setRemark(official.getRemark());
        officialhistory.setSpecialty(official.getSpecialty());
        officialhistory.setSurname(official.getSurname());
        officialhistory.setYear(official.getYear());
        officialhistory.setTitle(official.getTitle());
        Calendar currenttime = Calendar.getInstance();
        Date sqldate = new Date((currenttime.getTime()).getTime());
        officialhistory.setUpdateDate(sqldate);
        getSession().save(officialhistory);
    }


}
