package com.protection.data.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "quantity", schema = "dataprotection", catalog = "")
public class QuantityEntity {
    private int idQuantity;
    private String staff;
    private String established;
    private String nonStandard;
    private String subdivision;
    private List<SpecialistsEntity> specialists;
    private UsersEntity user;
    private List<QuantityhistoryEntity> quantityhistory;

    @OneToMany(mappedBy = "quantitise")
    public List<QuantityhistoryEntity> getQuantityhistory() {
        return quantityhistory;
    }

    public void setQuantityhistory(List<QuantityhistoryEntity> quantityhistory) {
        this.quantityhistory = quantityhistory;
    }




    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "quantity")
    public List<SpecialistsEntity> getSpecialists() {
        return specialists;
    }

    public void setSpecialists(List<SpecialistsEntity> specialists) {
        this.specialists = specialists;
    }

    @Id
    @Column(name = "idQuantity")
    public int getIdQuantity() {
        return idQuantity;
    }

    public void setIdQuantity(int idQuantity) {
        this.idQuantity = idQuantity;
    }

    @Basic
    @Column(name = "staff")
    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    @Basic
    @Column(name = "established")
    public String getEstablished() {
        return established;
    }

    public void setEstablished(String established) {
        this.established = established;
    }

    @Basic
    @Column(name = "nonStandard")
    public String getNonStandard() {
        return nonStandard;
    }

    public void setNonStandard(String nonStandard) {
        this.nonStandard = nonStandard;
    }

    @Basic
    @Column(name = "subdivision")
    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuantityEntity that = (QuantityEntity) o;

        if (idQuantity != that.idQuantity) return false;
        if (staff != null ? !staff.equals(that.staff) : that.staff != null) return false;
        if (established != null ? !established.equals(that.established) : that.established != null) return false;
        if (nonStandard != null ? !nonStandard.equals(that.nonStandard) : that.nonStandard != null) return false;
        if (subdivision != null ? !subdivision.equals(that.subdivision) : that.subdivision != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idQuantity;
        result = 31 * result + (staff != null ? staff.hashCode() : 0);
        result = 31 * result + (established != null ? established.hashCode() : 0);
        result = 31 * result + (nonStandard != null ? nonStandard.hashCode() : 0);
        result = 31 * result + (subdivision != null ? subdivision.hashCode() : 0);
        return result;
    }
}
