package com.maxgideon.myrest.organization.controller;

import com.maxgideon.myrest.organization.entity.Organization;
import com.maxgideon.myrest.organization.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/organization")
public class MyController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/list")
    public List<Organization> showAllOrganizations(){
        List<Organization> allOrganization = organizationService.getAllOrganization();
        return allOrganization;
    }

}
