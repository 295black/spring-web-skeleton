package com.black.skeleton.biz.service.impl;

import com.black.skeleton.biz.dto.UserCreateParams;
import com.black.skeleton.biz.dto.UserDTO;
import com.black.skeleton.biz.dto.UserSearchConditions;
import com.black.skeleton.biz.entity.QUser;
import com.black.skeleton.biz.entity.User;
import com.black.skeleton.biz.mapper.UserMapper;
import com.black.skeleton.biz.repository.UserRepository;
import com.black.skeleton.biz.service.UserService;
import com.black.skeleton.common.AppException;
import com.black.skeleton.common.ErrorCode;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.Validator;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repo;

    private final UserMapper mapper;

    private final Validator validator;

    public UserServiceImpl(UserRepository repo, UserMapper mapper, Validator validator) {
        this.repo = repo;
        this.mapper = mapper;
        this.validator = validator;
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
        var user = repo.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.INVALID_ARGUMENT, "用户不存在")
        );
        repo.deleteById(id);
    }

    @Override
    public Page<UserDTO> search(UserSearchConditions userSearchConditions, Pageable pageable) {
        var u = QUser.user;
        var builder = new BooleanBuilder();
        if (userSearchConditions.getCreatedAt_GE() != null && userSearchConditions.getCreatedAt_GE() > 0 && userSearchConditions.getCreatedAt_LE() != null && userSearchConditions.getCreatedAt_LE() > 0) {
            builder.and(u.createdAt.between(userSearchConditions.getCreatedAt_GE(), userSearchConditions
                    .getCreatedAt_LE()));
        }

        if (userSearchConditions.getUpdatedAt_GE() != null && userSearchConditions.getUpdatedAt_GE() > 0 && userSearchConditions.getUpdatedAt_LE() != null && userSearchConditions.getUpdatedAt_LE() > 0) {
            builder.and(u.createdAt.between(userSearchConditions.getUpdatedAt_GE(), userSearchConditions
                    .getUpdatedAt_LE()));
        }

        if (StringUtils.hasLength(userSearchConditions.getName())) {
            builder.and(u.name.like("%" + userSearchConditions.getName() + "%"));
        }

        if (StringUtils.hasLength(userSearchConditions.getIam())) {
            builder.and(u.iam.eq(userSearchConditions.getIam()));
        }

        return repo.findAll(builder, pageable).map(mapper::toDto);
    }
}
