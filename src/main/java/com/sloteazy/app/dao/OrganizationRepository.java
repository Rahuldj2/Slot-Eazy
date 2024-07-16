package com.sloteazy.app.dao;

import com.sloteazy.app.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    @Query("SELECT o.name, o.description " +
            "FROM Organization o " +
            "WHERE o.organizationId IN (" +
            "SELECT uo.organization.organizationId " +
            "FROM User u " +
            "JOIN u.userOrganizations uo " +
            "WHERE u.email = :email)")
    List<Object[]> findOrganizationDetailsByEmail(@Param("email") String email);
}
