package com.black.skeleton.api.h5.controller;

import com.black.skeleton.api.h5.vo.UserVO;
import com.black.skeleton.biz.dto.UserCreateParams;
import com.black.skeleton.biz.dto.UserDTO;
import com.black.skeleton.biz.dto.UserSearchConditions;
import com.black.skeleton.biz.service.UserService;
import com.black.skeleton.common.PagerResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/h5/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public Optional<UserDTO> get(@RequestParam Long id) {
        return userService.get(id);
    }

    @GetMapping("/add")
    public UserDTO add(UserCreateParams userCreateParams) {
        return userService.create(userCreateParams);
    }

    @GetMapping("/search")
    public PagerResponse<UserVO> search(UserSearchConditions userSearchConditions, @SortDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        var userDTOs = userService.search(userSearchConditions, pageable);
        List<UserVO> list = new ArrayList<>();
        for (UserDTO userDTO : userDTOs) {
            var userVO = new UserVO();
            BeanUtils.copyProperties(userDTO, userVO);
            list.add(userVO);
        }
        var user = new PageImpl<>(list, userDTOs.getPageable(), userDTOs.getTotalElements());
        return new PagerResponse<>(user, pageable);
    }

    @GetMapping("/delete")
    public boolean delete(@RequestParam Long id) {
        userService.delete(id);
        return true;
    }
}
