package com.protection.data.models;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "dataprotection", catalog = "")
public class UsersEntity {
    private int idUser;
    private String login;
    private String password;
    private String mailingAddress;
    private String name;
    private String surname;
    private String patronimic;
    private String post;
    private String phone;
    private String email;
    private StatusesEntity status;
    private SubjectrfEntity subject;
    private AuthoritiesEntity authority;
    private int control;

    public int getControl() {
        return control;
    }

    public void setControl(int control) {
        this.control = control;
    }

    @ManyToOne
    @JoinColumn(name = "idAuthorities", referencedColumnName = "idAuthorities")
    public AuthoritiesEntity getAuthority() {
        return authority;
    }

    public void setAuthority(AuthoritiesEntity authority) {
        this.authority = authority;
    }

    @ManyToOne
    @JoinColumn(name = "idSubject", referencedColumnName = "idSubject")
    public SubjectrfEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectrfEntity subject) {
        this.subject = subject;
    }

    @ManyToOne
    @JoinColumn(name = "idStatus", referencedColumnName = "idStatus")
    public StatusesEntity getStatus() {
        return status;
    }

    public void setStatus(StatusesEntity status) {
        this.status = status;
    }

    @Id
    @Column(name = "idUser")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "mailingAddress")
    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "patronimic")
    public String getPatronimic() {
        return patronimic;
    }

    public void setPatronimic(String patronimic) {
        this.patronimic = patronimic;
    }

    @Basic
    @Column(name = "post")
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (idUser != that.idUser) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (mailingAddress != null ? !mailingAddress.equals(that.mailingAddress) : that.mailingAddress != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (patronimic != null ? !patronimic.equals(that.patronimic) : that.patronimic != null) return false;
        if (post != null ? !post.equals(that.post) : that.post != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (mailingAddress != null ? mailingAddress.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronimic != null ? patronimic.hashCode() : 0);
        result = 31 * result + (post != null ? post.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}