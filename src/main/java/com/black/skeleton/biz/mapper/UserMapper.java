package com.black.skeleton.biz.mapper;

import com.black.skeleton.biz.dto.UserDTO;
import com.black.skeleton.biz.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
}