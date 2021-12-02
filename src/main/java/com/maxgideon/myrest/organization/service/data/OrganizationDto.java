package com.maxgideon.myrest.organization.service.data;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.maxgideon.myrest.validation.Marker;
import com.maxgideon.myrest.office.entity.Office;
import com.maxgideon.myrest.organization.entity.Organization;


import javax.validation.constraints.NotNull;
import java.util.List;


@JsonInclude (JsonInclude.Include.NON_NULL)
public class OrganizationDto {

    @NotNull(groups = Marker.UpdateObject.class)
    private Long id;

    @NotNull(groups = Marker.UpdateObject.class)
    @NotNull(groups = Marker.SaveObject.class)
    @NotNull(groups = Marker.ListObject.class)
    private String name;

    @NotNull(groups = Marker.UpdateObject.class)
    @NotNull(groups = Marker.SaveObject.class)
    private String fullName;

    @NotNull(groups = Marker.UpdateObject.class)
    @NotNull(groups = Marker.SaveObject.class)
    private String inn;

    @NotNull(groups = Marker.UpdateObject.class)
    @NotNull(groups = Marker.SaveObject.class)
    private String kpp;

    @NotNull(groups = Marker.UpdateObject.class)
    @NotNull(groups = Marker.SaveObject.class)
    private String address;

    private String phone;

    private String isActive;

    private List<Office> orgOffice;

    public OrganizationDto() {

    }
    public OrganizationDto(Long id, String name, String isActive ){
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public OrganizationDto(Organization org) {
        this.id = org.getId();
        this.name = org.getName();
        this.fullName = org.getFullName();
        this.inn = org.getInn();
        this.kpp = org.getKpp();
        this.address = org.getAddress();
        this.phone = org.getPhone();
        this.isActive = org.getIsActive();
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
