package com.protection.data.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "countsubjects", schema = "dataprotection", catalog = "")
public class CountsubjectsEntity {
    private int idCountSubjects;
    private String title;
    private List<PersonalinformationsystemEntity> personalinformationsystemsByIdCountSubjects;
    private List<PersonalinformationsystemhistoryEntity> personalinformationsystemhistoriesByIdCountSubjects;

    @Id
    @Column(name = "idCountSubjects")
    public int getIdCountSubjects() {
        return idCountSubjects;
    }

    public void setIdCountSubjects(int idCountSubjects) {
        this.idCountSubjects = idCountSubjects;
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

        CountsubjectsEntity that = (CountsubjectsEntity) o;

        if (idCountSubjects != that.idCountSubjects) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCountSubjects;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "countsubjectsByIdCountSubjects")
    public List<PersonalinformationsystemEntity> getPersonalinformationsystemsByIdCountSubjects() {
        return personalinformationsystemsByIdCountSubjects;
    }

    public void setPersonalinformationsystemsByIdCountSubjects(List<PersonalinformationsystemEntity> personalinformationsystemsByIdCountSubjects) {
        this.personalinformationsystemsByIdCountSubjects = personalinformationsystemsByIdCountSubjects;
    }

    @OneToMany(mappedBy = "countsubjectsByIdCountSubjects")
    public List<PersonalinformationsystemhistoryEntity> getPersonalinformationsystemhistoriesByIdCountSubjects() {
        return personalinformationsystemhistoriesByIdCountSubjects;
    }

    public void setPersonalinformationsystemhistoriesByIdCountSubjects(List<PersonalinformationsystemhistoryEntity> personalinformationsystemhistoriesByIdCountSubjects) {
        this.personalinformationsystemhistoriesByIdCountSubjects = personalinformationsystemhistoriesByIdCountSubjects;
    }
}
