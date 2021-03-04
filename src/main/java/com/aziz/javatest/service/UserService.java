package com.aziz.javatest.service;

import com.aziz.javatest.config.ServiceResponse;
import com.aziz.javatest.model.User;
import com.aziz.javatest.request.ActiveDeactiveUser;
import com.aziz.javatest.request.ChangePasswordRequest;
import com.aziz.javatest.request.CreateUserRequest;
import com.aziz.javatest.request.UpdateUserRequest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface UserService {
    User save(User user);

    User fetchById(int id);

    List<User> fetchAllProfiles();

    ServiceResponse createUser(CreateUserRequest request);

    ServiceResponse updateUser(UpdateUserRequest request);

    ServiceResponse changePassword(ChangePasswordRequest request);

    ServiceResponse deactiveUser(ActiveDeactiveUser request);

    Iterable<User> findAllUser(PageRequest pageRequest);

    Object searchUser(String username, String employeeNumber);
}
