package com.black.skeleton.biz.dto;

import lombok.Data;

@Data
public class UserCreateParams {
    private String no;

    private String name;

    private String iam;

    private String avatar;
}
