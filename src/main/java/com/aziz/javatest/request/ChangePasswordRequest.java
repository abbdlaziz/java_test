package com.aziz.javatest.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ChangePasswordRequest {
  @NotBlank
  @NotNull
  @Email
  private String email;
  @NotNull
  @NotBlank
  private String password;}
