package com.protection.data.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "specialists", schema = "dataprotection", catalog = "")
public class SpecialistsEntity {
    private int idSpecialist;
    private String title;
    private String surname;
    private String name;
    private String patronymic;
    private Timestamp birth;
    private String phone;
    private String email;
    private String institution;
    private String specialty;
    private String year;
    private Timestamp dateOfAppointment;
    private String reconciliation;
    private String workExperience;
    private String institution2;
    private String specialty2;
    private String periodStudy;
    private String hours;
    private String institution3;
    private String specialty3;
    private String periodStudy3;
    private String hours3;
    private Timestamp updateTime;
    private QuantityEntity quantity;
    private UsersEntity user;

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "idQuantity", referencedColumnName = "idQuantity")
    public QuantityEntity getQuantity() {
        return quantity;
    }

    public void setQuantity(QuantityEntity quantity) {
        this.quantity = quantity;
    }

    @Id
    @Column(name = "idSpecialist")
    public int getIdSpecialist() {
        return idSpecialist;
    }

    public void setIdSpecialist(int idSpecialist) {
        this.idSpecialist = idSpecialist;
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
    @Column(name = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "birth")
    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
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
    @Column(name = "institution")
    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    @Basic
    @Column(name = "specialty")
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Basic
    @Column(name = "year")
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Basic
    @Column(name = "dateOfAppointment")
    public Timestamp getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(Timestamp dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    @Basic
    @Column(name = "reconciliation")
    public String getReconciliation() {
        return reconciliation;
    }

    public void setReconciliation(String reconciliation) {
        this.reconciliation = reconciliation;
    }

    @Basic
    @Column(name = "workExperience")
    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    @Basic
    @Column(name = "institution2")
    public String getInstitution2() {
        return institution2;
    }

    public void setInstitution2(String institution2) {
        this.institution2 = institution2;
    }

    @Basic
    @Column(name = "specialty2")
    public String getSpecialty2() {
        return specialty2;
    }

    public void setSpecialty2(String specialty2) {
        this.specialty2 = specialty2;
    }

    @Basic
    @Column(name = "periodStudy")
    public String getPeriodStudy() {
        return periodStudy;
    }

    public void setPeriodStudy(String periodStudy) {
        this.periodStudy = periodStudy;
    }

    @Basic
    @Column(name = "hours")
    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    @Basic
    @Column(name = "institution3")
    public String getInstitution3() {
        return institution3;
    }

    public void setInstitution3(String institution3) {
        this.institution3 = institution3;
    }

    @Basic
    @Column(name = "specialty3")
    public String getSpecialty3() {
        return specialty3;
    }

    public void setSpecialty3(String specialty3) {
        this.specialty3 = specialty3;
    }

    @Basic
    @Column(name = "periodStudy3")
    public String getPeriodStudy3() {
        return periodStudy3;
    }

    public void setPeriodStudy3(String periodStudy3) {
        this.periodStudy3 = periodStudy3;
    }

    @Basic
    @Column(name = "hours3")
    public String getHours3() {
        return hours3;
    }

    public void setHours3(String hours3) {
        this.hours3 = hours3;
    }

    @Basic
    @Column(name = "updateTime")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecialistsEntity that = (SpecialistsEntity) o;

        if (idSpecialist != that.idSpecialist) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (patronymic != null ? !patronymic.equals(that.patronymic) : that.patronymic != null) return false;
        if (birth != null ? !birth.equals(that.birth) : that.birth != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (institution != null ? !institution.equals(that.institution) : that.institution != null) return false;
        if (specialty != null ? !specialty.equals(that.specialty) : that.specialty != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;
        if (dateOfAppointment != null ? !dateOfAppointment.equals(that.dateOfAppointment) : that.dateOfAppointment != null)
            return false;
        if (reconciliation != null ? !reconciliation.equals(that.reconciliation) : that.reconciliation != null)
            return false;
        if (workExperience != null ? !workExperience.equals(that.workExperience) : that.workExperience != null)
            return false;
        if (institution2 != null ? !institution2.equals(that.institution2) : that.institution2 != null) return false;
        if (specialty2 != null ? !specialty2.equals(that.specialty2) : that.specialty2 != null) return false;
        if (periodStudy != null ? !periodStudy.equals(that.periodStudy) : that.periodStudy != null) return false;
        if (hours != null ? !hours.equals(that.hours) : that.hours != null) return false;
        if (institution3 != null ? !institution3.equals(that.institution3) : that.institution3 != null) return false;
        if (specialty3 != null ? !specialty3.equals(that.specialty3) : that.specialty3 != null) return false;
        if (periodStudy3 != null ? !periodStudy3.equals(that.periodStudy3) : that.periodStudy3 != null) return false;
        if (hours3 != null ? !hours3.equals(that.hours3) : that.hours3 != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSpecialist;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (institution != null ? institution.hashCode() : 0);
        result = 31 * result + (specialty != null ? specialty.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (dateOfAppointment != null ? dateOfAppointment.hashCode() : 0);
        result = 31 * result + (reconciliation != null ? reconciliation.hashCode() : 0);
        result = 31 * result + (workExperience != null ? workExperience.hashCode() : 0);
        result = 31 * result + (institution2 != null ? institution2.hashCode() : 0);
        result = 31 * result + (specialty2 != null ? specialty2.hashCode() : 0);
        result = 31 * result + (periodStudy != null ? periodStudy.hashCode() : 0);
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        result = 31 * result + (institution3 != null ? institution3.hashCode() : 0);
        result = 31 * result + (specialty3 != null ? specialty3.hashCode() : 0);
        result = 31 * result + (periodStudy3 != null ? periodStudy3.hashCode() : 0);
        result = 31 * result + (hours3 != null ? hours3.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
