package com.sloteazy.app.controller;


import com.sloteazy.app.models.Organization;
import com.sloteazy.app.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Organizations")
public class OrganizationController {
    private final OrganizationService organizationService;
    @Autowired
    public OrganizationController(OrganizationService organizationService)
    {
        this.organizationService=organizationService;
    }

    @GetMapping("/getAllOrganizations")
    public List<Organization> getAllOrganizations()
    {
        return organizationService.getAllOrganizations();
    }

    @GetMapping("/getOrgByEmail")
    public List<Object[]> getOrganizationDetailsByEmail(@RequestParam String email) {
        return organizationService.getOrganizationDetailsByEmail(email);
    }
    @PostMapping("/createOrganization")
    public Organization createOrganization(@RequestBody Organization organization)
    {
        return organizationService.saveOrganization(organization);
    }

}
