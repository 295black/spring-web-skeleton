package com.black.skeleton.biz.dto;

import lombok.Data;

@Data
public class UserSearchConditions {
    private String name;

    private String iam;

    private Long createdAt_GE;

    private Long createdAt_LE;

    private Long updatedAt_GE;

    private Long updatedAt_LE;
}
