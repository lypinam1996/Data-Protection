package com.protection.data.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "personaldata", schema = "dataprotection", catalog = "")
public class PersonaldataEntity {
    private int idPersonalData;
    private String title;
    private List<PersonalinformationsystemEntity> personalinformationsystemsByIdPersonalData;
    private List<PersonalinformationsystemhistoryEntity> personalinformationsystemhistoriesByIdPersonalData;

    @Id
    @Column(name = "idPersonalData")
    public int getIdPersonalData() {
        return idPersonalData;
    }

    public void setIdPersonalData(int idPersonalData) {
        this.idPersonalData = idPersonalData;
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

        PersonaldataEntity that = (PersonaldataEntity) o;

        if (idPersonalData != that.idPersonalData) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPersonalData;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "personaldataByIdPersonalData")
    public List<PersonalinformationsystemEntity> getPersonalinformationsystemsByIdPersonalData() {
        return personalinformationsystemsByIdPersonalData;
    }

    public void setPersonalinformationsystemsByIdPersonalData(List<PersonalinformationsystemEntity> personalinformationsystemsByIdPersonalData) {
        this.personalinformationsystemsByIdPersonalData = personalinformationsystemsByIdPersonalData;
    }

    @OneToMany(mappedBy = "personaldataByIdPersonalData")
    public List<PersonalinformationsystemhistoryEntity> getPersonalinformationsystemhistoriesByIdPersonalData() {
        return personalinformationsystemhistoriesByIdPersonalData;
    }

    public void setPersonalinformationsystemhistoriesByIdPersonalData(List<PersonalinformationsystemhistoryEntity> personalinformationsystemhistoriesByIdPersonalData) {
        this.personalinformationsystemhistoriesByIdPersonalData = personalinformationsystemhistoriesByIdPersonalData;
    }
}
