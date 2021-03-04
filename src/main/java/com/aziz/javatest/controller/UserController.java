package com.aziz.javatest.controller;

import com.aziz.javatest.config.ServiceResponse;
import com.aziz.javatest.model.User;
import com.aziz.javatest.request.ActiveDeactiveUser;
import com.aziz.javatest.request.ChangePasswordRequest;
import com.aziz.javatest.request.CreateUserRequest;
import com.aziz.javatest.request.UpdateUserRequest;
import com.aziz.javatest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('create_user')")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User fetch(@RequestParam int userId) {
        return userService.fetchById(userId);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_admin')")
    public List<User> fetch() {
        return userService.fetchAllProfiles();
    }

    @PostMapping(path = "/createUser")
    @PreAuthorize("hasAuthority('create_user')")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ServiceResponse createUser(
            @RequestBody @Valid CreateUserRequest request
    ) {
        return userService.createUser(request);
    }

    @PostMapping(path = "/updateUser")
    @PreAuthorize("hasAuthority('update_user')")
    @ResponseStatus(value = HttpStatus.OK)
    public ServiceResponse updateUser(
            @RequestBody @Valid UpdateUserRequest request
    ) {
        return userService.updateUser(request);
    }

    @PostMapping(path = "/changePassword")
    @PreAuthorize("hasAuthority('update_user')")
    @ResponseStatus(value = HttpStatus.OK)
    public ServiceResponse changePassword(
            @RequestBody @Valid ChangePasswordRequest request
    ) {
        return userService.changePassword(request);
    }

    @PostMapping(path = "/activeDeactiveUser")
    @PreAuthorize("hasAuthority('update_user')")
    @ResponseStatus(value = HttpStatus.OK)
    public ServiceResponse activeDeactiveUser(
            @RequestBody @Valid ActiveDeactiveUser request
    ) {
        return userService.deactiveUser(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/getAllUser")
    @PreAuthorize("hasAuthority('read_user')")
    public Iterable<User> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "count", defaultValue = "10", required = false) int count,
            @RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
            @RequestParam(value = "sort", defaultValue = "id", required = false) String sortProperty){
        return userService.findAllUser(PageRequest.of(page, count, new Sort(direction, sortProperty)));
    }

    @PostMapping(path = "/searchUser")
    @PreAuthorize("hasAuthority('read_user')")
    @ResponseStatus(value = HttpStatus.OK)
    public Object searchUser(
            @RequestParam(value = "email", defaultValue = "", required = false) String email,
            @RequestParam(value = "employeeNumber", defaultValue = "", required = false) String employeeNumber
    ) {
        return userService.searchUser(email,employeeNumber);
    }

}
