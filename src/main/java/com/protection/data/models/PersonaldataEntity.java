package com.protection.data.models;

import javax.persistence.*;

/**
 * Created by lypin on 08.05.2018.
 */
@Entity
@Table(name = "personaldata", schema = "dataprotection", catalog = "")
public class PersonaldataEntity {
    private int idPersonalData;
    private String title;

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
}
