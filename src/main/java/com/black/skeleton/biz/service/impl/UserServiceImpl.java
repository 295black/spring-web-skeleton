package com.black.skeleton.biz.service.impl;

import com.black.skeleton.biz.dto.UserCreateParams;
import com.black.skeleton.biz.dto.UserDTO;
import com.black.skeleton.biz.entity.User;
import com.black.skeleton.biz.mapper.UserMapper;
import com.black.skeleton.biz.repository.UserRepository;
import com.black.skeleton.biz.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repo;

    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repo, UserMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public Optional<UserDTO> get(Long id) {
        return repo.findById(id).map(mapper::toDto);
    }

    @Override
    public UserDTO create(UserCreateParams params) {
        var u = new User();
        u.setName(params.getName());
        u.setAvatar(params.getAvatar());
        u.setIam(params.getIam());
        repo.save(u);
        return mapper.toDto(u);
    }

    public void delete(Long id) {

    }
}
