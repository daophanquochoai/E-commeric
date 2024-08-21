package com.doctorhoai.user_service.service.impl;

import com.doctorhoai.user_service.dto.UserDto;
import com.doctorhoai.user_service.entity.Users;
import com.doctorhoai.user_service.exception.ObjectNotFound;
import com.doctorhoai.user_service.helper.UserMapper;
import com.doctorhoai.user_service.repository.UserRepository;
import com.doctorhoai.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public List<UserDto> findAll() {
        return repository.findAll().stream().map(UserMapper::mapToUserDto).distinct().collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long userId) {
        return UserMapper.mapToUserDto(
                repository.findById(userId).orElseThrow(
                        () -> new ObjectNotFound("User not found with id : " + userId)
                )
        );
    }

    @Override
    public UserDto save(UserDto userDto) {
        return UserMapper.mapToUserDto(repository.save(UserMapper.mapToUser(userDto)));
    }

    @Override
    public UserDto update(UserDto userDto) {
        return UserMapper.mapToUserDto(repository.save(UserMapper.mapToUser(userDto)));
    }

    @Override
    public UserDto update(Long userId, UserDto userDto) {
        Users user = repository.findById(userId).orElseThrow(
                () -> new ObjectNotFound("User not found with id : " + userId)
        );
        if( userDto.getFirstName() != null ){
            user.setFirstName(userDto.getFirstName());
        }
        if( userDto.getLastName() != null ){
            user.setLastName(userDto.getLastName());
        }
        if( userDto.getEmail() != null ){
            user.setEmail(userDto.getEmail());
        }
        if( userDto.getPhone() != null ){
            user.setPhone(userDto.getPhone());
        }
        if( userDto.getImageUrl() != null ){
            user.setImageUrl(userDto.getImageUrl());
        }
        return UserMapper.mapToUserDto(repository.save(user));
    }

    @Override
    public void deleteById(Long userId) {
        repository.findById(userId).orElseThrow(
                () -> new ObjectNotFound("User not found with id : " + userId)
        );
        repository.deleteById(userId);
    }

    @Override
    public UserDto findByUsername(String username) {
        return UserMapper.mapToUserDto(
                repository.findByCredentialUsername(username).orElseThrow(
                        () ->  new ObjectNotFound("User not found with username : " + username)
                )
        );
    }
}
