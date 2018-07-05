package com.protection.data.DAO;

import com.protection.data.models.OfficialEntity;
import com.protection.data.models.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("OfficialDAO")
public class OfficailDAOImpl extends AbstractDAO<Integer,OfficialEntity> implements OfficialDAO {

    @Override
    public OfficialEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(OfficialEntity.class);
        criteria.add(Restrictions.eq("id", id));
        return (OfficialEntity) criteria.uniqueResult();
    }

    @Override
    public List<OfficialEntity> findByBirth(Date birth) {
        Criteria criteria = getSession().createCriteria(OfficialEntity.class);
        criteria.add(Restrictions.eq("birth", birth));
        return (List<OfficialEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public List<OfficialEntity> FindByTitle(String title) {
        Criteria criteria = getSession().createCriteria(OfficialEntity.class);
        criteria.add(Restrictions.eq("title", title));
        return (List<OfficialEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }


    @Override
    public List<OfficialEntity> findAllOfficials() {
        Criteria criteria = getSession().createCriteria(OfficialEntity.class);
        return (List<OfficialEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public List<OfficialEntity> findOfficials(UsersEntity user) {
        Criteria criteria = getSession().createCriteria(OfficialEntity.class);
        criteria.add(Restrictions.eq("user", user));
        return (List<OfficialEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public void saveOfficial(OfficialEntity official) {
        getSession().saveOrUpdate(official);
    }

    @Override
    public void updateOfficial(OfficialEntity official) {
        Criteria criteria = getSession().createCriteria(OfficialEntity.class);
        criteria.add(Restrictions.eq("idOfficial", official.getIdOfficial()));
        OfficialEntity official1 = (OfficialEntity) criteria.uniqueResult();
        official1.setBirth(official.getBirth());
        official1.setUser(official.getUser());
        official1.setTitle(official.getTitle());
        official1.setRemark(official.getRemark());
        official1.setYear(official.getYear());
        official1.setSpecialty(official.getSpecialty());
        official1.setInstitution(official.getInstitution());
        official1.setEmail(official.getEmail());
        official1.setPhone(official.getPhone());
        official1.setPatronymic(official.getPatronymic());
        official1.setName(official.getName());
        official1.setSurname(official.getSurname());
        official1.setIdOfficial(official.getIdOfficial());
        getSession().save(official1);
    }

    @Override
    public void deleteUser(int id) {
        Query query = getSession().createSQLQuery("DELETE from official where idOfficial=:id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public int findMaxOfficial() {
        Query query = getSession().createSQLQuery("select idOfficial from official where idOfficial>=all(select idOfficial from official)");
        List<Integer> officialEntity = query.list();
        int reslt = officialEntity.get(0);
        return reslt;
    }
}
