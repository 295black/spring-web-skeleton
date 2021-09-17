package com.black.skeleton.api.h5.vo;

import lombok.Data;

@Data
public class UserVO {
    private Long id;

    private String name;

    private String iam;

    private String avatar;

    private Long createdAt;

    private Long updatedAt;
}
