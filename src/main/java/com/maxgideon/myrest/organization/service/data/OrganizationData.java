package com.maxgideon.myrest.organization.service.data;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.maxgideon.myrest.office.entity.Office;

import java.util.List;

@JsonInclude (JsonInclude.Include.NON_NULL)
public class OrganizationData {

    private Long id;

    private String name;

    private String fullName;

    private String inn;

    private String kpp;

    private String address;

    private String phone;

    private String isActive;

    private List<Office> orgOffice;

    public OrganizationData() {

    }
    public OrganizationData(Long id, String name, String isActive ){
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    }

}
