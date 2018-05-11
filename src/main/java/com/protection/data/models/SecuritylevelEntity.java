package com.protection.data.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "securitylevel", schema = "dataprotection", catalog = "")
public class SecuritylevelEntity {
    private int idSecuritylevel;
    private String title;
    private List<PersonalinformationsystemEntity> personalinformationsystemsByIdSecuritylevel;
    private List<PersonalinformationsystemhistoryEntity> personalinformationsystemhistoriesByIdSecuritylevel;

    @Id
    @Column(name = "idSecuritylevel")
    public int getIdSecuritylevel() {
        return idSecuritylevel;
    }

    public void setIdSecuritylevel(int idSecuritylevel) {
        this.idSecuritylevel = idSecuritylevel;
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

        SecuritylevelEntity that = (SecuritylevelEntity) o;

        if (idSecuritylevel != that.idSecuritylevel) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSecuritylevel;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "securitylevelByIdSecuritylevel")
    public List<PersonalinformationsystemEntity> getPersonalinformationsystemsByIdSecuritylevel() {
        return personalinformationsystemsByIdSecuritylevel;
    }

    public void setPersonalinformationsystemsByIdSecuritylevel(List<PersonalinformationsystemEntity> personalinformationsystemsByIdSecuritylevel) {
        this.personalinformationsystemsByIdSecuritylevel = personalinformationsystemsByIdSecuritylevel;
    }

    @OneToMany(mappedBy = "securitylevelByIdSecuritylevel")
    public List<PersonalinformationsystemhistoryEntity> getPersonalinformationsystemhistoriesByIdSecuritylevel() {
        return personalinformationsystemhistoriesByIdSecuritylevel;
    }

    public void setPersonalinformationsystemhistoriesByIdSecuritylevel(List<PersonalinformationsystemhistoryEntity> personalinformationsystemhistoriesByIdSecuritylevel) {
        this.personalinformationsystemhistoriesByIdSecuritylevel = personalinformationsystemhistoriesByIdSecuritylevel;
    }
}
