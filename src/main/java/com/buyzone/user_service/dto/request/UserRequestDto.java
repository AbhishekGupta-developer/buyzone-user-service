package com.buyzone.user_service.dto.request;

import com.buyzone.user_service.enums.Gender;
import com.buyzone.user_service.enums.UserRole;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Set;

@Data
public class UserRequestDto {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    @Pattern(
            regexp = "^[A-Za-z][A-Za-z\\s]*$",
            message = "Name must start with a letter and contain only alphabets and spaces"
    )
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Size(max = 255, message = "Email cannot exceed 255 characters")
    private String email;

    @NotBlank(message = "Password is required")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#^()_+\\-=])[A-Za-z\\d@$!%*?&#^()_+\\-=]{8,16}$",
            message = "Password must be 8-16 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character"
    )
    private String password;

    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Phone number must be a valid 10-digit Indian mobile number"
    )
    private String phone;

    @NotBlank(message = "Address is required")
    @Size(min = 10, max = 255, message = "Address must be between 10 and 255 characters")
    private String address;

    @NotNull(message = "Gender is required")
    private Gender gender;

    private Set<UserRole> roles;
}
