package com.maxgideon.myrest.organization.controller;


import com.fasterxml.jackson.databind.node.ObjectNode;
import com.maxgideon.myrest.organization.service.OrganizationService;
import com.maxgideon.myrest.organization.service.data.OrganizationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/organization")
public class MyController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/list")
    public List<OrganizationData> showAllOrganizations(){
       return organizationService.getAllOrganization();

    }


}
