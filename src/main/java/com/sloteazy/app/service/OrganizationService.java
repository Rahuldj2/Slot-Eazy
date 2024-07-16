package com.sloteazy.app.service;

import com.sloteazy.app.models.Organization;

import java.util.List;

public interface OrganizationService {
    List<Organization> getAllOrganizations();
    Organization saveOrganization(Organization organization);
    List<Object[]> getOrganizationDetailsByEmail(String email);
}
