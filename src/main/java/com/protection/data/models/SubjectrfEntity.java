package com.protection.data.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subjectrf", schema = "dataprotection", catalog = "")
public class SubjectrfEntity {
    private int idSubject;
    private String titleSubject;
    private List<UsersEntity> users;


    @OneToMany(mappedBy = "subject")
    public List<UsersEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UsersEntity> users) {
        this.users = users;
    }

    @Id
    @Column(name = "idSubject")
    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    @Basic
    @Column(name = "titleSubject")
    public String getTitleSubject() {
        return titleSubject;
    }

    public void setTitleSubject(String titleSubject) {
        this.titleSubject = titleSubject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectrfEntity that = (SubjectrfEntity) o;

        if (idSubject != that.idSubject) return false;
        if (titleSubject != null ? !titleSubject.equals(that.titleSubject) : that.titleSubject != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSubject;
        result = 31 * result + (titleSubject != null ? titleSubject.hashCode() : 0);
        return result;
    }
}
