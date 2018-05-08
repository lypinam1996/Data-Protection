package com.protection.data.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by lypin on 08.05.2018.
 */
@Entity
@Table(name = "financing", schema = "dataprotection", catalog = "")
public class FinancingEntity {
    private int idFinancing;
    private String sSThisYear;
    private String sSNextYear;
    private String nosSThisYear;
    private String nosSNextYear;
    private String personalInformationThisYear;
    private String personalInformationNextYear;
    private Timestamp updateTime;

    @Id
    @Column(name = "idFinancing")
    public int getIdFinancing() {
        return idFinancing;
    }

    public void setIdFinancing(int idFinancing) {
        this.idFinancing = idFinancing;
    }

    @Basic
    @Column(name = "sSThisYear")
    public String getsSThisYear() {
        return sSThisYear;
    }

    public void setsSThisYear(String sSThisYear) {
        this.sSThisYear = sSThisYear;
    }

    @Basic
    @Column(name = "sSNextYear")
    public String getsSNextYear() {
        return sSNextYear;
    }

    public void setsSNextYear(String sSNextYear) {
        this.sSNextYear = sSNextYear;
    }

    @Basic
    @Column(name = "nosSThisYear")
    public String getNosSThisYear() {
        return nosSThisYear;
    }

    public void setNosSThisYear(String nosSThisYear) {
        this.nosSThisYear = nosSThisYear;
    }

    @Basic
    @Column(name = "nosSNextYear")
    public String getNosSNextYear() {
        return nosSNextYear;
    }

    public void setNosSNextYear(String nosSNextYear) {
        this.nosSNextYear = nosSNextYear;
    }

    @Basic
    @Column(name = "personalInformationThisYear")
    public String getPersonalInformationThisYear() {
        return personalInformationThisYear;
    }

    public void setPersonalInformationThisYear(String personalInformationThisYear) {
        this.personalInformationThisYear = personalInformationThisYear;
    }

    @Basic
    @Column(name = "personalInformationNextYear")
    public String getPersonalInformationNextYear() {
        return personalInformationNextYear;
    }

    public void setPersonalInformationNextYear(String personalInformationNextYear) {
        this.personalInformationNextYear = personalInformationNextYear;
    }

    @Basic
    @Column(name = "updateTime")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FinancingEntity that = (FinancingEntity) o;

        if (idFinancing != that.idFinancing) return false;
        if (sSThisYear != null ? !sSThisYear.equals(that.sSThisYear) : that.sSThisYear != null) return false;
        if (sSNextYear != null ? !sSNextYear.equals(that.sSNextYear) : that.sSNextYear != null) return false;
        if (nosSThisYear != null ? !nosSThisYear.equals(that.nosSThisYear) : that.nosSThisYear != null) return false;
        if (nosSNextYear != null ? !nosSNextYear.equals(that.nosSNextYear) : that.nosSNextYear != null) return false;
        if (personalInformationThisYear != null ? !personalInformationThisYear.equals(that.personalInformationThisYear) : that.personalInformationThisYear != null)
            return false;
        if (personalInformationNextYear != null ? !personalInformationNextYear.equals(that.personalInformationNextYear) : that.personalInformationNextYear != null)
            return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFinancing;
        result = 31 * result + (sSThisYear != null ? sSThisYear.hashCode() : 0);
        result = 31 * result + (sSNextYear != null ? sSNextYear.hashCode() : 0);
        result = 31 * result + (nosSThisYear != null ? nosSThisYear.hashCode() : 0);
        result = 31 * result + (nosSNextYear != null ? nosSNextYear.hashCode() : 0);
        result = 31 * result + (personalInformationThisYear != null ? personalInformationThisYear.hashCode() : 0);
        result = 31 * result + (personalInformationNextYear != null ? personalInformationNextYear.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
