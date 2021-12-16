package com.maxgideon.myrest.office.service.data;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.maxgideon.myrest.office.entity.Office;
import com.maxgideon.myrest.validation.Marker;
import javax.validation.constraints.NotNull;


@JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
public class OfficeDto {


    @NotNull(groups = Marker.UpdateObject.class)
    private Long id;

    @NotNull(groups = Marker.UpdateObject.class)
    private String name;

    @NotNull(groups = Marker.UpdateObject.class)
    private String address;

    private String phone;

    private String isActive;

    @NotNull(groups = Marker.SaveObject.class)
    @NotNull(groups = Marker.ListObject.class)
    private Long orgId;

    public OfficeDto() {
    }

    public OfficeDto(Office of){
        this.id = of.getId();
        this.name = of.getName();
        this.address = of.getAddress();
        this.phone = of.getPhone();
        this.isActive = of.getIsActive();
    }
    public OfficeDto(Long id, String name, String isActive){
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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * Метод для обновления свойств объекта Office свойствами объекта OfficeDto
     * @param office объект класса Office
     */
    public void officeUpdate(Office office){
        office.setName(this.getName());
        office.setAddress(this.getAddress());
        if(this.getPhone() != null) {
            office.setPhone(this.getPhone());
        }
        if(this.getIsActive() != null) {
            office.setIsActive(this.getIsActive());
        }
    }
}
