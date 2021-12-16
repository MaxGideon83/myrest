package com.maxgideon.myrest.organization.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.maxgideon.myrest.office.entity.Office;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Организация
 */
@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;
    /**
     * Имя
     */
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    /**
     * Полное Имя
     */
    @Column(name = "full_name", nullable = false, length = 30)
    private String fullName;
    /**
     * ИНН
     */
    @Column(name = "inn", nullable = false, length = 30)
    private String inn;
    /**
     * КПП
     */
    @Column(name = "kpp", nullable = false, length = 30)
    private String kpp;
    /**
     * Адрес
     */
    @Column(name = "address", nullable = false, length = 60)
    private String address;
    /**
     * Телефон
     */
    @Column(name = "phone", length = 30)
    private String phone;
    /**
     * Активность
     */
    @Column(name = "is_active", length = 6)
    private String isActive;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "org")
    @JsonManagedReference
    private List<Office> orgOffice;



    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public List<Office> getOrgOffice() {
        return orgOffice;
    }

    public void setOrgOffice(List<Office> orgOffice) {
        this.orgOffice = orgOffice;
        for(Office of: orgOffice){
            of.setOrg(this);
        }
    }

    public void addOfficeToOrganization(Office of){
        if(orgOffice==null){
            orgOffice = new ArrayList<>();
        }
        orgOffice.add(of);
        of.setOrg(this);
    }

}
