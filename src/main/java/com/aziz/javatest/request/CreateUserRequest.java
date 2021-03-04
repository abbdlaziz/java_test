package com.aziz.javatest.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class CreateUserRequest {
  @NotBlank
  @NotNull
  @Email
  private String email;
  @NotNull
  @NotBlank
  private String password;
  @NotNull
  @NotBlank
  private String birthPlace;
  @NotNull
  private Date birthDate;
  @NotNull
  private Integer role;
}
