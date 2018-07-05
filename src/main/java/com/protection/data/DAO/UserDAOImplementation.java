package com.protection.data.DAO;

import com.protection.data.models.AuthoritiesEntity;
import com.protection.data.models.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserDAO")
public class UserDAOImplementation extends AbstractDAO<Integer,UsersEntity> implements UserDAO{
    @Override
    public UsersEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(UsersEntity.class);
        criteria.add(Restrictions.eq("idUser", id));
        return (UsersEntity) criteria.uniqueResult();
    }

    @Override
    public UsersEntity FindByLogin(String title) {
        Criteria criteria = getSession().createCriteria(UsersEntity.class);
        criteria.add(Restrictions.eq("login", title));
        return (UsersEntity) criteria.uniqueResult();
    }

    @Override
    public List<UsersEntity> findByAuth(AuthoritiesEntity authorities) {
        Criteria criteria = getSession().createCriteria(UsersEntity.class);
        criteria.add(Restrictions.eq("authority", authorities));
        return (List<UsersEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public List<UsersEntity> findAllUsers() {
        Criteria criteria = getSession().createCriteria(UsersEntity.class);
        return (List<UsersEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public void saveUser(UsersEntity user) {
        getSession().saveOrUpdate(user);

    }

    @Override
    public List<UsersEntity> findAllUsersWhereControlEquals1(){
        Criteria criteria = getSession().createCriteria(UsersEntity.class);
        criteria.add(Restrictions.eq("control", 1));
        return (List<UsersEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public List<UsersEntity> findAllUsersWhereControlEquals2(){
        Criteria criteria = getSession().createCriteria(UsersEntity.class);
        criteria.add(Restrictions.eq("control", 2));
        return (List<UsersEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }


    @Override
    public void confirmRegistration(UsersEntity user){
        Criteria criteria = getSession().createCriteria(UsersEntity.class);
        criteria.add(Restrictions.eq("idUser", user.getIdUser()));
        UsersEntity user1 = (UsersEntity) criteria.uniqueResult();
        user1.setControl(2);
        user1.setAuthority(user.getAuthority());
        user1.setEmail(user.getEmail());
        user1.setLogin(user.getLogin());
        user1.setMailingAddress(user.getMailingAddress());
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        user1.setPatronimic(user.getPatronimic());
        user1.setPhone(user.getPhone());
        user1.setPost(user.getPost());
        user1.setStatus(user.getStatus());
        user1.setSubject(user.getSubject());
        user1.setSurname(user.getSurname());
        getSession().save(user1);
    }

    @Override
    public void deleteUser(int id_lock) {
        Query query = getSession().createSQLQuery("DELETE from users where idUser=:id_lock");
        query.setInteger("id_lock", id_lock);
        query.executeUpdate();
    }
}
