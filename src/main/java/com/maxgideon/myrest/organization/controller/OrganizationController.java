package com.maxgideon.myrest.organization.controller;


import com.maxgideon.myrest.exception.ResponseResult;
import com.maxgideon.myrest.organization.service.OrganizationService;
import com.maxgideon.myrest.validation.Marker;
import com.maxgideon.myrest.organization.service.data.OrganizationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@Validated
@RequestMapping("api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @Validated({Marker.ListObject.class})
    @PostMapping("/list")
    public List<OrganizationDto> showAllOrganizations(@RequestBody @Valid OrganizationDto organizationDto){
       return organizationService.getAllOrganization(organizationDto);

    }

    @GetMapping("/{id}")
    public OrganizationDto getOrganizationById(@PathVariable Long id) {
        return  organizationService.getOrganizationById(id);
    }

    @Validated({Marker.SaveObject.class})
    @PostMapping("/save")
    public void saveOrganization(@RequestBody @Valid OrganizationDto organizationDto){
        organizationService.saveOrganization(organizationDto);
    }

    @Validated({Marker.UpdateObject.class})
    @PostMapping("/update")
    public void updateOrganizations(@RequestBody @Valid OrganizationDto organizationDto){
        organizationService.updateOrganization(organizationDto);
    }



}
