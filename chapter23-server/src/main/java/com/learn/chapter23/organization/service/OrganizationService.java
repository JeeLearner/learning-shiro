package com.learn.chapter23.organization.service;

import com.learn.chapter23.organization.entity.Organization;

import java.util.List;

public interface OrganizationService {
    public Organization createOrganization(Organization organization);
    public Organization updateOrganization(Organization organization);
    public void deleteOrganization(Long organizationId);

    Organization findOne(Long organizationId);
    List<Organization> findAll();

    Object findAllWithExclude(Organization excludeOraganization);

    void move(Organization source, Organization target);
}
