package com.sloteazy.app.service;

import com.sloteazy.app.dao.OrganizationRepository;
import com.sloteazy.app.models.Organization;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrganizationServiceImpl implements OrganizationService{


    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository)
    {
        this.organizationRepository=organizationRepository;
    }
    @Override
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization saveOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public List<Object[]> getOrganizationDetailsByEmail(String email) {
        return organizationRepository.findOrganizationDetailsByEmail(email);
    }

}
