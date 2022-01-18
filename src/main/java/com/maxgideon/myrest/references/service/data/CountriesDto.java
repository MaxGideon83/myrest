package com.maxgideon.myrest.references.service.data;

import com.maxgideon.myrest.references.entity.Countries;

public class CountriesDto {

    private long id;

    private String citizenshipName;

    private String citizenshipCode;

    public CountriesDto() {
    }

    public CountriesDto(Countries countries) {
        this.id = countries.getId();
        this.citizenshipName = countries.getCitizenshipName();
        this.citizenshipCode = countries.getCitizenshipCode();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }
}
