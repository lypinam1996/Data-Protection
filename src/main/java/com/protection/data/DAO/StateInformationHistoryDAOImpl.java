package com.protection.data.DAO;

import com.protection.data.models.StateinformationsystehistoryEntity;
import com.protection.data.models.StateinformationsystemEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository("StateInformationSystemHistoryDAO")
public class StateInformationHistoryDAOImpl extends AbstractDAO<Integer, StateinformationsystehistoryEntity> implements StateInformationHistoryDAO{
    @Override
    public StateinformationsystehistoryEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(StateinformationsystehistoryEntity.class);
        criteria.add(Restrictions.eq("idStateInformationSystemHistory", id));
        return (StateinformationsystehistoryEntity) criteria.uniqueResult();
    }

    @Override
    public StateinformationsystehistoryEntity FindByTitle(String title) {
        Criteria criteria = getSession().createCriteria(StateinformationsystehistoryEntity.class);
        criteria.add(Restrictions.eq("title", title));
        return (StateinformationsystehistoryEntity) criteria.uniqueResult();
    }

    @Override
    public List<StateinformationsystehistoryEntity> findAllStateInformationHistories() {
        Criteria criteria = getSession().createCriteria(StateinformationsystehistoryEntity.class);
        return (List<StateinformationsystehistoryEntity>)criteria.list();
    }

    @Override
    public List<StateinformationsystehistoryEntity> findStateInformationHistories(StateinformationsystemEntity stateinformationsystem) {
        Criteria criteria = getSession().createCriteria(StateinformationsystehistoryEntity.class);
        criteria.add(Restrictions.eq("stateinformationsystemByIdStateInformationSystem", stateinformationsystem));
        return (List<StateinformationsystehistoryEntity>)criteria.list();
    }

    @Override
    public void saveStateInformationHistory(StateinformationsystemEntity stateinformationsystem, StateinformationsystehistoryEntity stateinformationsystehistory) {
        stateinformationsystehistory.setActAttestation(stateinformationsystem.getActAttestation());
        stateinformationsystehistory.setActDateAttestation(stateinformationsystem.getActDateAttestation());
        stateinformationsystehistory.setActNumberAttestation(stateinformationsystem.getActNumberAttestation());
        stateinformationsystehistory.setAttestation(stateinformationsystem.getAttestation());
        stateinformationsystehistory.setAttestationName(stateinformationsystem.getAttestationName());
        stateinformationsystehistory.setAttestationDate(stateinformationsystem.getAttestationDate());
        stateinformationsystehistory.setAttestationNumberLisence(stateinformationsystem.getAttestationNumberLisence());
        stateinformationsystehistory.setCommissioning(stateinformationsystem.getCommissioning());
        stateinformationsystehistory.setCryptoProtection(stateinformationsystem.getCryptoProtection());
        stateinformationsystehistory.setDateAboutCreating(stateinformationsystem.getDateAboutCreating());
        stateinformationsystehistory.setDateAboutExploitation(stateinformationsystem.getDateAboutExploitation());
        stateinformationsystehistory.setDateAct(stateinformationsystem.getDateAct());
        stateinformationsystehistory.setDateClassification(stateinformationsystem.getDateClassification());
        stateinformationsystehistory.setDateOfAttestation(stateinformationsystem.getDateOfAttestation());
        stateinformationsystehistory.setDateRegister(stateinformationsystem.getDateRegister());
        stateinformationsystehistory.setDateUpdate(new Date(new java.util.Date().getTime()));
        stateinformationsystehistory.setEmail(stateinformationsystem.getEmail());
        stateinformationsystehistory.setLegalAct(stateinformationsystem.getLegalAct());
        stateinformationsystehistory.setLegalActAboutCreating(stateinformationsystem.getLegalActAboutCreating());
        stateinformationsystehistory.setLegalActAboutExploitation(stateinformationsystem.getLegalActAboutExploitation());
        stateinformationsystehistory.setLegalActRegister(stateinformationsystem.getLegalActRegister());
        stateinformationsystehistory.setName(stateinformationsystem.getName());
        stateinformationsystehistory.setNumber(stateinformationsystem.getNumber());
        stateinformationsystehistory.setNumberAboutCreating(stateinformationsystem.getNumberAboutCreating());
        stateinformationsystehistory.setNumberAboutExploitation(stateinformationsystem.getNumberAboutExploitation());
        stateinformationsystehistory.setNumberClassification(stateinformationsystem.getNumberClassification());
        stateinformationsystehistory.setNumberRegister(stateinformationsystem.getNumberRegister());
        stateinformationsystehistory.setOperator(stateinformationsystem.getOperator());
        stateinformationsystehistory.setPatronimyc(stateinformationsystem.getPatronimyc());
        stateinformationsystehistory.setPhone(stateinformationsystem.getPhone());
        stateinformationsystehistory.setPost(stateinformationsystem.getPost());
        stateinformationsystehistory.setPurpose(stateinformationsystem.getPurpose());
        stateinformationsystehistory.setRestrictedAccessInformation(stateinformationsystem.getRestrictedAccessInformation());
        stateinformationsystehistory.setSeparateParts(stateinformationsystem.getSeparateParts());
        stateinformationsystehistory.setStateinformationsystemByIdStateInformationSystem(stateinformationsystem);
        stateinformationsystehistory.setSubdivision(stateinformationsystem.getSubdivision());
        stateinformationsystehistory.setSurname(stateinformationsystem.getSurname());
        stateinformationsystehistory.setThreatsResults(stateinformationsystem.getThreatsResults());
        stateinformationsystehistory.setThreatsResultsDate(stateinformationsystem.getThreatsResultsDate());
        stateinformationsystehistory.setThreatsResultsNumber(stateinformationsystem.getThreatsResultsNumber());
        stateinformationsystehistory.setTitle(stateinformationsystem.getTitle());
        stateinformationsystehistory.setTypeofcryptoprotectionByTypeofcryptoprotection(stateinformationsystem.getTypeofcryptoprotectionByTypeofcryptoprotection());
        getSession().save(stateinformationsystehistory);
    }
}
