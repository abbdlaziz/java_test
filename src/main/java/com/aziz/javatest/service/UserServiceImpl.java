package com.aziz.javatest.service;

import com.aziz.javatest.config.ServiceResponse;
import com.aziz.javatest.model.Role;
import com.aziz.javatest.model.User;
import com.aziz.javatest.repository.RoleRepository;
import com.aziz.javatest.repository.UserRepository;
import com.aziz.javatest.request.ActiveDeactiveUser;
import com.aziz.javatest.request.ChangePasswordRequest;
import com.aziz.javatest.request.CreateUserRequest;
import com.aziz.javatest.request.UpdateUserRequest;
import com.aziz.javatest.response.SearchUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private static final ServiceResponse serviceResponse = new ServiceResponse();
    private final RoleRepository roleRepository;
    private final PasswordEncoder userPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User fetchById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    @Override
    public List<User> fetchAllProfiles() {
        return userRepository.findAll();
    }

    public ServiceResponse createUser(CreateUserRequest request){
        try {
            User newUser = new User();
            User checkUser = userRepository.findByUsername(request.getEmail());
            if(checkUser!=null){
                serviceResponse.failExist(serviceResponse);
            }else{
                newUser.setUsername(request.getEmail());
                newUser.setEmail(request.getEmail());
                newUser.setPassword(userPasswordEncoder.encode(request.getPassword()));
                Date nowDate = new Date();
                SimpleDateFormat sdfNewFormat = new SimpleDateFormat("yyyy");
                String nowYear = sdfNewFormat.format(nowDate);
                String lastEmployee = userRepository.getMaxemployeeNumber();
                Integer inc = Integer.parseInt(lastEmployee.substring(4).replaceFirst("^0+(?!$)", ""));
                String padded = String.format("%03d" ,inc+1);
                newUser.setEmployeeNumber(nowYear+padded);
                newUser.setBirthDate(request.getBirthDate());
                newUser.setBirthPlace(request.getBirthPlace());
                List<Role>roles= new ArrayList<>();
                Role role = roleRepository.findById(request.getRole());
                roles.add(role);
                newUser.setRoles(roles);
                userRepository.save(newUser);
                serviceResponse.successCreate(serviceResponse);
            }
        }catch (Exception e){
            serviceResponse.failCreate(serviceResponse);
            System.out.println(e.getMessage());
        }
        return serviceResponse;
    }

    public ServiceResponse updateUser(UpdateUserRequest request){
        try {
            User dataUser = userRepository.findByUsername(request.getEmail());
            if(dataUser==null){
                serviceResponse.failNotFound(serviceResponse);
            }else {
                dataUser.setBirthPlace(request.getBirthPlace());
                dataUser.setBirthDate(request.getBirthDate());
                userRepository.save(dataUser);
                serviceResponse.successUpdate(serviceResponse);
            }
        }catch (Exception e){
            serviceResponse.failUpdate(serviceResponse);
            System.out.println(e.getMessage());
        }
        return serviceResponse;
    }

    public ServiceResponse changePassword(ChangePasswordRequest request){
        try {
            User dataUser = userRepository.findByUsername(request.getEmail());
            if(dataUser==null){
                serviceResponse.failNotFound(serviceResponse);
            }else {
                dataUser.setPassword(userPasswordEncoder.encode(request.getPassword()));
                userRepository.save(dataUser);
                serviceResponse.successUpdate(serviceResponse);
            }
        }catch (Exception e){
            serviceResponse.failUpdate(serviceResponse);
            System.out.println(e.getMessage());
        }
        return serviceResponse;
    }

    public ServiceResponse deactiveUser(ActiveDeactiveUser request){
        try {
            User dataUser = userRepository.findByUsername(request.getEmail());
            if(dataUser==null){
                serviceResponse.failNotFound(serviceResponse);
            }else {
                if(request.getStatus().equalsIgnoreCase("active")){
                    dataUser.setEnabled(true);
                }else if (request.getStatus().equalsIgnoreCase("deactive")){
                    dataUser.setEnabled(false);
                }
                userRepository.save(dataUser);
                serviceResponse.successUpdate(serviceResponse);
            }
        }catch (Exception e){
            serviceResponse.failUpdate(serviceResponse);
            System.out.println(e.getMessage());
        }
        return serviceResponse;
    }

    @Transactional(readOnly = true)
    public Iterable<User> findAllUser(PageRequest pageRequest) {
        return userRepository.findAll(pageRequest);
    }

    public Object searchUser(String username, String employeeNumber){
        SearchUserResponse searchUserResponse =  new SearchUserResponse();
        try {
            User dataUser = userRepository.findByUsernameOrEmployeeNumber(username,employeeNumber);
            if(dataUser==null){
                searchUserResponse.setServiceResponse(serviceResponse.failNotFound(serviceResponse));
            }else {
                searchUserResponse.setUser(dataUser);
                searchUserResponse.setServiceResponse(serviceResponse.successFetch(serviceResponse));
            }
        }catch (Exception e){
            serviceResponse.failFetch(serviceResponse);
            System.out.println(e.getMessage());
        }
        return searchUserResponse;
    }


}
