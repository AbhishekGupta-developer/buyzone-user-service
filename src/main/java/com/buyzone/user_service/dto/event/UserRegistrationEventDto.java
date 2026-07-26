package com.buyzone.user_service.dto.event;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegistrationEventDto {
    private String userId;
    private String name;
    private String email;
}
