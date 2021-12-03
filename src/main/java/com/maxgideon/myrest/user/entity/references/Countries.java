package com.maxgideon.myrest.user.entity.references;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Version
    private Integer version;

    @Column(name = "citizenship_name", unique = true)
    private String citizenshipName;

    @Column(name = "citizenship_code", unique = true)
    private String citizenshipCode;

    public Countries() {

    }

    public long getId() {
        return id;
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
