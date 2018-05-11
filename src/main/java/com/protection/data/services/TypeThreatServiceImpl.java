package com.protection.data.services;

import com.protection.data.DAO.TypeThreatDAO;
import com.protection.data.models.TypethreatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("TypeThreatService")
@Transactional
public class TypeThreatServiceImpl implements TypeThreatService {

    @Autowired
    private TypeThreatDAO typeThreatDAO;

    @Override
    public List<TypethreatEntity> findAll() {
        return typeThreatDAO.findAll();
    }
}
