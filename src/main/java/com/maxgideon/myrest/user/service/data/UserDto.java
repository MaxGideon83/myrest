package com.maxgideon.myrest.user.service.data;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.maxgideon.myrest.office.entity.Office;
import com.maxgideon.myrest.user.entity.Documents;
import com.maxgideon.myrest.user.entity.User;
import com.maxgideon.myrest.user.entity.references.Countries;
import com.maxgideon.myrest.validation.Marker;

import javax.validation.constraints.NotNull;


@JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
public class UserDto {

    @NotNull(groups = Marker.UpdateObject.class)
    private long id;

    @NotNull(groups = Marker.ListObject.class)
    @NotNull(groups = Marker.SaveObject.class)
    private long officeId;

    private String docCode;

    @NotNull(groups = Marker.SaveObject.class)
    @NotNull(groups = Marker.UpdateObject.class)
    private String firstName;

    private String secondName;

    private String middleName;

    @NotNull(groups = Marker.SaveObject.class)
    @NotNull(groups = Marker.UpdateObject.class)
    private String position;

    private String phone;

    private String docName;

    private String docNumber;

    private String docDate;

    private String citizenshipName;

    private String citizenshipCode;

    private String isIdentified;

    private Documents documents;

    private Countries countries;

    private Office office;

    public UserDto() {
    }

    public UserDto(Long id, String firstName, String secondName, String middleName, String position){
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
    }
    public UserDto(User user){
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.secondName = user.getSecondName();
        this.middleName = user.getMiddleName();
        this.position = user.getPosition();
        this.phone = user.getPhone();
        if(user.getDocuments()!= null) {
            if(user.getDocuments().getDocType() != null) {
                this.docName = user.getDocuments().getDocType().getDocName();
            }
        }
        if(user.getDocuments() != null) {
            this.docNumber = user.getDocuments().getDocNumber();
            this.docDate = user.getDocuments().getDocDate();
        }
        if(user.getCountries() != null) {
            this.citizenshipName = user.getCountries().getCitizenshipName();
            this.citizenshipCode = user.getCountries().getCitizenshipCode();
        }
        this.isIdentified = user.getIsIdentified();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
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

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
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
