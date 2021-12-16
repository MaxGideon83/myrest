package com.maxgideon.myrest.office.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.maxgideon.myrest.organization.entity.Organization;
import com.maxgideon.myrest.user.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Офис
 */
@Entity
@Table(name="office")
public class Office {

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
     * Название офиса
     */
    @Column(name = "name")
    private String name;
    /**
     * Адрес
     */
    @Column(name = "address")
    private String address;
    /**
     * Телефон
     */
    @Column(name = "phone")
    private String phone;
    /**
     * Активность
     */
    @Column(name = "is_active")
    private String isActive;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
    @JoinColumn(name = "org_id")
    @JsonBackReference
    private Organization org;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH}, mappedBy = "office")
    @JsonManagedReference
    private List<User> users;


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Organization getOrg() {
        return org;
    }

    public void setOrg(Organization org) {
        this.org = org;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        for(User user : users){
            user.setOffice(this);
        }
    }

    public void addUserToOffice(User user){
        if(users==null){
            users = new ArrayList<>();
        }
        users.add(user);
        user.setOffice(this);
    }
}
