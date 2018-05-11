package com.protection.data.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by lypin on 11.05.2018.
 */
@Entity
@Table(name = "typeofcryptoprotection", schema = "dataprotection", catalog = "")
public class TypeofcryptoprotectionEntity {
    private int idtypeOfCryptoProtection;
    private String title;
    private List<StateinformationsystehistoryEntity> stateinformationsystehistoriesByIdtypeOfCryptoProtection;
    private List<StateinformationsystemEntity> stateinformationsystemsByIdtypeOfCryptoProtection;

    @Id
    @Column(name = "idtypeOfCryptoProtection")
    public int getIdtypeOfCryptoProtection() {
        return idtypeOfCryptoProtection;
    }

    public void setIdtypeOfCryptoProtection(int idtypeOfCryptoProtection) {
        this.idtypeOfCryptoProtection = idtypeOfCryptoProtection;
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

        TypeofcryptoprotectionEntity that = (TypeofcryptoprotectionEntity) o;

        if (idtypeOfCryptoProtection != that.idtypeOfCryptoProtection) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idtypeOfCryptoProtection;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "typeofcryptoprotectionByTypeofcryptoprotection")
    public List<StateinformationsystehistoryEntity> getStateinformationsystehistoriesByIdtypeOfCryptoProtection() {
        return stateinformationsystehistoriesByIdtypeOfCryptoProtection;
    }

    public void setStateinformationsystehistoriesByIdtypeOfCryptoProtection(List<StateinformationsystehistoryEntity> stateinformationsystehistoriesByIdtypeOfCryptoProtection) {
        this.stateinformationsystehistoriesByIdtypeOfCryptoProtection = stateinformationsystehistoriesByIdtypeOfCryptoProtection;
    }

    @OneToMany(mappedBy = "typeofcryptoprotectionByTypeofcryptoprotection")
    public List<StateinformationsystemEntity> getStateinformationsystemsByIdtypeOfCryptoProtection() {
        return stateinformationsystemsByIdtypeOfCryptoProtection;
    }

    public void setStateinformationsystemsByIdtypeOfCryptoProtection(List<StateinformationsystemEntity> stateinformationsystemsByIdtypeOfCryptoProtection) {
        this.stateinformationsystemsByIdtypeOfCryptoProtection = stateinformationsystemsByIdtypeOfCryptoProtection;
    }
}
