package com.maxgideon.myrest.organization.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.maxgideon.myrest.office.entity.Office;
import com.maxgideon.myrest.organization.service.data.OrganizationData;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Version
    private Integer version;

    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "inn")
    private String inn;

    @Column(name = "kpp")
    private String kpp;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "is_active")
    private String isActive;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "org")
    @JsonManagedReference
    private List<Office> orgOffice;

    public Organization() {

    }

    public void organizationUpdate(OrganizationData organizationData){
        this.name = organizationData.getName();
        this.fullName = organizationData.getFullName();
        this.inn = organizationData.getInn();
        this.kpp = organizationData.getKpp();
        this.address = organizationData.getAddress();
        this.phone = organizationData.getPhone();
        this.isActive = organizationData.getIsActive();
    }

    public void addOfficeToOrganization(Office of){
        if(orgOffice==null){
            orgOffice = new ArrayList<>();
        }
        orgOffice.add(of);
        of.setOrg(this);
    }

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

}
