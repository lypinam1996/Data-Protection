package com.protection.data.DAO;
import com.protection.data.models.TypeofcryptoprotectionEntity;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CryptoProtectionDAO")
public class CryptoProtectionDAOImplemention extends AbstractDAO<Integer,TypeofcryptoprotectionEntity> implements CryptoProtectionDAO{

    @Override
    public List<TypeofcryptoprotectionEntity> findAllStatuses() {
        Criteria criteria = getSession().createCriteria(TypeofcryptoprotectionEntity.class);
        return (List<TypeofcryptoprotectionEntity>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
}
