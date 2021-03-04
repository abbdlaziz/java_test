package com.aziz.javatest.repository;

import com.aziz.javatest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository< User, Integer > {
  User findByUsername(String username);
  User findByUsernameOrEmployeeNumber(String username,String employeeNumber);

  @Query("SELECT max(u.employeeNumber) FROM User u")
  String getMaxemployeeNumber( );
}
