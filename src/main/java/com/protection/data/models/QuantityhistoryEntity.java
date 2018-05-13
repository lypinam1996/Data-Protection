package com.protection.data.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "quantityhistory", schema = "dataprotection", catalog = "")
public class QuantityhistoryEntity {
    private int idQuantityHistory;
    private String staff;
    private String established;
    private String nonStandard;
    private String subdivision;
    private Date dateUpdate;
    private QuantityEntity quantitise;
    private UsersEntity usersByIdUser;

    @ManyToOne
    @JoinColumn(name = "idQuantity", referencedColumnName = "idQuantity")
    public QuantityEntity getQuantitise() {
        return quantitise;
    }

    public void setQuantitise(QuantityEntity quantitise) {
        this.quantitise = quantitise;
    }

    @Id
    @Column(name = "idQuantityHistory")
    public int getIdQuantityHistory() {
        return idQuantityHistory;
    }

    public void setIdQuantityHistory(int idQuantityHistory) {
        this.idQuantityHistory = idQuantityHistory;
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

    @Basic
    @Column(name = "dateUpdate")
    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuantityhistoryEntity that = (QuantityhistoryEntity) o;

        if (idQuantityHistory != that.idQuantityHistory) return false;
        if (staff != null ? !staff.equals(that.staff) : that.staff != null) return false;
        if (established != null ? !established.equals(that.established) : that.established != null) return false;
        if (nonStandard != null ? !nonStandard.equals(that.nonStandard) : that.nonStandard != null) return false;
        if (subdivision != null ? !subdivision.equals(that.subdivision) : that.subdivision != null) return false;
        if (dateUpdate != null ? !dateUpdate.equals(that.dateUpdate) : that.dateUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idQuantityHistory;
        result = 31 * result + (staff != null ? staff.hashCode() : 0);
        result = 31 * result + (established != null ? established.hashCode() : 0);
        result = 31 * result + (nonStandard != null ? nonStandard.hashCode() : 0);
        result = 31 * result + (subdivision != null ? subdivision.hashCode() : 0);
        result = 31 * result + (dateUpdate != null ? dateUpdate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    public UsersEntity getUsersByIdUser() {
        return usersByIdUser;
    }

    public void setUsersByIdUser(UsersEntity usersByIdUser) {
        this.usersByIdUser = usersByIdUser;
    }
}
