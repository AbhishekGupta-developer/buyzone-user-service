package com.buyzone.user_service.dto.response;

import com.buyzone.user_service.enums.Gender;
import com.buyzone.user_service.enums.UserRole;
import lombok.Data;

import java.util.Set;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Gender gender;
    private Set<UserRole> roles;
}
