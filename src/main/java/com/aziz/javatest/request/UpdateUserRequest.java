package com.aziz.javatest.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class UpdateUserRequest {
  @NotBlank
  @NotNull
  @Email
  private String email;
  @NotNull
  private String birthPlace;
  @NotNull
  private Date birthDate;
}
