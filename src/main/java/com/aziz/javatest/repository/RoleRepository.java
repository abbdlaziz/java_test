package com.aziz.javatest.repository;

import com.aziz.javatest.model.Role;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long>, JpaSpecificationExecutor<Role> {
  Role findById(Integer id);
}
