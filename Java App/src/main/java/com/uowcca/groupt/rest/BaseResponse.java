package com.uowcca.groupt.rest;

import lombok.Data;

@Data
public class BaseResponse {
    private Integer status = 501;
    private String message = "";
}
