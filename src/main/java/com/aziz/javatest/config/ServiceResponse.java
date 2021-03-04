/*============================
  ||  Author :  Ὰdithaṟῖ
  ||  Time   :  December 2018
 =============================*/

package com.aziz.javatest.config;

import com.aziz.javatest.constant.ServiceResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceResponse {
    private String responseStatus;
    private String responseMessage;

    // SR Success
    public ServiceResponse successCreate(ServiceResponse serviceResponse) {
        serviceResponse.setResponseStatus(ServiceResponseStatus.SUCCESS_CREATE.getCode());
        serviceResponse.setResponseMessage(ServiceResponseStatus.SUCCESS_CREATE.getMessage());
        return serviceResponse;
    }

    public ServiceResponse successFetch(ServiceResponse serviceResponse) {
        serviceResponse.setResponseStatus(ServiceResponseStatus.SUCCESS_FETCH.getCode());
        serviceResponse.setResponseMessage(ServiceResponseStatus.SUCCESS_FETCH.getMessage());
        return serviceResponse;
    }

    public ServiceResponse successUpdate(ServiceResponse serviceResponse) {
        serviceResponse.setResponseStatus(ServiceResponseStatus.SUCCESS_UPDATE.getCode());
        serviceResponse.setResponseMessage(ServiceResponseStatus.SUCCESS_UPDATE.getMessage());
        return serviceResponse;
    }

    public ServiceResponse successDelete(ServiceResponse serviceResponse) {
        serviceResponse.setResponseStatus(ServiceResponseStatus.SUCCESS_DELETE.getCode());
        serviceResponse.setResponseMessage(ServiceResponseStatus.SUCCESS_DELETE.getMessage());
        return serviceResponse;
    }

    // SR Fail
    public ServiceResponse failCreate(ServiceResponse serviceResponse) {
        serviceResponse.setResponseStatus(ServiceResponseStatus.FAIL_CREATE.getCode());
        serviceResponse.setResponseMessage(ServiceResponseStatus.FAIL_CREATE.getMessage());
        return serviceResponse;
    }

    public ServiceResponse failFetch(ServiceResponse serviceResponse) {
        serviceResponse.setResponseStatus(ServiceResponseStatus.FAIL_FETCH.getCode());
        serviceResponse.setResponseMessage(ServiceResponseStatus.FAIL_FETCH.getMessage());
        return serviceResponse;
    }

    public ServiceResponse failUpdate(ServiceResponse serviceResponse) {
        serviceResponse.setResponseStatus(ServiceResponseStatus.FAIL_UPDATE.getCode());
        serviceResponse.setResponseMessage(ServiceResponseStatus.FAIL_UPDATE.getMessage());
        return serviceResponse;
    }

    public ServiceResponse failDelete(ServiceResponse serviceResponse) {
        serviceResponse.setResponseStatus(ServiceResponseStatus.FAIL_DELETE.getCode());
        serviceResponse.setResponseMessage(ServiceResponseStatus.FAIL_DELETE.getMessage());
        return serviceResponse;
    }

    public ServiceResponse failExist(ServiceResponse serviceResponse) {
        serviceResponse.setResponseStatus(ServiceResponseStatus.FAIL_EXIST.getCode());
        serviceResponse.setResponseMessage(ServiceResponseStatus.FAIL_EXIST.getMessage());
        return serviceResponse;
    }

    public ServiceResponse failExistDisabled(ServiceResponse serviceResponse) {
        serviceResponse.setResponseStatus(ServiceResponseStatus.FAIL_EXIST_DISABLED.getCode());
        serviceResponse.setResponseMessage(ServiceResponseStatus.FAIL_EXIST_DISABLED.getMessage());
        return serviceResponse;
    }

    public ServiceResponse failNotFound(ServiceResponse serviceResponse) {
        serviceResponse.setResponseStatus(ServiceResponseStatus.FAIL_NOT_FOUND.getCode());
        serviceResponse.setResponseMessage(ServiceResponseStatus.FAIL_NOT_FOUND.getMessage());
        return serviceResponse;
    }

    public ServiceResponse failPasswordSame(ServiceResponse serviceResponse) {
        serviceResponse.setResponseStatus(ServiceResponseStatus.FAIL_PASSWORD_SAME.getCode());
        serviceResponse.setResponseMessage(ServiceResponseStatus.FAIL_PASSWORD_SAME.getMessage());
        return serviceResponse;
    }

}
