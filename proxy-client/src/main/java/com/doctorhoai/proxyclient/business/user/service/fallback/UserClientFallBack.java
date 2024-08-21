package com.doctorhoai.proxyclient.business.user.service.fallback;

import com.doctorhoai.proxyclient.business.user.model.UserDto;
import com.doctorhoai.proxyclient.business.user.service.UserClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserClientFallBack implements UserClientService {
    @Override
    public ResponseEntity<List<UserDto>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<UserDto> findById(Long userId) {
        return null;
    }

    @Override
    public ResponseEntity<UserDto> save(UserDto userDto) {
        return null;
    }

    @Override
    public ResponseEntity<UserDto> update(UserDto userDto) {
        return null;
    }

    @Override
    public ResponseEntity<UserDto> update(Long userId, UserDto userDto) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> deleteById(Long userId) {
        return null;
    }

    @Override
    public ResponseEntity<UserDto> findByUsername(String username) {
        return null;
    }
}
