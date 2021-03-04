/*============================
  ||  Author :  Ὰdithaṟῖ
  ||  Time   :  December 2018
 =============================*/

package com.aziz.javatest.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ServiceResponseStatus {

    // Success Response
    SUCCESS_CREATE("00", "Data Successfully Created"),
    SUCCESS_FETCH("01", "Data Successfully Fetched"),
    SUCCESS_UPDATE("02", "Data Successfully Updated"),
    SUCCESS_DELETE("03", "Data Successfully Deleted"),

    // Failed Response
    FAIL_CREATE("10", "Failed to Create data"),
    FAIL_FETCH("11", "Failed to Fetch data"),
    FAIL_UPDATE("12", "Failed to Update data"),
    FAIL_DELETE("13", "Failed to Delete data"),
    FAIL_EXIST("14", "Data already exist"),
    FAIL_EXIST_DISABLED("15", "Data already exist But Disabled"),
    FAIL_NOT_FOUND("16", "Data not found"),
    FAIL_PASSWORD_SAME("17", "New Password Must Different From Old Password"),
    FAIL_EMAIL_EXIST("18", "Identity Email already exist"); //jangan dihapus

    String code;
    String message;
}
