package com.doctorhoai.user_service.service;

import com.doctorhoai.user_service.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto findById(final Long userId);
    UserDto save(final UserDto userDto);
    UserDto update(final UserDto userDto);
    UserDto update(final Long userId, final UserDto userDto);
    void deleteById(final Long userId);
    UserDto findByUsername(final String username);
}
