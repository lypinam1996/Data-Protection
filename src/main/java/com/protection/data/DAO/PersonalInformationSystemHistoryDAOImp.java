package com.protection.data.DAO;

import com.protection.data.models.PersonalinformationsystemEntity;
import com.protection.data.models.PersonalinformationsystemhistoryEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Repository("PersonalInformationalSystemHistoryDAO")
public class PersonalInformationSystemHistoryDAOImp extends AbstractDAO<Integer, PersonalinformationsystemhistoryEntity> implements PersonalInformationSystemHistoryDAO{
    @Override
    public PersonalinformationsystemhistoryEntity findById(int id) {
        Criteria criteria = getSession().createCriteria(PersonalinformationsystemhistoryEntity.class);
        criteria.add(Restrictions.eq("idPersonalInformationSystemHistory", id));
        return (PersonalinformationsystemhistoryEntity) criteria.uniqueResult();
    }

    @Override
    public PersonalinformationsystemhistoryEntity FindByTitle(String title) {
        Criteria criteria = getSession().createCriteria(PersonalinformationsystemhistoryEntity.class);
        criteria.add(Restrictions.eq("title", title));
        return (PersonalinformationsystemhistoryEntity) criteria.uniqueResult();
    }

    @Override
    public List<PersonalinformationsystemhistoryEntity> findAllPersonalInformationSystemHistories() {
        Criteria criteria = getSession().createCriteria(PersonalinformationsystemhistoryEntity.class);
        return (List<PersonalinformationsystemhistoryEntity>)criteria.list();
    }

    @Override
    public List<PersonalinformationsystemhistoryEntity> findPersonalInformationSystemHistories(PersonalinformationsystemEntity personalinformationsystem) {
        Criteria criteria = getSession().createCriteria(PersonalinformationsystemhistoryEntity.class);
        criteria.add(Restrictions.eq("personalinformationsystemByIdPersonalInformationSystem", personalinformationsystem));
        return (List<PersonalinformationsystemhistoryEntity>)criteria.list();
    }

    @Override
    public void saveHistory(PersonalinformationsystemEntity personalinformationsystem, PersonalinformationsystemhistoryEntity personalinformationsystemhistory) {
        personalinformationsystemhistory.setActAttestation(personalinformationsystem.getActAttestation());
        personalinformationsystemhistory.setActDateAttestation(personalinformationsystem.getActDateAttestation());
        personalinformationsystemhistory.setActNumberAttestation(personalinformationsystem.getActNumberAttestation());
        personalinformationsystemhistory.setAttestation(personalinformationsystem.getAttestation());
        personalinformationsystemhistory.setAttestationDate(personalinformationsystem.getAttestationDate());
        personalinformationsystemhistory.setAttestationName(personalinformationsystem.getAttestationName());
        personalinformationsystemhistory.setAttestationNumberLisence(personalinformationsystem.getAttestationNumberLisence());
        personalinformationsystemhistory.setCategoryofsubjectByIdCategoryOfSubject(personalinformationsystem.getCategoryofsubjectByIdCategoryOfSubject());
        personalinformationsystemhistory.setCommissioning(personalinformationsystem.getCommissioning());
        personalinformationsystemhistory.setCountsubjectsByIdCountSubjects(personalinformationsystem.getCountsubjectsByIdCountSubjects());
        personalinformationsystemhistory.setCryptoProtection(personalinformationsystem.getCryptoProtection());
        personalinformationsystemhistory.setDateAboutCreating(personalinformationsystem.getDateAboutCreating());
        personalinformationsystemhistory.setDateAboutExploitation(personalinformationsystem.getDateAboutExploitation());
        personalinformationsystemhistory.setDateAct(personalinformationsystem.getDateAct());
        personalinformationsystemhistory.setDateOfAttestation(personalinformationsystem.getDateOfAttestation());
        personalinformationsystemhistory.setDateRegister(personalinformationsystem.getDateRegister());
        personalinformationsystemhistory.setDateSecuritylevel(personalinformationsystem.getDateSecuritylevel());
        personalinformationsystemhistory.setEmail(personalinformationsystem.getEmail());
        personalinformationsystemhistory.setLegalAct(personalinformationsystem.getLegalAct());
        personalinformationsystemhistory.setLegalActAboutCreating(personalinformationsystem.getLegalActAboutCreating());
        personalinformationsystemhistory.setLegalActAboutExploitation(personalinformationsystem.getLegalActAboutExploitation());
        personalinformationsystemhistory.setLegalActRegister(personalinformationsystem.getLegalActRegister());
        personalinformationsystemhistory.setName(personalinformationsystem.getName());
        personalinformationsystemhistory.setNumber(personalinformationsystem.getNumber());
        personalinformationsystemhistory.setNumberAboutCreating(personalinformationsystem.getNumberAboutCreating());
        personalinformationsystemhistory.setNumberAboutExploitation(personalinformationsystem.getNumberAboutExploitation());
        personalinformationsystemhistory.setNumberRegister(personalinformationsystem.getNumberRegister());
        personalinformationsystemhistory.setOperator(personalinformationsystem.getOperator());
        personalinformationsystemhistory.setPatronimyc(personalinformationsystem.getPatronimyc());
        personalinformationsystemhistory.setPersonaldataByIdPersonalData(personalinformationsystem.getPersonaldataByIdPersonalData());
        personalinformationsystemhistory.setPersonalinformationsystemByIdPersonalInformationSystem(personalinformationsystem);
        personalinformationsystemhistory.setPersonSecuritylevel(personalinformationsystem.getPersonSecuritylevel());
        personalinformationsystemhistory.setPhone(personalinformationsystem.getPhone());
        personalinformationsystemhistory.setPost(personalinformationsystem.getPost());
        personalinformationsystemhistory.setPurpose(personalinformationsystem.getPurpose());
        personalinformationsystemhistory.setSecuritylevelByIdSecuritylevel(personalinformationsystem.getSecuritylevelByIdSecuritylevel());
        personalinformationsystemhistory.setSeparateParts(personalinformationsystem.getSeparateParts());
        personalinformationsystemhistory.setSubdivision(personalinformationsystem.getSubdivision());
        personalinformationsystemhistory.setSurname(personalinformationsystem.getSurname());
        personalinformationsystemhistory.setThreatsResults(personalinformationsystem.getThreatsResults());
        personalinformationsystemhistory.setThreatsResultsDate(personalinformationsystem.getThreatsResultsDate());
        personalinformationsystem.setThreatsResultsNumber(personalinformationsystem.getThreatsResultsNumber());
        personalinformationsystemhistory.setTitle(personalinformationsystem.getTitle());
        personalinformationsystemhistory.setTypethreatByIdTypeThreat(personalinformationsystem.getTypethreatByIdTypeThreat());
        personalinformationsystemhistory.setYesnoByIdYesNo(personalinformationsystem.getYesnoByIdYesNo());
        personalinformationsystemhistory.setYesnoByIdyesno2(personalinformationsystem.getYesnoByIdyesno2());
        Calendar currenttime = Calendar.getInstance();
        Date sqldate = new Date((currenttime.getTime()).getTime());
        personalinformationsystemhistory.setDateUpdate(sqldate);
        getSession().save(personalinformationsystemhistory);
    }
}
