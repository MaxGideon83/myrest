package com.maxgideon.myrest.organization.controller;

import com.maxgideon.myrest.organization.entity.Organization;
import com.maxgideon.myrest.organization.service.OrganizationService;
import com.maxgideon.myrest.organization.service.data.OrganizationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/organization")
public class MyController {

    @Autowired
    private OrganizationService organizationService;


    @PostMapping("/list")
    public List<OrganizationData> showAllOrganizations(@RequestBody OrganizationData organizationData){
       return organizationService.getAllOrganization(organizationData);

    }
    @GetMapping("/{id}")
    public OrganizationData getOrganizationById(@PathVariable Long id){
        return organizationService.getOrganizationById(id);
    }



}
