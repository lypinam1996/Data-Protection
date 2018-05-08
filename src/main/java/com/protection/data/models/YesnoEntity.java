package com.protection.data.models;

import javax.persistence.*;

/**
 * Created by lypin on 08.05.2018.
 */
@Entity
@Table(name = "yesno", schema = "dataprotection", catalog = "")
public class YesnoEntity {
    private int idYesNo;
    private String title;

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
}
