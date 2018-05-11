package com.protection.data.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "typethreat", schema = "dataprotection", catalog = "")
public class TypethreatEntity {
    private int idTypeThreat;
    private String title;
    private List<PersonalinformationsystemEntity> personalinformationsystemsByIdTypeThreat;
    private List<PersonalinformationsystemhistoryEntity> personalinformationsystemhistoriesByIdTypeThreat;

    @Id
    @Column(name = "idTypeThreat")
    public int getIdTypeThreat() {
        return idTypeThreat;
    }

    public void setIdTypeThreat(int idTypeThreat) {
        this.idTypeThreat = idTypeThreat;
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

        TypethreatEntity that = (TypethreatEntity) o;

        if (idTypeThreat != that.idTypeThreat) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTypeThreat;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "typethreatByIdTypeThreat")
    public List<PersonalinformationsystemEntity> getPersonalinformationsystemsByIdTypeThreat() {
        return personalinformationsystemsByIdTypeThreat;
    }

    public void setPersonalinformationsystemsByIdTypeThreat(List<PersonalinformationsystemEntity> personalinformationsystemsByIdTypeThreat) {
        this.personalinformationsystemsByIdTypeThreat = personalinformationsystemsByIdTypeThreat;
    }

    @OneToMany(mappedBy = "typethreatByIdTypeThreat")
    public List<PersonalinformationsystemhistoryEntity> getPersonalinformationsystemhistoriesByIdTypeThreat() {
        return personalinformationsystemhistoriesByIdTypeThreat;
    }

    public void setPersonalinformationsystemhistoriesByIdTypeThreat(List<PersonalinformationsystemhistoryEntity> personalinformationsystemhistoriesByIdTypeThreat) {
        this.personalinformationsystemhistoriesByIdTypeThreat = personalinformationsystemhistoriesByIdTypeThreat;
    }
}
