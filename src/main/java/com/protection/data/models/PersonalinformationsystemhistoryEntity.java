package com.protection.data.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by lypin on 11.05.2018.
 */
@Entity
@Table(name = "personalinformationsystemhistory", schema = "dataprotection", catalog = "")
public class PersonalinformationsystemhistoryEntity {
    private int idPersonalInformationSystemHistory;
    private String title;
    private String operator;
    private String purpose;
    private String surname;
    private String name;
    private String patronimyc;
    private String post;
    private String phone;
    private String email;
    private String legalAct;
    private String number;
    private String dateAct;
    private String subdivision;
    private String legalActAboutCreating;
    private String numberAboutCreating;
    private String dateAboutCreating;
    private String legalActAboutExploitation;
    private String numberAboutExploitation;
    private String dateAboutExploitation;
    private String commissioning;
    private String personSecuritylevel;
    private String dateSecuritylevel;
    private String cryptoProtection;
    private String separateParts;
    private String legalActRegister;
    private String numberRegister;
    private String dateRegister;
    private String threatsResults;
    private String threatsResultsDate;
    private String threatsResultsNumber;
    private String dateOfAttestation;
    private String attestation;
    private String attestationNumberLisence;
    private String attestationDate;
    private String attestationName;
    private String actAttestation;
    private String actNumberAttestation;
    private String actDateAttestation;
    private PersonaldataEntity personaldataByIdPersonalData;
    private CategoryofsubjectEntity categoryofsubjectByIdCategoryOfSubject;
    private YesnoEntity yesnoByIdYesNo;
    private CountsubjectsEntity countsubjectsByIdCountSubjects;
    private TypethreatEntity typethreatByIdTypeThreat;
    private SecuritylevelEntity securitylevelByIdSecuritylevel;
    private YesnoEntity yesnoByIdyesno2;
    private PersonalinformationsystemEntity personalinformationsystemByIdPersonalInformationSystem;
    private Date dateUpdate;
    private UsersEntity usersByIdUser;

    @Basic
    @Column(name = "dateUpdate")
    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    @Id
    @Column(name = "idPersonalInformationSystemHistory")
    public int getIdPersonalInformationSystemHistory() {
        return idPersonalInformationSystemHistory;
    }

    public void setIdPersonalInformationSystemHistory(int idPersonalInformationSystemHistory) {
        this.idPersonalInformationSystemHistory = idPersonalInformationSystemHistory;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "purpose")
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "patronimyc")
    public String getPatronimyc() {
        return patronimyc;
    }

    public void setPatronimyc(String patronimyc) {
        this.patronimyc = patronimyc;
    }

    @Basic
    @Column(name = "post")
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "legalAct")
    public String getLegalAct() {
        return legalAct;
    }

    public void setLegalAct(String legalAct) {
        this.legalAct = legalAct;
    }

    @Basic
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "dateAct")
    public String getDateAct() {
        return dateAct;
    }

    public void setDateAct(String dateAct) {
        this.dateAct = dateAct;
    }

    @Basic
    @Column(name = "subdivision")
    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    @Basic
    @Column(name = "legalActAboutCreating")
    public String getLegalActAboutCreating() {
        return legalActAboutCreating;
    }

    public void setLegalActAboutCreating(String legalActAboutCreating) {
        this.legalActAboutCreating = legalActAboutCreating;
    }

    @Basic
    @Column(name = "numberAboutCreating")
    public String getNumberAboutCreating() {
        return numberAboutCreating;
    }

    public void setNumberAboutCreating(String numberAboutCreating) {
        this.numberAboutCreating = numberAboutCreating;
    }

    @Basic
    @Column(name = "dateAboutCreating")
    public String getDateAboutCreating() {
        return dateAboutCreating;
    }

    public void setDateAboutCreating(String dateAboutCreating) {
        this.dateAboutCreating = dateAboutCreating;
    }

    @Basic
    @Column(name = "legalActAboutExploitation")
    public String getLegalActAboutExploitation() {
        return legalActAboutExploitation;
    }

    public void setLegalActAboutExploitation(String legalActAboutExploitation) {
        this.legalActAboutExploitation = legalActAboutExploitation;
    }

    @Basic
    @Column(name = "numberAboutExploitation")
    public String getNumberAboutExploitation() {
        return numberAboutExploitation;
    }

    public void setNumberAboutExploitation(String numberAboutExploitation) {
        this.numberAboutExploitation = numberAboutExploitation;
    }

    @Basic
    @Column(name = "dateAboutExploitation")
    public String getDateAboutExploitation() {
        return dateAboutExploitation;
    }

    public void setDateAboutExploitation(String dateAboutExploitation) {
        this.dateAboutExploitation = dateAboutExploitation;
    }

    @Basic
    @Column(name = "commissioning")
    public String getCommissioning() {
        return commissioning;
    }

    public void setCommissioning(String commissioning) {
        this.commissioning = commissioning;
    }

    @Basic
    @Column(name = "personSecuritylevel")
    public String getPersonSecuritylevel() {
        return personSecuritylevel;
    }

    public void setPersonSecuritylevel(String personSecuritylevel) {
        this.personSecuritylevel = personSecuritylevel;
    }

    @Basic
    @Column(name = "dateSecuritylevel")
    public String getDateSecuritylevel() {
        return dateSecuritylevel;
    }

    public void setDateSecuritylevel(String dateSecuritylevel) {
        this.dateSecuritylevel = dateSecuritylevel;
    }

    @Basic
    @Column(name = "cryptoProtection")
    public String getCryptoProtection() {
        return cryptoProtection;
    }

    public void setCryptoProtection(String cryptoProtection) {
        this.cryptoProtection = cryptoProtection;
    }

    @Basic
    @Column(name = "separateParts")
    public String getSeparateParts() {
        return separateParts;
    }

    public void setSeparateParts(String separateParts) {
        this.separateParts = separateParts;
    }

    @Basic
    @Column(name = "legalActRegister")
    public String getLegalActRegister() {
        return legalActRegister;
    }

    public void setLegalActRegister(String legalActRegister) {
        this.legalActRegister = legalActRegister;
    }

    @Basic
    @Column(name = "numberRegister")
    public String getNumberRegister() {
        return numberRegister;
    }

    public void setNumberRegister(String numberRegister) {
        this.numberRegister = numberRegister;
    }

    @Basic
    @Column(name = "dateRegister")
    public String getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(String dateRegister) {
        this.dateRegister = dateRegister;
    }

    @Basic
    @Column(name = "threatsResults")
    public String getThreatsResults() {
        return threatsResults;
    }

    public void setThreatsResults(String threatsResults) {
        this.threatsResults = threatsResults;
    }

    @Basic
    @Column(name = "threatsResultsDate")
    public String getThreatsResultsDate() {
        return threatsResultsDate;
    }

    public void setThreatsResultsDate(String threatsResultsDate) {
        this.threatsResultsDate = threatsResultsDate;
    }

    @Basic
    @Column(name = "threatsResultsNumber")
    public String getThreatsResultsNumber() {
        return threatsResultsNumber;
    }

    public void setThreatsResultsNumber(String threatsResultsNumber) {
        this.threatsResultsNumber = threatsResultsNumber;
    }

    @Basic
    @Column(name = "dateOfAttestation")
    public String getDateOfAttestation() {
        return dateOfAttestation;
    }

    public void setDateOfAttestation(String dateOfAttestation) {
        this.dateOfAttestation = dateOfAttestation;
    }

    @Basic
    @Column(name = "attestation")
    public String getAttestation() {
        return attestation;
    }

    public void setAttestation(String attestation) {
        this.attestation = attestation;
    }

    @Basic
    @Column(name = "attestationNumberLisence")
    public String getAttestationNumberLisence() {
        return attestationNumberLisence;
    }

    public void setAttestationNumberLisence(String attestationNumberLisence) {
        this.attestationNumberLisence = attestationNumberLisence;
    }

    @Basic
    @Column(name = "attestationDate")
    public String getAttestationDate() {
        return attestationDate;
    }

    public void setAttestationDate(String attestationDate) {
        this.attestationDate = attestationDate;
    }

    @Basic
    @Column(name = "attestationName")
    public String getAttestationName() {
        return attestationName;
    }

    public void setAttestationName(String attestationName) {
        this.attestationName = attestationName;
    }

    @Basic
    @Column(name = "actAttestation")
    public String getActAttestation() {
        return actAttestation;
    }

    public void setActAttestation(String actAttestation) {
        this.actAttestation = actAttestation;
    }

    @Basic
    @Column(name = "actNumberAttestation")
    public String getActNumberAttestation() {
        return actNumberAttestation;
    }

    public void setActNumberAttestation(String actNumberAttestation) {
        this.actNumberAttestation = actNumberAttestation;
    }

    @Basic
    @Column(name = "actDateAttestation")
    public String getActDateAttestation() {
        return actDateAttestation;
    }

    public void setActDateAttestation(String actDateAttestation) {
        this.actDateAttestation = actDateAttestation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalinformationsystemhistoryEntity that = (PersonalinformationsystemhistoryEntity) o;

        if (idPersonalInformationSystemHistory != that.idPersonalInformationSystemHistory) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (purpose != null ? !purpose.equals(that.purpose) : that.purpose != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (patronimyc != null ? !patronimyc.equals(that.patronimyc) : that.patronimyc != null) return false;
        if (post != null ? !post.equals(that.post) : that.post != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (legalAct != null ? !legalAct.equals(that.legalAct) : that.legalAct != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (dateAct != null ? !dateAct.equals(that.dateAct) : that.dateAct != null) return false;
        if (subdivision != null ? !subdivision.equals(that.subdivision) : that.subdivision != null) return false;
        if (legalActAboutCreating != null ? !legalActAboutCreating.equals(that.legalActAboutCreating) : that.legalActAboutCreating != null)
            return false;
        if (numberAboutCreating != null ? !numberAboutCreating.equals(that.numberAboutCreating) : that.numberAboutCreating != null)
            return false;
        if (dateAboutCreating != null ? !dateAboutCreating.equals(that.dateAboutCreating) : that.dateAboutCreating != null)
            return false;
        if (legalActAboutExploitation != null ? !legalActAboutExploitation.equals(that.legalActAboutExploitation) : that.legalActAboutExploitation != null)
            return false;
        if (numberAboutExploitation != null ? !numberAboutExploitation.equals(that.numberAboutExploitation) : that.numberAboutExploitation != null)
            return false;
        if (dateAboutExploitation != null ? !dateAboutExploitation.equals(that.dateAboutExploitation) : that.dateAboutExploitation != null)
            return false;
        if (commissioning != null ? !commissioning.equals(that.commissioning) : that.commissioning != null)
            return false;
        if (personSecuritylevel != null ? !personSecuritylevel.equals(that.personSecuritylevel) : that.personSecuritylevel != null)
            return false;
        if (dateSecuritylevel != null ? !dateSecuritylevel.equals(that.dateSecuritylevel) : that.dateSecuritylevel != null)
            return false;
        if (cryptoProtection != null ? !cryptoProtection.equals(that.cryptoProtection) : that.cryptoProtection != null)
            return false;
        if (separateParts != null ? !separateParts.equals(that.separateParts) : that.separateParts != null)
            return false;
        if (legalActRegister != null ? !legalActRegister.equals(that.legalActRegister) : that.legalActRegister != null)
            return false;
        if (numberRegister != null ? !numberRegister.equals(that.numberRegister) : that.numberRegister != null)
            return false;
        if (dateRegister != null ? !dateRegister.equals(that.dateRegister) : that.dateRegister != null) return false;
        if (threatsResults != null ? !threatsResults.equals(that.threatsResults) : that.threatsResults != null)
            return false;
        if (threatsResultsDate != null ? !threatsResultsDate.equals(that.threatsResultsDate) : that.threatsResultsDate != null)
            return false;
        if (threatsResultsNumber != null ? !threatsResultsNumber.equals(that.threatsResultsNumber) : that.threatsResultsNumber != null)
            return false;
        if (dateOfAttestation != null ? !dateOfAttestation.equals(that.dateOfAttestation) : that.dateOfAttestation != null)
            return false;
        if (attestation != null ? !attestation.equals(that.attestation) : that.attestation != null) return false;
        if (attestationNumberLisence != null ? !attestationNumberLisence.equals(that.attestationNumberLisence) : that.attestationNumberLisence != null)
            return false;
        if (attestationDate != null ? !attestationDate.equals(that.attestationDate) : that.attestationDate != null)
            return false;
        if (attestationName != null ? !attestationName.equals(that.attestationName) : that.attestationName != null)
            return false;
        if (actAttestation != null ? !actAttestation.equals(that.actAttestation) : that.actAttestation != null)
            return false;
        if (actNumberAttestation != null ? !actNumberAttestation.equals(that.actNumberAttestation) : that.actNumberAttestation != null)
            return false;
        if (actDateAttestation != null ? !actDateAttestation.equals(that.actDateAttestation) : that.actDateAttestation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPersonalInformationSystemHistory;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (purpose != null ? purpose.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (patronimyc != null ? patronimyc.hashCode() : 0);
        result = 31 * result + (post != null ? post.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (legalAct != null ? legalAct.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (dateAct != null ? dateAct.hashCode() : 0);
        result = 31 * result + (subdivision != null ? subdivision.hashCode() : 0);
        result = 31 * result + (legalActAboutCreating != null ? legalActAboutCreating.hashCode() : 0);
        result = 31 * result + (numberAboutCreating != null ? numberAboutCreating.hashCode() : 0);
        result = 31 * result + (dateAboutCreating != null ? dateAboutCreating.hashCode() : 0);
        result = 31 * result + (legalActAboutExploitation != null ? legalActAboutExploitation.hashCode() : 0);
        result = 31 * result + (numberAboutExploitation != null ? numberAboutExploitation.hashCode() : 0);
        result = 31 * result + (dateAboutExploitation != null ? dateAboutExploitation.hashCode() : 0);
        result = 31 * result + (commissioning != null ? commissioning.hashCode() : 0);
        result = 31 * result + (personSecuritylevel != null ? personSecuritylevel.hashCode() : 0);
        result = 31 * result + (dateSecuritylevel != null ? dateSecuritylevel.hashCode() : 0);
        result = 31 * result + (cryptoProtection != null ? cryptoProtection.hashCode() : 0);
        result = 31 * result + (separateParts != null ? separateParts.hashCode() : 0);
        result = 31 * result + (legalActRegister != null ? legalActRegister.hashCode() : 0);
        result = 31 * result + (numberRegister != null ? numberRegister.hashCode() : 0);
        result = 31 * result + (dateRegister != null ? dateRegister.hashCode() : 0);
        result = 31 * result + (threatsResults != null ? threatsResults.hashCode() : 0);
        result = 31 * result + (threatsResultsDate != null ? threatsResultsDate.hashCode() : 0);
        result = 31 * result + (threatsResultsNumber != null ? threatsResultsNumber.hashCode() : 0);
        result = 31 * result + (dateOfAttestation != null ? dateOfAttestation.hashCode() : 0);
        result = 31 * result + (attestation != null ? attestation.hashCode() : 0);
        result = 31 * result + (attestationNumberLisence != null ? attestationNumberLisence.hashCode() : 0);
        result = 31 * result + (attestationDate != null ? attestationDate.hashCode() : 0);
        result = 31 * result + (attestationName != null ? attestationName.hashCode() : 0);
        result = 31 * result + (actAttestation != null ? actAttestation.hashCode() : 0);
        result = 31 * result + (actNumberAttestation != null ? actNumberAttestation.hashCode() : 0);
        result = 31 * result + (actDateAttestation != null ? actDateAttestation.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idPersonalData", referencedColumnName = "idPersonalData")
    public PersonaldataEntity getPersonaldataByIdPersonalData() {
        return personaldataByIdPersonalData;
    }

    public void setPersonaldataByIdPersonalData(PersonaldataEntity personaldataByIdPersonalData) {
        this.personaldataByIdPersonalData = personaldataByIdPersonalData;
    }

    @ManyToOne
    @JoinColumn(name = "idCategoryOfSubject", referencedColumnName = "idCategoryOfSubject")
    public CategoryofsubjectEntity getCategoryofsubjectByIdCategoryOfSubject() {
        return categoryofsubjectByIdCategoryOfSubject;
    }

    public void setCategoryofsubjectByIdCategoryOfSubject(CategoryofsubjectEntity categoryofsubjectByIdCategoryOfSubject) {
        this.categoryofsubjectByIdCategoryOfSubject = categoryofsubjectByIdCategoryOfSubject;
    }

    @ManyToOne
    @JoinColumn(name = "idYesNo", referencedColumnName = "idYesNo")
    public YesnoEntity getYesnoByIdYesNo() {
        return yesnoByIdYesNo;
    }

    public void setYesnoByIdYesNo(YesnoEntity yesnoByIdYesNo) {
        this.yesnoByIdYesNo = yesnoByIdYesNo;
    }

    @ManyToOne
    @JoinColumn(name = "idCountSubjects", referencedColumnName = "idCountSubjects")
    public CountsubjectsEntity getCountsubjectsByIdCountSubjects() {
        return countsubjectsByIdCountSubjects;
    }

    public void setCountsubjectsByIdCountSubjects(CountsubjectsEntity countsubjectsByIdCountSubjects) {
        this.countsubjectsByIdCountSubjects = countsubjectsByIdCountSubjects;
    }

    @ManyToOne
    @JoinColumn(name = "idTypeThreat", referencedColumnName = "idTypeThreat")
    public TypethreatEntity getTypethreatByIdTypeThreat() {
        return typethreatByIdTypeThreat;
    }

    public void setTypethreatByIdTypeThreat(TypethreatEntity typethreatByIdTypeThreat) {
        this.typethreatByIdTypeThreat = typethreatByIdTypeThreat;
    }

    @ManyToOne
    @JoinColumn(name = "idSecuritylevel", referencedColumnName = "idSecuritylevel")
    public SecuritylevelEntity getSecuritylevelByIdSecuritylevel() {
        return securitylevelByIdSecuritylevel;
    }

    public void setSecuritylevelByIdSecuritylevel(SecuritylevelEntity securitylevelByIdSecuritylevel) {
        this.securitylevelByIdSecuritylevel = securitylevelByIdSecuritylevel;
    }

    @ManyToOne
    @JoinColumn(name = "idyesno2", referencedColumnName = "idYesNo")
    public YesnoEntity getYesnoByIdyesno2() {
        return yesnoByIdyesno2;
    }

    public void setYesnoByIdyesno2(YesnoEntity yesnoByIdyesno2) {
        this.yesnoByIdyesno2 = yesnoByIdyesno2;
    }

    @ManyToOne
    @JoinColumn(name = "idPersonalInformationSystem", referencedColumnName = "idPersonalInformationSystem")
    public PersonalinformationsystemEntity getPersonalinformationsystemByIdPersonalInformationSystem() {
        return personalinformationsystemByIdPersonalInformationSystem;
    }

    public void setPersonalinformationsystemByIdPersonalInformationSystem(PersonalinformationsystemEntity personalinformationsystemByIdPersonalInformationSystem) {
        this.personalinformationsystemByIdPersonalInformationSystem = personalinformationsystemByIdPersonalInformationSystem;
    }

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    public UsersEntity getUsersByIdUser() {
        return usersByIdUser;
    }

    public void setUsersByIdUser(UsersEntity usersByIdUser) {
        this.usersByIdUser = usersByIdUser;
    }
}
