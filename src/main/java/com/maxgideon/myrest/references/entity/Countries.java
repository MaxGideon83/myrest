package com.maxgideon.myrest.references.entity;

import javax.persistence.*;

/**
 * Страна
 */
@Entity
@Table(name = "countries")
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;
    /**
     * Название страны
     */
    @Column(name = "citizenship_name", unique = true, length = 30)
    private String citizenshipName;
    /**
     * Код страны
     */
    @Column(name = "citizenship_code", unique = true, length = 15)
    private String citizenshipCode;



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
