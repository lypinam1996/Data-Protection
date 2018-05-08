package com.protection.data.models;

import javax.persistence.*;

/**
 * Created by lypin on 08.05.2018.
 */
@Entity
@Table(name = "countsubjects", schema = "dataprotection", catalog = "")
public class CountsubjectsEntity {
    private int idCountSubjects;
    private String title;

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
}
