package com.protection.data.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authorities", schema = "dataprotection", catalog = "")
public class AuthoritiesEntity {
    private int idAuthorities;
    private String titleAuthorities;
    private List<UsersEntity> users;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "authority")
    public List<UsersEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UsersEntity> users) {
        this.users = users;
    }

    @Id
    @Column(name = "idAuthorities")
    public int getIdAuthorities() {
        return idAuthorities;
    }

    public void setIdAuthorities(int idAuthorities) {
        this.idAuthorities = idAuthorities;
    }

    @Basic
    @Column(name = "titleAuthorities")
    public String getTitleAuthorities() {
        return titleAuthorities;
    }

    public void setTitleAuthorities(String titleAuthorities) {
        this.titleAuthorities = titleAuthorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthoritiesEntity that = (AuthoritiesEntity) o;

        if (idAuthorities != that.idAuthorities) return false;
        if (titleAuthorities != null ? !titleAuthorities.equals(that.titleAuthorities) : that.titleAuthorities != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAuthorities;
        result = 31 * result + (titleAuthorities != null ? titleAuthorities.hashCode() : 0);
        return result;
    }
}
