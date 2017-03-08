package org.myspring.repository;

import org.myspring.models.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long>{

	Role findRoleByName(@Param("name") String name);
}

