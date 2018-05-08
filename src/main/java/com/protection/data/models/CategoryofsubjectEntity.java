package com.protection.data.models;

import javax.persistence.*;

/**
 * Created by lypin on 08.05.2018.
 */
@Entity
@Table(name = "categoryofsubject", schema = "dataprotection", catalog = "")
public class CategoryofsubjectEntity {
    private int idCategoryOfSubject;
    private String title;

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
}
