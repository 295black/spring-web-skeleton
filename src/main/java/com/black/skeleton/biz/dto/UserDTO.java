package com.black.skeleton.biz.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;

    private String name;

    private String iam;

    private String avatar;

    private Long createdAt;

    private Long updatedAt;

}
