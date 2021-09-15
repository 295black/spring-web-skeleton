package com.black.skeleton.biz.service;

import com.black.skeleton.biz.dto.UserCreateParams;
import com.black.skeleton.biz.dto.UserDTO;

import java.util.Optional;

public interface UserService {
    Optional<UserDTO> get(Long id);

    UserDTO create(UserCreateParams params);

    void delete(Long id);
}
