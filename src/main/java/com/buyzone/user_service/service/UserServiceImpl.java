package com.buyzone.user_service.service;

import com.buyzone.user_service.dto.request.UserRequestDto;
import com.buyzone.user_service.dto.response.GenericResponseDto;
import com.buyzone.user_service.dto.response.UserResponseDto;
import com.buyzone.user_service.entity.User;
import com.buyzone.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDto registerUser(UserRequestDto userRequestDto) {
        User user = mapUserRequestDtoToUser(new User(), userRequestDto);
        userRepository.save(user);
        return mapUserToUserResponseDto(user);
    }

    @Override
    public UserResponseDto getUser(Long id) {
        return null;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public GenericResponseDto removeUser(Long id) {
        return null;
    }

    // helper method

    // map UserRequestDto to User
    private User mapUserRequestDtoToUser(User user, UserRequestDto userRequestDto) {
       user.setName(userRequestDto.getName());
       user.setEmail(userRequestDto.getEmail());
       user.setPassword(userRequestDto.getPassword());
       user.setPhone(userRequestDto.getPhone());
       user.setAddress(userRequestDto.getAddress());
       user.setGender(userRequestDto.getGender());

       return user;
    }

    // map User to UserResponseDto
    private UserResponseDto mapUserToUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPhone(user.getPhone());
        userResponseDto.setAddress(user.getAddress());
        userResponseDto.setGender(user.getGender());

        return userResponseDto;
    }
}
