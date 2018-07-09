package com.protection.data.models;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "official", schema = "dataprotection", catalog = "")
public class OfficialEntity {
    private int idOfficial;
    private String title;
    private String surname;
    private String name;
    private String patronymic;
    private String birth ;
    private String phone;
    private String email;
    private String institution;
    private String specialty;
    private String year;
    private String remark;
    private UsersEntity user;
    private List<OfficialhistoryEntity> officialhistory;

    @OneToMany(mappedBy = "officials")
    public List<OfficialhistoryEntity> getOfficialhistory() {
        return officialhistory;
    }

    public void setOfficialhistory(List<OfficialhistoryEntity> officialhistory) {
        this.officialhistory = officialhistory;
    }

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    @Id
    @Column(name = "idOfficial")
    public int getIdOfficial() {
        return idOfficial;
    }

    public void setIdOfficial(int idOfficial) {
        this.idOfficial = idOfficial;
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
    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
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
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfficialEntity that = (OfficialEntity) o;

        if (idOfficial != that.idOfficial) return false;
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
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOfficial;
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
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
