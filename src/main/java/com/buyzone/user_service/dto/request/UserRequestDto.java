package com.buyzone.user_service.dto.request;

import com.buyzone.user_service.enums.Gender;
import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private Gender gender;
}
