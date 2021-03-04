package com.aziz.javatest.response;

import com.aziz.javatest.config.ServiceResponse;
import com.aziz.javatest.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchUserResponse {
  private User user;
  private ServiceResponse serviceResponse;
}
