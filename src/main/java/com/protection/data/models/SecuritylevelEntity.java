package com.protection.data.models;

import javax.persistence.*;

/**
 * Created by lypin on 08.05.2018.
 */
@Entity
@Table(name = "securitylevel", schema = "dataprotection", catalog = "")
public class SecuritylevelEntity {
    private int idSecuritylevel;
    private String title;

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
}
