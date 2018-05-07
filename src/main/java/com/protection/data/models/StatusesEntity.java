package com.protection.data.models;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Statuses", schema = "DataProtection", catalog = "")
public class StatusesEntity {
    private int idStatus;
    private String title;
    private List<UsersEntity> users;


    @OneToMany(mappedBy = "status")
    public List<UsersEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UsersEntity> users) {
        this.users = users;
    }


    @Id
    @Column(name = "idStatus")
    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
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
        StatusesEntity that = (StatusesEntity) o;
        return idStatus == that.idStatus &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idStatus, title);
    }
}
