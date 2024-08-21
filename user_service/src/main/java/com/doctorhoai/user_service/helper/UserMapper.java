package com.doctorhoai.user_service.helper;

import com.doctorhoai.user_service.dto.AddressDto;
import com.doctorhoai.user_service.dto.CredentialDto;
import com.doctorhoai.user_service.dto.UserDto;
import com.doctorhoai.user_service.entity.Address;
import com.doctorhoai.user_service.entity.Credential;
import com.doctorhoai.user_service.entity.Users;

import java.util.stream.Collectors;

public class UserMapper {
    public static UserDto mapToUserDto(final Users users){
        UserDto userDto = UserDto.builder()
                .userId(users.getUserId())
                .firstName(users.getFirstName())
                .lastName(users.getLastName())
                .imageUrl(users.getImageUrl())
                .email(users.getEmail())
                .phone(users.getPhone())
                .build();
        if( users.getAddresses() != null ){
            userDto.setAddressDtos(
                    users.getAddresses().stream().map(
                            add -> AddressDto.builder()
                                    .addressId(add.getAddressId())
                                    .fullAddress(add.getFullAddress())
                                    .postalCode(add.getPostalCode())
                                    .city(add.getCity())
                                    .build()
                    ).collect(Collectors.toSet())
            );
        }
        if( users.getCredential() != null ){
            userDto.setCredentialDto(
                    CredentialDto.builder()
                            .credentialId(users.getCredential().getCredentialId())
                            .username(users.getCredential().getUsername())
                            .password(users.getCredential().getPassword())
                            .roleBasedAuthority(users.getCredential().getRoleBasedAuthority())
                            .isEnabled(users.getCredential().getIsEnabled())
                            .isAccountNoExpired(users.getCredential().getIsAccountNoExpired())
                            .isAccountNoLocked(users.getCredential().getIsAccountNoLocked())
                            .isCredentialsNonExpired(users.getCredential().getIsCredentialsNonExpired())
                            .build()
            );
        }
        return userDto;
    }

    public static Users mapToUser( final UserDto userDto){
        Users users = Users.builder()
                .userId(userDto.getUserId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .imageUrl(userDto.getImageUrl())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .build();
        if( userDto.getAddressDtos() != null ){
            users.setAddresses(
                    userDto.getAddressDtos().stream().map(
                           add -> Address.builder()
                                   .addressId(add.getAddressId())
                                   .fullAddress(add.getFullAddress())
                                   .postalCode(add.getPostalCode())
                                   .city(add.getCity())
                                   .build()
                    ).collect(Collectors.toSet())
            );
        }
        if( userDto.getCredentialDto() != null ){
            users.setCredential(
                    Credential.builder()
                            .credentialId(userDto.getCredentialDto().getCredentialId())
                            .username(userDto.getCredentialDto().getUsername())
                            .password(userDto.getCredentialDto().getPassword())
                            .roleBasedAuthority(userDto.getCredentialDto().getRoleBasedAuthority())
                            .isEnabled(userDto.getCredentialDto().getIsEnabled())
                            .isAccountNoExpired(userDto.getCredentialDto().getIsAccountNoExpired())
                            .isAccountNoLocked(userDto.getCredentialDto().getIsAccountNoLocked())
                            .isCredentialsNonExpired(userDto.getCredentialDto().getIsCredentialsNonExpired())
                            .build()
            );
        }
        return users;
    }
}
