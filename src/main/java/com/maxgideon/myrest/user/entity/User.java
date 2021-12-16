package com.maxgideon.myrest.user.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.maxgideon.myrest.office.entity.Office;
import com.maxgideon.myrest.user.entity.references.Countries;
import javax.persistence.*;

/**
 * Пользователь
 */
@Entity
@Table(name = "user")
public class User {

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
     * Имя
     */
    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;
    /**
     * Фамилия
     */
    @Column(name = "second_name", length = 30)
    private String secondName;
    /**
     * Отчество
     */
    @Column(name = "middle_name", length = 30)
    private String middleName;
    /**
     * Должность
     */
    @Column(name = "position", nullable = false, length = 30)
    private String position;
    /**
     * Телефон
     */
    @Column(name = "phone", length = 30)
    private String phone;
    /**
     * Идентифицирован
     */
    @Column(name = "is_identified", length = 6)
    private String isIdentified;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference
    private Documents documents;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "countries_id")
    private Countries countries;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "office_id")
    @JsonBackReference
    private Office office;



    public long getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String lastName) {
        this.secondName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(String isIdentified) {
        this.isIdentified = isIdentified;
    }

    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
        documents.setUser(this);
    }

    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
