package com.protection.data.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "yesno", schema = "dataprotection", catalog = "")
public class YesnoEntity {
    private int idYesNo;
    private String title;
    private List<PersonalinformationsystemEntity> personalinformationsystemsByIdYesNo;
    private List<PersonalinformationsystemEntity> personalinformationsystemsByIdYesNo_0;
    private List<PersonalinformationsystemhistoryEntity> personalinformationsystemhistoriesByIdYesNo;
    private List<PersonalinformationsystemhistoryEntity> personalinformationsystemhistoriesByIdYesNo_0;

    @Id
    @Column(name = "idYesNo")
    public int getIdYesNo() {
        return idYesNo;
    }

    public void setIdYesNo(int idYesNo) {
        this.idYesNo = idYesNo;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YesnoEntity that = (YesnoEntity) o;

        if (idYesNo != that.idYesNo) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idYesNo;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "yesnoByIdYesNo")
    public Collection<PersonalinformationsystemEntity> getPersonalinformationsystemsByIdYesNo() {
        return personalinformationsystemsByIdYesNo;
    }

    public void setPersonalinformationsystemsByIdYesNo(List<PersonalinformationsystemEntity> personalinformationsystemsByIdYesNo) {
        this.personalinformationsystemsByIdYesNo = personalinformationsystemsByIdYesNo;
    }

    @OneToMany(mappedBy = "yesnoByIdyesno2")
    public List<PersonalinformationsystemEntity> getPersonalinformationsystemsByIdYesNo_0() {
        return personalinformationsystemsByIdYesNo_0;
    }

    public void setPersonalinformationsystemsByIdYesNo_0(List<PersonalinformationsystemEntity> personalinformationsystemsByIdYesNo_0) {
        this.personalinformationsystemsByIdYesNo_0 = personalinformationsystemsByIdYesNo_0;
    }

    @OneToMany(mappedBy = "yesnoByIdYesNo")
    public List<PersonalinformationsystemhistoryEntity> getPersonalinformationsystemhistoriesByIdYesNo() {
        return personalinformationsystemhistoriesByIdYesNo;
    }

    public void setPersonalinformationsystemhistoriesByIdYesNo(List<PersonalinformationsystemhistoryEntity> personalinformationsystemhistoriesByIdYesNo) {
        this.personalinformationsystemhistoriesByIdYesNo = personalinformationsystemhistoriesByIdYesNo;
    }

    @OneToMany(mappedBy = "yesnoByIdyesno2")
    public List<PersonalinformationsystemhistoryEntity> getPersonalinformationsystemhistoriesByIdYesNo_0() {
        return personalinformationsystemhistoriesByIdYesNo_0;
    }

    public void setPersonalinformationsystemhistoriesByIdYesNo_0(List<PersonalinformationsystemhistoryEntity> personalinformationsystemhistoriesByIdYesNo_0) {
        this.personalinformationsystemhistoriesByIdYesNo_0 = personalinformationsystemhistoriesByIdYesNo_0;
    }
}
