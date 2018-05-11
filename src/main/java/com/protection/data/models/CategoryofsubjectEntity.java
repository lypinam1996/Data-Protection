package com.protection.data.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "categoryofsubject", schema = "dataprotection", catalog = "")
public class CategoryofsubjectEntity {
    private int idCategoryOfSubject;
    private String title;
    private List<PersonalinformationsystemEntity> personalinformationsystemsByIdCategoryOfSubject;
    private List<PersonalinformationsystemhistoryEntity> personalinformationsystemhistoriesByIdCategoryOfSubject;

    @Id
    @Column(name = "idCategoryOfSubject")
    public int getIdCategoryOfSubject() {
        return idCategoryOfSubject;
    }

    public void setIdCategoryOfSubject(int idCategoryOfSubject) {
        this.idCategoryOfSubject = idCategoryOfSubject;
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

        CategoryofsubjectEntity that = (CategoryofsubjectEntity) o;

        if (idCategoryOfSubject != that.idCategoryOfSubject) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCategoryOfSubject;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categoryofsubjectByIdCategoryOfSubject")
    public List<PersonalinformationsystemEntity> getPersonalinformationsystemsByIdCategoryOfSubject() {
        return personalinformationsystemsByIdCategoryOfSubject;
    }

    public void setPersonalinformationsystemsByIdCategoryOfSubject(List<PersonalinformationsystemEntity> personalinformationsystemsByIdCategoryOfSubject) {
        this.personalinformationsystemsByIdCategoryOfSubject = personalinformationsystemsByIdCategoryOfSubject;
    }

    @OneToMany(mappedBy = "categoryofsubjectByIdCategoryOfSubject")
    public List<PersonalinformationsystemhistoryEntity> getPersonalinformationsystemhistoriesByIdCategoryOfSubject() {
        return personalinformationsystemhistoriesByIdCategoryOfSubject;
    }

    public void setPersonalinformationsystemhistoriesByIdCategoryOfSubject(List<PersonalinformationsystemhistoryEntity> personalinformationsystemhistoriesByIdCategoryOfSubject) {
        this.personalinformationsystemhistoriesByIdCategoryOfSubject = personalinformationsystemhistoriesByIdCategoryOfSubject;
    }
}
